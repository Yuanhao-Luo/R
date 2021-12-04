package sample.MazePart;

public class LogicalMazeOuterCityStore{
    public Card [][] logicalMaze = new Card[16][5];
    public Card [][] MazeCanBeSeen = new Card[16][5];
    private static LogicalMazeOuterCityStore logicalMazeOuterCityStore =  new LogicalMazeOuterCityStore();

    public static LogicalMazeOuterCityStore getInstance(){
        return logicalMazeOuterCityStore;
    }

    private LogicalMazeOuterCityStore(){
        for (int i = 0; i < 16; i++){
            for(int j = 0; j < 5; j++){
                logicalMaze[i][j] = new Card(".\\images\\cards\\BlankCard1.png","空白卡片","0");
                MazeCanBeSeen[i][j] = new Card(".\\images\\cards\\BlankCard1.png","空白卡片","0");
            }
        }


        //这些是不能通行的障碍卡部分
        logicalMaze[0][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[1][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[2][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[3][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[5][3] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[6][1] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[7][1] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[10][0] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[10][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[11][2] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[12][3] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[13][1] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        logicalMaze[15][0] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");


        //这些是陷阱卡
        logicalMaze[1][0] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        logicalMaze[3][2] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        logicalMaze[9][4] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        logicalMaze[11][3] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        logicalMaze[14][2] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        logicalMaze[15][1] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");


        //这是宝箱卡
        logicalMaze[8][0] = new Card(".\\images\\cards\\Treasure.png","宝箱","0");
        logicalMaze[8][1] = new Card(".\\images\\cards\\Treasure.png","宝箱","0");
        logicalMaze[13][4] = new Card(".\\images\\cards\\Treasure.png","宝箱","0");


        //怪物
        logicalMaze[1][1] = new Card(".\\images\\cards\\Jelly.png","怪物","0");
        logicalMaze[2][0] = new Card(".\\images\\cards\\Jelly.png","怪物","0");
        logicalMaze[2][3] = new Card(".\\images\\cards\\Jelly.png","怪物","0");
        logicalMaze[4][0] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        logicalMaze[4][2] = new Card(".\\images\\cards\\Fox.png","怪物","0");
        logicalMaze[6][0] = new Card(".\\images\\cards\\RedThief.png","怪物","0");
        logicalMaze[6][4] = new Card(".\\images\\cards\\Frog.png","怪物","0");
        logicalMaze[7][0] = new Card(".\\images\\cards\\Fox.png","怪物","0");
        logicalMaze[7][2] = new Card(".\\images\\cards\\Frog.png","怪物","0");
        logicalMaze[8][3] = new Card(".\\images\\cards\\Honey.png","怪物","0");
        logicalMaze[9][1] = new Card(".\\images\\cards\\WormDX.png","怪物","0");
        logicalMaze[10][3] = new Card(".\\images\\cards\\Miskon.png","怪物","0");
        logicalMaze[11][1] = new Card(".\\images\\cards\\WormDX.png","怪物","0");
        logicalMaze[12][4] = new Card(".\\images\\cards\\Miskon.png","怪物","0");
        logicalMaze[13][0] = new Card(".\\images\\cards\\Honey.png","怪物","0");
        logicalMaze[15][2] = new Card(".\\images\\cards\\Honey.png","怪物","0");


        //传送
        logicalMaze[4][1] = new Card(".\\images\\cards\\Cave.png","传送","洞窟上层");
        logicalMaze[7][3] = new Card(".\\images\\cards\\OuterCity.png","传送","城下町");
        logicalMaze[15][4] = new Card(".\\images\\cards\\OuterCity.png","传送","城下町");



        //初始化另一个给看的迷宫
        //这些是不能通行的障碍卡部分
        MazeCanBeSeen[0][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[1][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[2][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[3][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[5][3] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[6][1] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[7][1] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[10][0] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[10][4] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[11][2] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[12][3] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[13][1] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        MazeCanBeSeen[15][0] = new Card(".\\images\\cards\\Prohibited.png","障碍","0");
        //这些是陷阱卡
        MazeCanBeSeen[1][0] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        MazeCanBeSeen[3][2] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        MazeCanBeSeen[9][4] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        MazeCanBeSeen[11][3] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        MazeCanBeSeen[14][2] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        MazeCanBeSeen[15][1] = new Card(".\\images\\cards\\AbnormalState.png","陷阱","0");
        //这是宝箱卡
        MazeCanBeSeen[8][0] = new Card(".\\images\\cards\\Treasure.png","宝箱","0");
        MazeCanBeSeen[8][1] = new Card(".\\images\\cards\\Treasure.png","宝箱","0");
        MazeCanBeSeen[13][4] = new Card(".\\images\\cards\\Treasure.png","宝箱","0");
        //怪物
        MazeCanBeSeen[1][1] = new Card(".\\images\\cards\\Jelly.png","怪物","0");
        MazeCanBeSeen[2][0] = new Card(".\\images\\cards\\Jelly.png","怪物","0");
        MazeCanBeSeen[2][3] = new Card(".\\images\\cards\\Jelly.png","怪物","0");
        MazeCanBeSeen[4][0] = new Card(".\\images\\cards\\Thief.png","怪物","0");
        MazeCanBeSeen[4][2] = new Card(".\\images\\cards\\Fox.png","怪物","0");
        MazeCanBeSeen[6][0] = new Card(".\\images\\cards\\RedThief.png","怪物","0");
        MazeCanBeSeen[6][4] = new Card(".\\images\\cards\\Frog.png","怪物","0");
        MazeCanBeSeen[7][0] = new Card(".\\images\\cards\\Fox.png","怪物","0");
        MazeCanBeSeen[7][2] = new Card(".\\images\\cards\\Frog.png","怪物","0");
        MazeCanBeSeen[8][3] = new Card(".\\images\\cards\\Honey.png","怪物","0");
        MazeCanBeSeen[9][1] = new Card(".\\images\\cards\\WormDX.png","怪物","0");
        MazeCanBeSeen[10][3] = new Card(".\\images\\cards\\Miskon.png","怪物","0");
        MazeCanBeSeen[11][1] = new Card(".\\images\\cards\\WormDX.png","怪物","0");
        MazeCanBeSeen[12][4] = new Card(".\\images\\cards\\Miskon.png","怪物","0");
        MazeCanBeSeen[13][0] = new Card(".\\images\\cards\\Honey.png","怪物","0");
        MazeCanBeSeen[15][2] = new Card(".\\images\\cards\\Honey.png","怪物","0");
        //传送
        MazeCanBeSeen[4][1] = new Card(".\\images\\cards\\Cave.png","传送","洞窟上层");
        MazeCanBeSeen[7][3] = new Card(".\\images\\cards\\OuterCity.png","传送","城下町");
        MazeCanBeSeen[15][4] = new Card(".\\images\\cards\\OuterCity.png","传送","城下町");
        //仅显示背面的，记得放到最下面
        MazeCanBeSeen[1][0] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[2][0] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[3][0] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[3][3] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[4][2] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[4][4] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[6][3] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[7][0] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[7][4] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[8][1] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[9][4] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[10][1] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[11][4] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[12][0] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[12][2] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[12][4] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[13][0] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[14][1] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[14][3] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[15][1] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
        MazeCanBeSeen[15][3] = new Card(".\\images\\cards\\BackOfTheCard.png","背面","0");
    }
}
