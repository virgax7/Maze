package MyGraphs.chapter4dot1.Exercises.maze;

class MazeApp {
    public static void main(String[] args) {
        System.out.println(buildMaze(25));
    }

    private static Maze buildMaze(final int n) {
        return new Maze(n);
    }
}
