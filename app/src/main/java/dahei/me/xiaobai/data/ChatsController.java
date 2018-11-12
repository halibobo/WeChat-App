package dahei.me.xiaobai.data;

import java.util.ArrayList;
import java.util.List;

import dahei.me.xiaobai.model.ChatItem;

/**
 * created by yubosu
 * 2018年11月09日3:41 PM
 */
public class ChatsController {

    private static List<ChatItem> chatItems = new ArrayList<>();

    public static List<ChatItem> getChatItems() {
        if (chatItems.isEmpty()) {
            addTestData();
        }
        return chatItems;
    }

    private static void addTestData() {

        for (int i = 0; i < 20; i++) {
            ChatItem chatItem = new ChatItem();
            if (i < 5) {
                chatItem.setTip(true);
            }else{
                chatItem.setTip(false);
            }
            chatItem.setCont("新消息" + i);
            chatItem.setHead("标题" + i);
            chatItem.setTime("12:" + i + "PM");
            chatItem.setNotification(i % 3 == 0);
            chatItems.add(chatItem);
        }

    }

}
