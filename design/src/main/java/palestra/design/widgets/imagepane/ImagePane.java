package palestra.design.widgets.imagepane;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import palestra.design.R;
import palestra.design.widgets.imagepane.items.ImagePaneItem;

import static android.view.Gravity.CENTER;

public class ImagePane extends LinearLayout {

    /*** Public interfaces */
    public interface OnItemClickListener {
        void onItemClick(ImagePaneItem item);
    }

    public interface OnClusterClickListener {
        void onClusterClick();
    }

    private interface AddItemCallBack {
        void onItemAdded(int itemsSize);
    }


    private interface RemoveItemCallBack {
        void onItemRemoved(int itemsSize, int itemRemovedIndex, boolean isVisibleItem);
    }

    /*** Default values */
    private static final int DEFAULT_IMAGE_SIZE_DP = 44;
    private static final int DEFAULT_IMAGE_BACKGROUND_COLOR = 0XFFEEDDFF;
    private static final int DEFAULT_CLUSTER_SIZE_DP = 44;
    private static final int DEFAULT_CLUSTER_TEXT_SIZE_SP = 16;
    private static final int DEFAULT_CLUSTER_TEXT_STYLE = Typeface.NORMAL;
    private static final Typeface DEFAULT_CLUSTER_TEXT_FONT = Typeface.DEFAULT;
    private static final int DEFAULT_CLUSTER_TEXT_COLOR = 0XFFF56313;  //orange color;
    private static final int DEFAULT_CLUSTER_BACKGROUND_COLOR = 0XFF56FFEF;  //white color
    private static final int DEFAULT_SHOW_ITEMS_COUNT = 2;
    private static final int DEFAULT_CORNER_RADIUS = 10;

    private static final int DEFAULT_CLUSTER_TEXT_LINES_COUNT = 1;

    private static final String DEFAULT_TEXT_FORMAT = "+%s";

    /*** Views */
    private TextView clusterTextView;
    private CardView rootBoxCluster;

    /*** Param fields */
    private int imageSizeDp = DEFAULT_IMAGE_SIZE_DP;
    private Drawable imageStubLoadingDrawable;
    private int imageBackground = DEFAULT_IMAGE_BACKGROUND_COLOR;
    private float imageCornerRadius = DEFAULT_CORNER_RADIUS;
    private int clusterSizeDp = DEFAULT_CLUSTER_SIZE_DP;
    private int clusterTextSizeSp = DEFAULT_CLUSTER_TEXT_SIZE_SP;
    private int clusterTextColor = DEFAULT_CLUSTER_TEXT_COLOR;
    private int clusterTextStyle = DEFAULT_CLUSTER_TEXT_STYLE;
    private Typeface clusterTextFont = DEFAULT_CLUSTER_TEXT_FONT;
    private int clusterBackground = DEFAULT_CLUSTER_BACKGROUND_COLOR;
    private float clusterCornerRadius = DEFAULT_CORNER_RADIUS;
    private int showItemsCount = DEFAULT_SHOW_ITEMS_COUNT;
    private int maxHeightItemBox = Math.max(imageSizeDp, clusterSizeDp);

    private OnItemClickListener onItemClickListener;
    private OnClusterClickListener onClusterClickListener;

    private List<View> allVisibleViews = new ArrayList<>();
    private List<ImagePaneItem> items = new ArrayList<>();

    private AddItemCallBack addItemCallBack = (newSize) -> {
        updateCounterText(newSize - showItemsCount, true, true);

        //Нужно искать ближайший Gone элемент
        for (int i = 0; i < allVisibleViews.size(); i++) {
            if (allVisibleViews.get(i).getVisibility() == View.GONE) {
                updatePanelState(newSize, i);

                return;
            }
        }

        updatePanelState(newSize, items.size() - 1);
    };

    private RemoveItemCallBack removeItemCallBack = (newSize, itemRemovedIndex, isVisibleItem) -> {
        if (isVisibleItem) {
            //Удалился видимый пользователю элемент и имееются скрытые элементы

            CardView rootView = (CardView) allVisibleViews.get(itemRemovedIndex);
            ImageView imageBox = (ImageView) rootView.getChildAt(0);

            animateHideView(true, isVisibleItem, rootView);
            animateHideView(false, isVisibleItem, rootView);
            configureGlide(imageBox, items.get(itemRemovedIndex).getImgSource());
        }

        updateCounterText(newSize - showItemsCount, false, true);
        updatePanelState(newSize, itemRemovedIndex);
    };


    public void setItems(List<ImagePaneItem> newItems) {
        this.items.clear();
        this.items.addAll(newItems);

        hideAllVisibleItems();
        showSetterItems(newItems.size());
    }

    public void addItem(ImagePaneItem item) {
        this.items.add(item);
        addItemCallBack.onItemAdded(this.items.size());
    }

    public void removeItem(ImagePaneItem item) {
        int itemIndex = items.indexOf(item);
        if (itemIndex != -1) {
            removeItem(itemIndex);
        }
    }

    public void removeItem(int itemRemovedIndex) {
        if (items.size() - 1 > showItemsCount - 1 && itemRemovedIndex < showItemsCount - 1) {
            //Удалился видимый пользователю элемент и имееются скрытые элементы

            //выполняем перестановку элементов
            int indexInvisibleItem = showItemsCount;
            items.add(itemRemovedIndex, items.get(indexInvisibleItem));

            items.remove(indexInvisibleItem + 1);
            items.remove(itemRemovedIndex + 1);

            removeItemCallBack.onItemRemoved(items.size(), itemRemovedIndex, true);
        } else {
            if (itemRemovedIndex >= items.size()) {
                items.remove(items.size() - 1);
            } else {
                items.remove(itemRemovedIndex);
            }

            removeItemCallBack.onItemRemoved(items.size(), itemRemovedIndex, false);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnClusterClickListener(OnClusterClickListener onClusterClickListener) {
        this.onClusterClickListener = onClusterClickListener;
    }

    /*** Public constructors */
    public ImagePane(Context context) {
        this(context, null);
    }

    public ImagePane(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImagePane(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
        init(context);

        if (isInEditMode()) {
            createEditModeLayout();
        }
    }

    private void initAttr(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImagePane);
        for (int attrIndex = 0; attrIndex < typedArray.getIndexCount(); attrIndex++) {
            int attr = typedArray.getIndex(attrIndex);
            if (attr == R.styleable.ImagePane_ip_image_size) {
                imageSizeDp = typedArray.getDimensionPixelSize(attr, DEFAULT_IMAGE_SIZE_DP);
                maxHeightItemBox = Math.max(imageSizeDp, clusterSizeDp);
            } else if (attr == R.styleable.ImagePane_ip_image_stub_loading) {
                imageStubLoadingDrawable = typedArray.getDrawable(attr);
            } else if (attr == R.styleable.ImagePane_ip_image_background) {
                imageBackground = typedArray.getResourceId(attr, DEFAULT_IMAGE_BACKGROUND_COLOR);
            } else if (attr == R.styleable.ImagePane_ip_image_corner_radius) {
                imageCornerRadius = typedArray.getFloat(attr, DEFAULT_CORNER_RADIUS);
            } else if (attr == R.styleable.ImagePane_ip_cluster_size) {
                clusterSizeDp = typedArray.getDimensionPixelSize(attr, DEFAULT_CLUSTER_SIZE_DP);
                maxHeightItemBox = Math.max(imageSizeDp, clusterSizeDp);
            } else if (attr == R.styleable.ImagePane_ip_cluster_text_size) {
                clusterTextSizeSp = typedArray.getDimensionPixelSize(attr, sp2px(context, DEFAULT_CLUSTER_TEXT_SIZE_SP));
            } else if (attr == R.styleable.ImagePane_ip_cluster_text_color) {
                clusterTextColor = typedArray.getColor(attr, DEFAULT_CLUSTER_TEXT_COLOR);
            } else if (attr == R.styleable.ImagePane_ip_cluster_text_style) {
                clusterTextStyle = typedArray.getInt(attr, DEFAULT_CLUSTER_TEXT_STYLE);
            } else if (attr == R.styleable.ImagePane_ip_cluster_text_font) {
                if (!isInEditMode()) {
                    final int fontId = typedArray.getResourceId(attr, -1);
                    clusterTextFont = ResourcesCompat.getFont(context, fontId);
                }
            } else if (attr == R.styleable.ImagePane_ip_cluster_background_color) {
                clusterBackground = typedArray.getColor(attr, DEFAULT_CLUSTER_BACKGROUND_COLOR);
            } else if (attr == R.styleable.ImagePane_ip_cluster_corner_radius) {
                clusterCornerRadius = typedArray.getFloat(attr, DEFAULT_CORNER_RADIUS);
            } else if (attr == R.styleable.ImagePane_ip_show_items_count) {
                showItemsCount = typedArray.getInt(attr, DEFAULT_SHOW_ITEMS_COUNT);
            } else if (attr == R.styleable.ImagePane_ip_on_item_click) {
                //todo
            } else if (attr == R.styleable.ImagePane_ip_on_cluster_click) {
                //todo
            }
        }

        typedArray.recycle();
    }

    private void init(Context context) {
        if (!isInEditMode()) {
            generateAllVisibleViews();
        }
    }

    private void generateAllVisibleViews() {
        //Generate All Show Views
        for (int i = 0; i < showItemsCount; i++) {
            final View view = createRootBox(createImageBox());
            view.setVisibility(View.INVISIBLE);

            allVisibleViews.add(view);
            addView(view);
        }

        //Add ClusterItem
        final View clusterView = createRootBoxCluster();
        clusterView.setVisibility(View.INVISIBLE);
        allVisibleViews.add(clusterView);
        addView(clusterView);
    }

    private void hideAllVisibleItems() {
        for (View item : allVisibleViews) {
            item.setVisibility(INVISIBLE);
        }
    }

    private void showSetterItems(int itemsCount) {
        //Show Setter Items
        for (int i = 0; i < itemsCount; i++) {
            if (i < showItemsCount) {
                CardView rootView = (CardView) allVisibleViews.get(i);
                rootView.setVisibility(View.VISIBLE);
                ImageView imageBox = (ImageView) rootView.getChildAt(0);

                animateSetNewItems(rootView, i);

                configureGlide(imageBox, items.get(i).getImgSource());
            } else {
                //Last element -> Always 'CardView'
                int lastElementIndex = allVisibleViews.size() - 1;

                CardView clusterView = (CardView) allVisibleViews.get(lastElementIndex);
                clusterView.setVisibility(View.VISIBLE);

                animateSetNewItems(clusterView, i);

                final int hideItemsCount = itemsCount - showItemsCount;
                updateCounterText(hideItemsCount, true, true);
                break;
            }
        }
    }

    private void createEditModeLayout() {
        //Add Photo Box
        for (int i = 0; i < showItemsCount; ++i) {
            final View view = createRootBox(createImageBox());
            allVisibleViews.add(view);

            addView(view);
        }

        //Add Cluster Box
        final View clusterView = createRootBoxCluster();
        allVisibleViews.add(clusterView);

        addView(clusterView);
    }

    private CardView createRootBox(ImageView childView) {
        final CardView rootBox = new CardView(getContext());

        final LinearLayout.LayoutParams rootBoxParams = new LinearLayout.LayoutParams(
                imageSizeDp,
                imageSizeDp
        );

        rootBox.setRadius(imageCornerRadius);
        rootBox.setLayoutParams(rootBoxParams);

        rootBox.addView(childView);

        rootBox.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(items.get(allVisibleViews.indexOf(rootBox)));
            }
        });

        return rootBox;
    }

    private ImageView createImageBox() {
        final ImageView imageBox = new ImageView(getContext());
        final FrameLayout.LayoutParams boxParams = new FrameLayout.LayoutParams(
                imageSizeDp,
                imageSizeDp
        );
        imageBox.setImageResource(imageBackground);
        imageBox.setLayoutParams(boxParams);

        return imageBox;
    }

    private CardView createRootBoxCluster() {
        rootBoxCluster = new CardView(getContext());

        final LinearLayout.LayoutParams rootBoxClusterParams = new LinearLayout.LayoutParams(
                clusterSizeDp,
                clusterSizeDp
        );
        rootBoxCluster.setLayoutParams(rootBoxClusterParams);

        rootBoxCluster.setRadius(clusterCornerRadius);
        rootBoxCluster.setCardBackgroundColor(clusterBackground);

        rootBoxCluster.addView(createClusterText());


        rootBoxCluster.setOnClickListener(view -> {
            if (onClusterClickListener != null) {
                onClusterClickListener.onClusterClick();
            }
        });

        return rootBoxCluster;
    }


    private TextView createClusterText() {
        clusterTextView = new TextView(getContext());
        if (isInEditMode())
            clusterTextView.setText(String.format(DEFAULT_TEXT_FORMAT, String.valueOf(15)));

        final FrameLayout.LayoutParams clusterTextViewParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        clusterTextViewParams.gravity = CENTER;
        clusterTextView.setLayoutParams(clusterTextViewParams);

        clusterTextView.setTextColor(clusterTextColor);
        clusterTextView.setTextSize(clusterTextSizeSp);
        clusterTextView.setMaxLines(DEFAULT_CLUSTER_TEXT_LINES_COUNT);

        clusterTextView.setTypeface(/*isInEditMode() ?*/
//                Typeface.defaultFromStyle(clusterTextStyle) :
                Typeface.create(clusterTextFont, clusterTextStyle));
        clusterTextView.setEllipsize(TextUtils.TruncateAt.END);

        return clusterTextView;
    }

    private void updatePanelState(int itemsCount, int indexViewForUpdate) {
        if (itemsCount < 0) return;

        if (itemsCount > showItemsCount) {
            final View clusterView = allVisibleViews.get(allVisibleViews.size() - 1);
            if (clusterView.getVisibility() == View.INVISIBLE || clusterView.getVisibility() == View.GONE) {
                animateHideView(false, false, clusterView);
            }
        } else {
            final View clusterView = allVisibleViews.get(allVisibleViews.size() - 1);
            if (clusterView.getVisibility() == View.VISIBLE) {
                animateHideView(true, false, clusterView);
            } else {
                if (indexViewForUpdate > items.size()) {
                    indexViewForUpdate = items.size();
                }

                final View imageItemView = allVisibleViews.get(indexViewForUpdate);
                if (imageItemView.getVisibility() == View.VISIBLE) {
                    animateHideView(true, true, imageItemView);
                } else {
                    final View preImageItemView = allVisibleViews.get(indexViewForUpdate);
                    animateHideView(false, false, preImageItemView);

                    //Loading New Image
                    updateImage(preImageItemView, itemsCount - 1);
                }
            }
        }
    }

    private void updateCounterText(int hideItemsCount, boolean increment, boolean needAnimate) {
        if (needAnimate) {
            animateTextView(hideItemsCount, increment, clusterTextView);
        } else {
            clusterTextView.setText(String.format(DEFAULT_TEXT_FORMAT, String.valueOf(hideItemsCount)));
        }
    }

    /**
     * Animations
     */

    public void animateTextView(int currentValue, boolean increment, final TextView textview) {
        final int ANIM_DURATION = 70;
        final float TRANSLATION_DISTANCE = clusterSizeDp - dp2px(getContext(), 30);

        textview.animate()
                .alpha(0.05f)
                .setDuration(ANIM_DURATION)
                .translationY(increment ? -TRANSLATION_DISTANCE : TRANSLATION_DISTANCE)
                .setInterpolator(new LinearInterpolator())
                .withEndAction(() -> {
                    textview.setTranslationY(increment ? TRANSLATION_DISTANCE : -TRANSLATION_DISTANCE);
                    textview.animate()
                            .alpha(1f)
                            .translationY(0f)
                            .setDuration(ANIM_DURATION)
                            .setInterpolator(new LinearInterpolator())
                            .withStartAction(() -> textview.setText(String.format(DEFAULT_TEXT_FORMAT, String.valueOf(currentValue))))
                            .start();
                }).start();
    }

    public void animateHideView(boolean hide, boolean needGone, final View view) {
        final int ANIM_DURATION = 150;

        final float ANIM_SCALE_DEFAULT = 1f;
        final float ANIM_SCALE_MIN = 0.5f;
        final float ANIM_ALPHA_DEFAULT = 1f;
        final float ANIM_ALPHA_MIN = 0.05f;
        final float ANIM_TRANSLATION_X_DEFAULT = 0f;
        final float ANIM_TRANSLATION_X_MIN = -100f;

        view.setVisibility(VISIBLE);
        view.setScaleX(hide ? ANIM_SCALE_DEFAULT : ANIM_SCALE_MIN);
        view.setScaleY(hide ? ANIM_SCALE_DEFAULT : ANIM_SCALE_MIN);
        view.setTranslationX(hide ? ANIM_TRANSLATION_X_DEFAULT : ANIM_TRANSLATION_X_MIN);

        view.animate()
                .setStartDelay(0L)
                .alpha(hide ? ANIM_ALPHA_MIN : ANIM_ALPHA_DEFAULT)
                .scaleX(hide ? ANIM_SCALE_MIN : ANIM_SCALE_DEFAULT)
                .scaleY(hide ? ANIM_SCALE_MIN : ANIM_SCALE_DEFAULT)
                .translationX(hide ? ANIM_TRANSLATION_X_MIN : ANIM_TRANSLATION_X_DEFAULT)
                .setDuration(ANIM_DURATION)
                .setInterpolator(new LinearInterpolator())
                .withEndAction(() -> {
                    if (hide) {
                        view.setVisibility(needGone ? View.GONE : View.INVISIBLE);
                    }
                }).start();
    }

    public void animateSetNewItems(final View view, final int indexElement) {
        final int ANIM_DURATION = 150;

        final float ANIM_TRANSLATION_X_DEFAULT = 0f;

        final float ANIM_SCALE_DEFAULT = 1f;
        final float ANIM_SCALE_MIN = 0.5f;
        final float ANIM_ALPHA_DEFAULT = 1f;
        final float ANIM_TRANSLATION_Y_DEFAULT = 0f;
        final float ANIM_TRANSLATION_Y_MIN = maxHeightItemBox;
        final float ANIM_TRANSLATION_X_MIN = -maxHeightItemBox;

        //set Default Values
        view.setAlpha(0.05f);
        view.setScaleX(ANIM_SCALE_MIN);
        view.setScaleY(ANIM_SCALE_MIN);
        view.setTranslationY(ANIM_TRANSLATION_Y_MIN);
        view.setTranslationX(ANIM_TRANSLATION_X_MIN);

        view.animate()
                .setStartDelay(ANIM_DURATION * indexElement)
                .alpha(ANIM_ALPHA_DEFAULT)
                .scaleX(ANIM_SCALE_DEFAULT)
                .scaleY(ANIM_SCALE_DEFAULT)
                .translationY(ANIM_TRANSLATION_Y_DEFAULT)
                .translationX(ANIM_TRANSLATION_X_DEFAULT)
                .setDuration(ANIM_DURATION)
                .setInterpolator(new LinearInterpolator())
                .start();
    }

    private void updateImage(View preView, int itemIndex) {
        CardView rootView = (CardView) preView;
        ImageView imageBox = (ImageView) rootView.getChildAt(0);

        configureGlide(imageBox, items.get(itemIndex).getImgSource());
    }

    private void configureGlide(ImageView imageView, String imgUrl) {
        if (imageStubLoadingDrawable == null) {
            throw new Resources.NotFoundException("Image stub must be initialed");
        }

        RequestOptions options = new RequestOptions()
                .placeholder(imageStubLoadingDrawable)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(imageView).load(imgUrl)
                .apply(options)
                .into(imageView);
    }


    /**
     * Utils
     */
    private int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    private int dp2px(Context context, float dpValue) {
        final float densityScale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * densityScale + 0.5f);
    }
}

