package sample.MazeLogicalPart;


import sample.ImageProcess;

public class MazeStore {
    public CardPane [][] theMaze = new CardPane[3][5];
    public int currentCard = 0;

    public MazeStore(){
        initTheMaze();
    }
    //

    public void initTheMaze(){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                theMaze[i][j] = new CardPane();
                if(i%3==0){
                    ImageProcess.addImage(theMaze[i][j],".\\images\\cards\\BasicCard1.png");
                }else if(i%3==1){
                    ImageProcess.addImage(theMaze[i][j],".\\images\\cards\\BasicCard2.png");
                }else
                    ImageProcess.addImage(theMaze[i][j],".\\images\\cards\\BasicCard3.png");

            }
        }
    }
}
