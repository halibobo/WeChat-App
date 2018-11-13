package dahei.me.xiaobai.mainpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dahei.me.xiaobai.BaseFragment;
import dahei.me.xiaobai.R;

/**
 * created by yubosu
 * 2018年11月08日4:03 PM
 */
public class MeFragment extends BaseFragment {


    @BindView(R.id.imageViewAvatar)
    ImageView imageViewAvatar;
    @BindView(R.id.textNickName)
    TextView textNickName;
    @BindView(R.id.textId)
    TextView textId;
    @BindView(R.id.imageCode)
    ImageView imageCode;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.itemWallet, R.id.itemFavorite, R.id.itemPosts, R.id.itemCards,R.id.layoutInformation, R.id.itemSticker, R.id.itemSetting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layoutInformation:
                break;
            case R.id.itemWallet:
                break;
            case R.id.itemFavorite:
                break;
            case R.id.itemPosts:
                break;
            case R.id.itemCards:
                break;
            case R.id.itemSticker:
                break;
            case R.id.itemSetting:
                break;
        }
    }
}
