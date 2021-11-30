package sample.MazePart;

public class Card {
    //前后端分离，所以存储有两套，一个是这个Card和LogicalMazeStore,二是CardPane和GUIMazeStore
    private String url;
    private String type;//知道自己是什么，空白，宝箱，还是怪物
    private String content;//知道自己是什么怪，什么异常状态

    public Card(String url, String type, String content) {
        this.url = url;
        this.type = type;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
