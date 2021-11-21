package sample.MazePart;

public class LogicalMazeStore {
    public Card [][] logicalMaze = new Card[3][5];
    public Card [][] MazeCanBeSeen = new Card[3][5];
    private static LogicalMazeStore logicalMazeStore =  new LogicalMazeStore();


    public static LogicalMazeStore getInstance(){
        return logicalMazeStore;
    }

    private LogicalMazeStore(){
        initLogicalMaze();
    }

    public void initLogicalMaze(){//这是初始化整个迷宫逻辑结构的函数，再后面是具体的往里面放卡片环节
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                logicalMaze[i][j] = new Card();
                MazeCanBeSeen[i][j] = new Card();
            }
        }
    }



}
