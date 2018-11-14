package dahei.me.xiaobai.mainpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dahei.me.xiaobai.BaseFragment;
import dahei.me.xiaobai.R;
import dahei.me.xiaobai.adapter.CommonAdapter;
import dahei.me.xiaobai.adapter.ViewHolder;
import dahei.me.xiaobai.model.ChatItem;
import dahei.me.xiaobai.model.ContactMan;

/**
 * created by yubosu
 * 2018年11月08日4:03 PM
 */
public class ContactsFragment extends BaseFragment {


    @BindView(R.id.listViewContacts)
    ListView listViewContacts;
    Unbinder unbinder;

    private CommonAdapter commonAdapter;
    private List<ContactMan> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        testData();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initView() {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.layout_contacts_head, null);
        listViewContacts.addHeaderView(view, null, false);
        if(commonAdapter == null) {
            commonAdapter = new CommonAdapter<ContactMan>(getContext(), list, R.layout.layout_item_bar) {
                @Override
                public void convert(ViewHolder helper, final ContactMan item, int position) {
                    helper.setText(R.id.textTitle, item.getName());
                    helper.setViewVisibility(R.id.lineBottom, View.VISIBLE);
                }
            };
        }
        listViewContacts.setAdapter(commonAdapter);
        view.findViewById(R.id.newFriends).setOnClickListener(onClickListener);
        view.findViewById(R.id.tags).setOnClickListener(onClickListener);
        view.findViewById(R.id.officialAccounts).setOnClickListener(onClickListener);
        view.findViewById(R.id.groupChats).setOnClickListener(onClickListener);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tags:
                    listViewContacts.smoothScrollToPosition(5);
                    break;
                case R.id.newFriends:
                    listViewContacts.smoothScrollToPosition(10);
                    break;
                case R.id.officialAccounts:
                    listViewContacts.smoothScrollToPosition(15);
                    break;
                case R.id.groupChats:
                    listViewContacts.smoothScrollToPosition(20);
                    break;
            }
        }
    };

    private void testData() {
        if(list.isEmpty()) {
            for (int i = 0; i < 30; i++) {
                ContactMan contactMan = new ContactMan();
                contactMan.setName("你哈" + i);
                list.add(contactMan);
            }
        }
        updateView();
    }

    public void updateView() {
        commonAdapter.notifyDataSetChanged();
    }
}
