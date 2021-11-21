package sample.MazePart;

public class Card {
    //前后端分离，所以存储有两套，一个是这个Card和LogicalMazeStore,二是CardPane和GUIMazeStore
    private String url;
    private String type;//知道自己是什么，空白，宝箱，还是怪物
    private String content;//知道自己是什么怪，什么异常状态

}
