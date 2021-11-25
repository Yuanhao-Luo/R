package sample.battle;

import sample.MazePart.*;

public class battleMain {
    public static void main(String[] args) {
        LogicalMazeOuterCityStore logicalMazeOuterCityStore = LogicalMazeOuterCityStore.getInstance();
        LogicalMazeCaveFloor1Store logicalMazeCaveFloor1Store = LogicalMazeCaveFloor1Store.getInstance();
        LogicalMazeCaveUndergroundStore logicalMazeCaveUndergroundStore = LogicalMazeCaveUndergroundStore.getInstance();
        int x = logicalMazeOuterCityStore.logicalMaze[0].length;
        int y = logicalMazeOuterCityStore.logicalMaze.length;
        for (int i = 0;i<y;i++){
            for (int j = 0;j<x;j++){
                System.out.println(logicalMazeOuterCityStore.logicalMaze[i][j].getUrl());
            }

        }
    }
}
