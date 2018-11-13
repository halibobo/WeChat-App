package dahei.me.xiaobai.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import dahei.me.xiaobai.R;
import dahei.me.xiaobai.utils.ScreenUtils;


/**
 * created by yubosu
 * 2018年11月13日3:42 PM
 */
public class CommonSpace extends View {

    public CommonSpace(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CommonSpace(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommonSpace(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtils.getScreenWidth(getContext()),
                (int)getResources().getDimension(R.dimen.space_common));
    }


}
