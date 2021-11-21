package sample.MazePart;

import sample.ImageProcess;

public class GUIMazeStore {
    public CardPane [][] GuiMaze= new CardPane[3][5];
    private static GUIMazeStore guiMazeStore = new GUIMazeStore();


    public static GUIMazeStore getInstance(){
        return guiMazeStore;
    }

    private GUIMazeStore(){
        initGuiMaze();
    }


    //暂时用着的例子
    public void initGuiMaze(){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                GuiMaze[i][j] = new CardPane();
                if(i%3==0){
                    ImageProcess.addImage(GuiMaze[i][j],".\\images\\cards\\BasicCard1.png");
                }else if(i%3==1){
                    ImageProcess.addImage(GuiMaze[i][j],".\\images\\cards\\BasicCard2.png");
                }else
                    ImageProcess.addImage(GuiMaze[i][j],".\\images\\cards\\BasicCard3.png");

            }
        }
    }
    //有些卡片只给了背面，这就要用到两张卡片，分别是卡片背面和正面，所以，需要根据
    //还有一个构想，因为我们没有做动画，所以，最终效果类似于点了一下就少了一排，这样，一旦自己点了一张背面的牌，
    //刷，翻过来的同时少了一排，看不清自己选了什么，如果做成点下去就反面，那我点下去再移开鼠标，不久成了偷看吗，
    //初步构想：凡是点背面朝上的牌，都要点一下才能进入下一步，而且是点自己已经翻开的那张牌，也就是说，障碍牌和背面牌不加直接跳转的动作


    //这个是后续实际要用的初始化方法，初始化牌比较简单，根据card的信息生成card Pane然后加图片就行了，
    //大头在加事件上面，明显只露背景的图片，障碍图片，以及普通图片的事件是很不一样的
    public void initGuiMaze2(){

    }


}
