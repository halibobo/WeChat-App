package dahei.me.xiaobai.model;

/**
 * created by yubosu
 * 2018年11月13日3:28 PM
 */
public class DiscoverItem {

    private int group;
    private String drawableName;
    private String title;

    public DiscoverItem(String drawableName, String title,int group) {
        this.drawableName = drawableName;
        this.title = title;
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getDrawableName() {
        return drawableName;
    }

    public void setDrawableName(String drawableName) {
        this.drawableName = drawableName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
