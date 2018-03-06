package palestra.design.widgets.ramotionslider.dots;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import palestra.design.R;

public class DotIndicator extends LinearLayoutCompat {

    private static final float NO_SCALE = 1f;
    private static final int DEF_VALUE = 10;
    private static final int DEF_ICON = R.drawable.dot_default;

    private static final int UNSELECTED_ANIM_DURATION = 600;
    private static final int SELECTED_ANIM_DURATION = 200;

    private int mItemDefaultColor = Color.WHITE;
    private int mItemSelectedColor = Color.WHITE;
    private int mPageCount;
    private int mSelectedIndex;
    private float mItemScale = NO_SCALE;
    private int mItemSize = DEF_VALUE;
    private int mDelimiterSize = DEF_VALUE;
    private int mItemIcon = DEF_VALUE;

    @NonNull
    private final List<ImageView> mIndexImages = new ArrayList<>();
    @Nullable
    private ViewPager.OnPageChangeListener mListener;

    public DotIndicator(@NonNull final Context context) {
        this(context, null);
    }

    public DotIndicator(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DotIndicator(@NonNull final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        final TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DotIndicator, 0, 0);
        try {
            mItemSize = attributes.getDimensionPixelSize(R.styleable.DotIndicator_itemSize, DEF_VALUE);
            mItemScale = attributes.getFloat(R.styleable.DotIndicator_itemScale, NO_SCALE);
            mItemSelectedColor = attributes.getColor(R.styleable.DotIndicator_itemSelectedTint, Color.WHITE);
            mItemDefaultColor = attributes.getColor(R.styleable.DotIndicator_itemTint, Color.WHITE);
            mDelimiterSize = attributes.getDimensionPixelSize(R.styleable.DotIndicator_delimiterSize, DEF_VALUE);
            mItemIcon = attributes.getResourceId(R.styleable.DotIndicator_itemIcon, DEF_ICON);
        } finally {
            attributes.recycle();
        }
        if (isInEditMode()) {
            createEditModeLayout();
        }
    }

    private void createEditModeLayout() {
        for (int i = 0; i < 5; ++i) {
            final FrameLayout boxedItem = createBoxedItem(i);
            addView(boxedItem);
            if (i == 1) {
                final View item = boxedItem.getChildAt(0);
                final ViewGroup.LayoutParams layoutParams = item.getLayoutParams();
                layoutParams.height *= mItemScale;
                layoutParams.width *= mItemScale;
                item.setLayoutParams(layoutParams);
            }
        }
    }

    public void setupWithViewPager(@NonNull final ViewPager viewPager) {
        setPageCount(viewPager.getAdapter().getCount());
        viewPager.addOnPageChangeListener(new OnPageChangeListener());
    }

    public void addOnPageChangeListener(final ViewPager.OnPageChangeListener listener) {
        mListener = listener;
    }

    private void setSelectedIndex(final int selectedIndex) {
        if (selectedIndex < 0 || selectedIndex > mPageCount - 1) {
            return;
        }

        final ImageView unselectedView = mIndexImages.get(mSelectedIndex);
        unselectedView.animate().scaleX(NO_SCALE).scaleY(NO_SCALE).setDuration(UNSELECTED_ANIM_DURATION).start();
        unselectedView.setColorFilter(mItemDefaultColor, android.graphics.PorterDuff.Mode.SRC_IN);

        final ImageView selectedView = mIndexImages.get(selectedIndex);
        selectedView.animate().scaleX(mItemScale).scaleY(mItemScale).setDuration(SELECTED_ANIM_DURATION).start();
        selectedView.setColorFilter(mItemSelectedColor, android.graphics.PorterDuff.Mode.SRC_IN);

        mSelectedIndex = selectedIndex;
    }

    private void setPageCount(final int pageCount) {
        mPageCount = pageCount;
        mSelectedIndex = 0;
        removeAllViews();
        mIndexImages.clear();

        for (int i = 0; i < pageCount; ++i) {
            addView(createBoxedItem(i));
        }

        setSelectedIndex(mSelectedIndex);
    }

    @NonNull
    private FrameLayout createBoxedItem(final int position) {
        final FrameLayout box = new FrameLayout(getContext());
        final ImageView item = createItem();
        box.addView(item);
        mIndexImages.add(item);

        final LinearLayoutCompat.LayoutParams boxParams = new LinearLayoutCompat.LayoutParams(
                (int) (mItemSize * mItemScale + 0.5f),
                (int) (mItemSize * mItemScale + 0.5f)
        );
        if (position > 0) {
            boxParams.setMargins(mDelimiterSize, 0, 0, 0);
        }
        box.setLayoutParams(boxParams);
        return box;
    }

    @NonNull
    private ImageView createItem() {
        final ImageView index = new ImageView(getContext());
        final FrameLayout.LayoutParams indexParams = new FrameLayout.LayoutParams(
                mItemSize,
                mItemSize
        );
        indexParams.gravity = Gravity.CENTER;
        index.setLayoutParams(indexParams);
        index.setImageResource(mItemIcon);
        index.setScaleType(ImageView.ScaleType.FIT_CENTER);
        index.setColorFilter(mItemDefaultColor, android.graphics.PorterDuff.Mode.SRC_IN);
        return index;
    }

    private class OnPageChangeListener
            implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
            if (mListener != null) {
                mListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(final int position) {
            setSelectedIndex(position);
            if (mListener != null) {
                mListener.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(final int state) {
            if (mListener != null) {
                mListener.onPageScrollStateChanged(state);
            }
        }
    }
}
