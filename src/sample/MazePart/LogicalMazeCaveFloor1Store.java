package sample.MazePart;

public class LogicalMazeCaveFloor1Store{
    public Card [][] logicalMaze = new Card[8][5];
    public Card [][] MazeCanBeSeen = new Card[8][5];
    private static LogicalMazeCaveFloor1Store logicalMazeCaveFloor1Store = new LogicalMazeCaveFloor1Store();

    public static LogicalMazeCaveFloor1Store getInstance(){
        return  logicalMazeCaveFloor1Store;
    }

    private LogicalMazeCaveFloor1Store(){
        for (int i = 0; i < 8; i++){
            for(int j = 0; j < 5; j++){
                logicalMaze[i][j] = new Card(".\\images\\cards\\BlankCard1.png","空白卡片","0");
                MazeCanBeSeen[i][j] = new Card(".\\images\\cards\\BlankCard1.png","空白卡片","0");
            }
        }

        //这些是不能通行的障碍卡部分
        logicalMaze[0][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[1][1] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[3][0] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[4][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[5][3] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[6][0] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[6][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[7][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");


        //这些是陷阱卡
        logicalMaze[0][0] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        logicalMaze[4][2] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");


        //这是宝箱卡
        logicalMaze[5][2] = new Card(".\\images\\cards\\Treasure.png","宝箱","0");


        //怪物
        logicalMaze[0][2] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        logicalMaze[2][1] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        logicalMaze[2][3] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        logicalMaze[2][4] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        logicalMaze[5][1] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        logicalMaze[6][2] = new Card(".\\images\\cards\\Thief.png","怪物","0");

        //传送,这个地方有需要修改的，机制，图片都待定
        logicalMaze[4][0] = new Card(".\\images\\cards\\Cave.png","传送","下层");


        //这些是不能通行的障碍卡部分
        MazeCanBeSeen[0][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[1][1] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[3][0] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[4][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[5][3] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[6][0] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[6][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[7][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        //这些是陷阱卡
        MazeCanBeSeen[0][0] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        MazeCanBeSeen[4][2] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        //这是宝箱卡
        MazeCanBeSeen[5][2] = new Card(".\\images\\cards\\Treasure.png","宝箱","0");
        //怪物
        MazeCanBeSeen[0][2] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        MazeCanBeSeen[2][1] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        MazeCanBeSeen[2][3] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        MazeCanBeSeen[2][4] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        MazeCanBeSeen[5][1] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        MazeCanBeSeen[6][2] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        //传送,这个地方有需要修改的，机制，图片都待定
        MazeCanBeSeen[4][0] = new Card(".\\images\\cards\\Cave.png","传送","下层");

        //背面
        MazeCanBeSeen[0][0] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[0][3] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[1][2] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[2][0] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[2][1] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[2][2] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[2][4] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[5][2] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[6][3] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[7][3] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
    }
}
