package MyGraphs.chapter4dot1.Exercises.maze;

class Location {
    private final XyCoordinate xyCoordinate;
    private boolean leftClosed, rightClosed, upClosed, downClosed;
    private boolean visited;

    Location(final XyCoordinate xyCoordinate) {
        this.xyCoordinate = xyCoordinate;
    }

    XyCoordinate getXyCoordinate() {
        return xyCoordinate;
    }

    boolean isLeftClosed() {
        return leftClosed;
    }

    void setLeftClosed(final boolean leftClosed) {
        this.leftClosed = leftClosed;
    }

    void setRightClosed(final boolean rightClosed) {
        this.rightClosed = rightClosed;
    }

    void setUpClosed(final boolean upClosed) {
        this.upClosed = upClosed;
    }

    boolean isDownClosed() {
        return downClosed;
    }

    void setDownClosed(final boolean downClosed) {
        this.downClosed = downClosed;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(final boolean visited) {
        this.visited = visited;
    }

}
