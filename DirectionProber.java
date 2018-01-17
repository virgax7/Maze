package MyGraphs.chapter4dot1.Exercises.maze;

import static MyGraphs.chapter4dot1.Exercises.maze.DirectionProber.Direction.*;

enum DirectionProber {
    LEFT_PROBER(location -> location.setLeftClosed(true), LEFT),
    RIGHT_PROBER(location -> location.setRightClosed(true), RIGHT),
    UP_PROBER(location -> location.setUpClosed(true), UP),
    DOWN_PROBER(location -> location.setDownClosed(true), DOWN);

    final ProbeStrategy probeStrategy;
    final CloseStrategy closeStrategy;
    final Direction direction;

    DirectionProber(final CloseStrategy closeStrategy, final Direction direction) {
       this.probeStrategy = (locations, location) -> {
           final XyCoordinate xyCoordinate = getNextCoordinate(location);
           return xyCoordinate.getX() >= 0 && xyCoordinate.getX() < locations.length
                   && xyCoordinate.getY() >= 0&& xyCoordinate.getY() < locations[0].length
                   && !locations[xyCoordinate.getX()][xyCoordinate.getY()].isVisited();
       };
       this.closeStrategy = closeStrategy;
       this.direction = direction;
    }

    boolean directionIsValid(final Location[][] locations, final Location location) {
        return probeStrategy.probeDirection(locations, location);
    }

    void closeDirection(final Location location) {
        closeStrategy.closeDirection(location);
    }

    XyCoordinate getNextCoordinate(final Location location) {
        return direction.shiftStrategy.getShiftedCoordinate(location.getXyCoordinate());
    }

    @FunctionalInterface
    interface CloseStrategy {
        void closeDirection(final Location location);
    }

    @FunctionalInterface
    interface ProbeStrategy {
        boolean probeDirection(final Location[][] locations, final Location location);
    }

    enum Direction {
        LEFT(0, -1), RIGHT(0, 1), UP(-1, 0), DOWN(1, 0);

        final int x, y;
        final Direction.ShiftStrategy shiftStrategy;

        Direction(final int x, final int y) {
            this.shiftStrategy = coordinate -> new XyCoordinate(coordinate.getX() + x, coordinate.getY() + y);
            this.x = x;
            this.y = y;
        }

        @FunctionalInterface
        interface ShiftStrategy {
            XyCoordinate getShiftedCoordinate(final XyCoordinate coordinate);
        }
    }
}
