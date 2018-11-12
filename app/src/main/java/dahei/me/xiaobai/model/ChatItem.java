package dahei.me.xiaobai.model;

/**
 * created by yubosu
 * 2018年11月09日3:39 PM
 */
public class ChatItem {

    private String head;
    private String cont;
    private String time;
    private boolean isNotification;
    private boolean isTip;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public boolean isTip() {
        return isTip;
    }

    public void setTip(boolean tip) {
        isTip = tip;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isNotification() {
        return isNotification;
    }

    public void setNotification(boolean notification) {
        isNotification = notification;
    }
}
