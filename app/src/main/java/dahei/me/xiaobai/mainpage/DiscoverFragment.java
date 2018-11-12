package dahei.me.xiaobai.mainpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dahei.me.xiaobai.BaseFragment;
import dahei.me.xiaobai.R;

/**
 * created by yubosu
 * 2018年11月08日4:03 PM
 */
public class DiscoverFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discover, container, false);
    }
}
