package dahei.me.alphatabview;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yubosu
 * 2018年11月09日10:05 AM
 */
public class TabIndicatorView extends LinearLayout {

    private ViewPager viewPager;
    private int currentItem;
    private int childCount;
    private List<TabView> tabViews = new ArrayList<>();

    public TabIndicatorView(Context context) {
        super(context);
    }

    public TabIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TabIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        init();
    }

    private void init() {
        if (this.viewPager == null) {
            throw new IllegalArgumentException("viewpager 不能为空");
        }

        childCount = getChildCount();
        if (childCount != viewPager.getAdapter().getCount()) {
            throw new IllegalArgumentException("Tab数量必须和viewpager子数量相同" + childCount + "--" + viewPager.getAdapter().getCount());
        }

        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) instanceof TabView) {
                TabView tabView = (TabView) getChildAt(i);
                tabViews.add(tabView);
                tabView.setOnClickListener(new TabOnListener(i));
            }
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (v > 0) {
                    tabViews.get(i).setIconAlpha(1 - v);
                    tabViews.get(i + 1).setIconAlpha(v);
                }
                //滑动时保存当前按钮索引
                currentItem = i;
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        tabViews.get(currentItem).setIconAlpha(1.0f);
    }


    private class TabOnListener implements OnClickListener {

        private int currentIndex;

        public TabOnListener(int i) {
            this.currentIndex = i;
        }

        @Override
        public void onClick(View v) {
            resetState();
            tabViews.get(currentIndex).setIconAlpha(1.0f);
            viewPager.setCurrentItem(currentIndex, false);
            currentItem = currentIndex;
        }
    }

    private void resetState() {
        for (int i = 0; i < childCount; i++) {
            tabViews.get(i).setIconAlpha(0);
        }
    }

    private static final String STATE_INSTANCE = "instance_state";
    private static final String STATE_ITEM = "state_item";

    /**
     * @return 当View被销毁的时候，保存数据
     */
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_INSTANCE, super.onSaveInstanceState());
        bundle.putInt(STATE_ITEM, currentItem);
        return bundle;
    }

    /**
     * @param state 用于恢复数据使用
     */
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            currentItem = bundle.getInt(STATE_ITEM);
            resetState();
            tabViews.get(currentItem).setIconAlpha(1.0f);
            super.onRestoreInstanceState(bundle.getParcelable(STATE_INSTANCE));
        } else {
            super.onRestoreInstanceState(state);
        }
    }
}
