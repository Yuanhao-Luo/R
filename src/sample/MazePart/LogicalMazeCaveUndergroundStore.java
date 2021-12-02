package sample.MazePart;

public class LogicalMazeCaveUndergroundStore{
    public Card [][] logicalMaze = new Card[8][5];
    public Card [][] MazeCanBeSeen = new Card[8][5];
    private static LogicalMazeCaveUndergroundStore logicalMazeCaveUndergroundStore = new LogicalMazeCaveUndergroundStore();

    public static LogicalMazeCaveUndergroundStore getInstance(){
        return logicalMazeCaveUndergroundStore;
    }

    private LogicalMazeCaveUndergroundStore(){
        for (int i = 0; i < 8; i++){
            for(int j = 0; j < 5; j++){
                logicalMaze[i][j] = new Card(".\\images\\cards\\BlankCard1.png","1","0");
                MazeCanBeSeen[i][j] = new Card(".\\images\\cards\\BlankCard1.png","1","0");
            }
        }

        //这些是不能通行的障碍卡部分
        logicalMaze[0][4] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        logicalMaze[3][1] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        logicalMaze[3][3] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        logicalMaze[4][1] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        logicalMaze[0][4] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        logicalMaze[5][3] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        logicalMaze[6][0] = new Card(".\\images\\cards\\Prohibited.png","2","0");


        //这些是陷阱卡
        logicalMaze[0][2] = new Card(".\\images\\cards\\AbnormalState.png","4","0");
        logicalMaze[7][4] = new Card(".\\images\\cards\\AbnormalState.png","4","0");


        //这是宝箱卡,这个地方本来是葡萄酒，这里准备以宝箱的形式出现
        logicalMaze[1][4] = new Card(".\\images\\cards\\Treasure.png","5","0");

        //怪物
        logicalMaze[0][1] = new Card(".\\images\\cards\\Thief.png","6","0");
        logicalMaze[1][1] = new Card(".\\images\\cards\\RedThief.png","6","0");
        logicalMaze[2][4] = new Card(".\\images\\cards\\RedThief.png","6","0");
        logicalMaze[4][0] = new Card(".\\images\\cards\\RedThief.png","6","0");
        logicalMaze[5][4] = new Card(".\\images\\cards\\Frog.png","6","0");
        logicalMaze[6][2] = new Card(".\\images\\cards\\RedThief.png","6","0");
        logicalMaze[7][2] = new Card(".\\images\\cards\\Frog.png","6","0");

        //传送,这个地方有需要修改的，图片待定
        logicalMaze[3][2] = new Card(".\\images\\cards\\Cave.png","7","0");
        logicalMaze[5][1] = new Card(".\\images\\cards\\Cave.png","7","0");
        logicalMaze[7][4] = new Card(".\\images\\cards\\Cave.png","7","0");




        //这些是不能通行的障碍卡部分
        MazeCanBeSeen[0][4] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        MazeCanBeSeen[3][1] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        MazeCanBeSeen[3][3] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        MazeCanBeSeen[4][1] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        MazeCanBeSeen[0][4] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        MazeCanBeSeen[5][3] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        MazeCanBeSeen[6][0] = new Card(".\\images\\cards\\Prohibited.png","2","0");
        //这些是陷阱卡
        MazeCanBeSeen[0][2] = new Card(".\\images\\cards\\AbnormalState.png","4","0");
        MazeCanBeSeen[7][4] = new Card(".\\images\\cards\\AbnormalState.png","4","0");
        //这是宝箱卡,这个地方本来是葡萄酒，这里准备以宝箱的形式出现
        MazeCanBeSeen[1][4] = new Card(".\\images\\cards\\Treasure.png","5","0");
        //怪物
        MazeCanBeSeen[0][1] = new Card(".\\images\\cards\\Thief.png","6","0");
        MazeCanBeSeen[1][1] = new Card(".\\images\\cards\\RedThief.png","6","0");
        MazeCanBeSeen[2][4] = new Card(".\\images\\cards\\RedThief.png","6","0");
        MazeCanBeSeen[4][0] = new Card(".\\images\\cards\\RedThief.png","6","0");
        MazeCanBeSeen[5][4] = new Card(".\\images\\cards\\Frog.png","6","0");
        MazeCanBeSeen[6][2] = new Card(".\\images\\cards\\RedThief.png","6","0");
        MazeCanBeSeen[7][2] = new Card(".\\images\\cards\\Frog.png","6","0");
        //传送,这个地方有需要修改的，图片待定
        MazeCanBeSeen[3][2] = new Card(".\\images\\cards\\Cave.png","7","0");
        MazeCanBeSeen[5][1] = new Card(".\\images\\cards\\Cave.png","7","0");
        MazeCanBeSeen[7][4] = new Card(".\\images\\cards\\Cave.png","7","0");

        //背面
        MazeCanBeSeen[0][1] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[0][2] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[1][1] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[1][3] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[2][1] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[4][0] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[4][2] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[5][2] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[6][3] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[6][4] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
        MazeCanBeSeen[7][4] = new Card(".\\images\\cards\\BackOfTheCard.png","3","0");
    }
}
