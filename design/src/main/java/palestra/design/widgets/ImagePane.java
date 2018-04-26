package palestra.design.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import palestra.design.R;

public class ImagePane extends LinearLayout {

    //todo: Width==Height => минимальному значению


    public ImagePane(Context context) {
        super(context);
        init(context);
    }

    public ImagePane(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(context, attrs);
        init(context);
    }

    public ImagePane(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
        init(context);
    }

    private void initAttr(Context context, AttributeSet attrs) {
        if(attrs == null) {
            return;
        }

//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImagePane);
//        for(int attrIndex = 0; attrIndex < typedArray.getIndexCount(); attrIndex++) {
//            if (attrIndex == R.styleable.ImagePane_ip_image_size) {
//
//            }
//        }
    }

    private void init(Context context) {

    }
}
