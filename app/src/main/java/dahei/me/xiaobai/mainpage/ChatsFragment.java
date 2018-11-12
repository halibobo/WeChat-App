package dahei.me.xiaobai.mainpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import dahei.me.xiaobai.data.ChatsController;
import dahei.me.xiaobai.model.ChatItem;

/**
 * created by yubosu
 * 2018年11月08日4:03 PM
 */
public class ChatsFragment extends BaseFragment {


    @BindView(R.id.chatsListView)
    ListView chatsListView;
    Unbinder unbinder;

    private List<ChatItem> chatItems = new ArrayList<>();
    private CommonAdapter mChartsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        testData();
    }

    private void initAdapter() {
        if(mChartsAdapter == null) {
            mChartsAdapter = new CommonAdapter<ChatItem>(getContext(), chatItems, R.layout.listview_chats) {
                @Override
                public void convert(ViewHolder helper, final ChatItem item, int position) {
                    helper.setText(R.id.chat_cont, item.getCont());
                    helper.setText(R.id.chat_head, item.getHead());
                    helper.setText(R.id.chat_time, item.getTime());
                    helper.setViewVisibility(R.id.chat_is_notification, item.isNotification() ? View.VISIBLE : View.GONE);
                    helper.setViewVisibility(R.id.chat_image_tip, item.isTip() ? View.VISIBLE : View.GONE);
                }
            };
        }
        chatsListView.setAdapter(mChartsAdapter);
        chatsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        chatsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }

    private void testData() {
        if(chatItems.isEmpty()) {
            chatItems.addAll(ChatsController.getChatItems());
            updateView();
        }
    }

    public void updateView() {
        mChartsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
