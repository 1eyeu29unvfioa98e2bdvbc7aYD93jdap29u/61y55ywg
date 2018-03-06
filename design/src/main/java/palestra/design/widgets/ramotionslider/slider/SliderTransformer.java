package palestra.design.widgets.ramotionslider.slider;

import android.view.View;

public class SliderTransformer extends BaseTransformer {
    private static final float ROT_MOD = -15f;

    private static final float INACTIVE_SCALE = 1.1f;
    private static final float INACTIVE_ALPHA = 0.7f;

    @Override
    protected void onTransform(View view, float position) {
        final float width = view.getWidth();
        final float rotation = ROT_MOD * position;

        view.setPivotX(width * 0.5f);
        view.setPivotY(0f);
        view.setTranslationX(0f);
        view.setRotation(rotation);

        if (position < -1) {
            view.setAlpha(INACTIVE_ALPHA);
            view.setScaleX(INACTIVE_SCALE);
            view.setScaleY(INACTIVE_SCALE);
        } else if (position <= 1) {
            float scale = INACTIVE_SCALE + (1 - INACTIVE_SCALE) * (1 - Math.abs(position));
            float alpha = INACTIVE_ALPHA + (1 - INACTIVE_ALPHA) * (1 - Math.abs(position));
            view.setScaleX(scale);
            view.setScaleY(scale);
            view.setAlpha(alpha);
        } else {
            view.setAlpha(INACTIVE_ALPHA);
            view.setScaleX(INACTIVE_SCALE);
            view.setScaleY(INACTIVE_SCALE);
        }
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }

    @Override
    protected boolean hideOffscreenPages() {
        return false;
    }
}
