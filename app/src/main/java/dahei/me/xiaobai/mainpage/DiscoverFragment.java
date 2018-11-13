package dahei.me.xiaobai.mainpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dahei.me.xiaobai.BaseFragment;
import dahei.me.xiaobai.R;
import dahei.me.xiaobai.model.DiscoverItem;
import dahei.me.xiaobai.utils.BaiLog;
import dahei.me.xiaobai.utils.ScreenUtils;
import dahei.me.xiaobai.widget.CommonSpace;
import dahei.me.xiaobai.widget.ItemBarLayout;

/**
 * created by yubosu
 * 2018年11月08日4:03 PM
 */
public class DiscoverFragment extends BaseFragment {


    @BindView(R.id.linearDiscoverContainer)
    LinearLayout linearDiscoverContainer;
    Unbinder unbinder;
    private List<DiscoverItem> discoverItems = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        unbinder = ButterKnife.bind(this, view);
        updateView();
        return view;
    }

    private void updateView() {
        if (discoverItems.isEmpty()) {
            discoverItems.add(new DiscoverItem("friends", getString(R.string.moments),0));
            discoverItems.add(new DiscoverItem("scan",  getString(R.string.scans),1));
            discoverItems.add(new DiscoverItem("shake",  getString(R.string.shake),1));
            discoverItems.add(new DiscoverItem("nearby",  getString(R.string.nearby),2));
            discoverItems.add(new DiscoverItem("piaoliu",  getString(R.string.message_in_bottle),2));
            discoverItems.add(new DiscoverItem("miniprogram",  getString(R.string.mini_programs),3));
        }
        refreshView();
    }

    private void refreshView() {
        linearDiscoverContainer.removeAllViews();
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(R.dimen.layout_item_height));
        boolean hasLine;
        for (int i = 0; i < discoverItems.size(); i++) {
            if (i == 0) {
                CommonSpace commonSpace = new CommonSpace(getContext());
                linearDiscoverContainer.addView(commonSpace);
                hasLine = false;
            }else if(i == discoverItems.size() - 1 ||
                    discoverItems.get(i).getGroup() != discoverItems.get(i + 1).getGroup()) {
                hasLine = false;
            } else {
                hasLine = true;
            }
            ItemBarLayout itemBarLayout = new ItemBarLayout(getContext());
            itemBarLayout.setData(
                    discoverItems.get(i).getDrawableName(),
                    discoverItems.get(i).getTitle(),
                    hasLine);
            itemBarLayout.setBackgroundResource(R.drawable.common_white_btn_selector);
            linearDiscoverContainer.addView(itemBarLayout, layoutParams);
            itemBarLayout.setTag(discoverItems.get(i));
            itemBarLayout.setOnClickListener(onClickListener);

            if (!hasLine) {
                CommonSpace commonSpace = new CommonSpace(getContext());
                linearDiscoverContainer.addView(commonSpace);
            }
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getTag() instanceof DiscoverItem) {
                BaiLog.c("DiscoverFragment", "onClick", ((DiscoverItem) v.getTag()).getDrawableName());
            }
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
