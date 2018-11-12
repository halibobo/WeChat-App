package dahei.me.xiaobai.mainpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dahei.me.xiaobai.BaseFragment;
import dahei.me.xiaobai.R;
import dahei.me.xiaobai.adapter.CommonAdapter;

/**
 * created by yubosu
 * 2018年11月08日4:03 PM
 */
public class MeFragment extends BaseFragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
