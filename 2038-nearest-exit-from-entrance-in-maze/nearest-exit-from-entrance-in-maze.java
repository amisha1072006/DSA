class Solution {
    public final char EMPTY = '.';
    public final char WALL = '+';

    public int nearestExit(char[][] maze, int[] entrance) {
        var maxHeight = maze.length-1;
        var maxWidth = maze[0].length-1;
        var nextPositionQueue = new ArrayDeque<Coordinates>();
        var entranceCoordinates = new Coordinates(entrance[1], entrance[0]);
        nextPositionQueue.add(entranceCoordinates);

        var moves = 0;

        while(!nextPositionQueue.isEmpty()) {
            var queueSize = nextPositionQueue.size();
            for (var i=0; i<queueSize;i++){
                var coordinates = nextPositionQueue.poll();
                var position = maze[coordinates.y][coordinates.x];
                if (position == WALL) continue;
                if (position == EMPTY) {
                    if (isExit(maxHeight, maxWidth, coordinates, entranceCoordinates)) return moves;
                    addPossibleLocationsToQueue(nextPositionQueue, coordinates, maxHeight, maxWidth);
                    maze[coordinates.y][coordinates.x] = WALL;
                }
            }
            moves++;
        }

        return -1;
    }

    public record Coordinates(int x, int y){}

    public boolean isExit(int maxHeight, int maxWidth, Coordinates coordinates, Coordinates entrance) {
        var currentY = coordinates.y; // Y Position
        var currentX = coordinates.x; // X position
        var atYBorder = currentX == 0 || currentX == maxWidth;
        var atXBorder = currentY == 0 || currentY == maxHeight;
        var isEntrance = currentY == entrance.y && currentX == entrance.x;
        return (atXBorder || atYBorder) && !isEntrance;

    }

    public void addPossibleLocationsToQueue(ArrayDeque<Coordinates> queue, Coordinates current, int maxHeight, int maxWidth){
        var currentY = current.y; // Y Position
        var currentX = current.x; // X position
        if (currentY + 1 <= maxHeight){
            // Move down
            var c = new Coordinates(currentX, currentY+1);
            queue.offer(c);
        }
        if (currentX + 1 <= maxWidth) {
            // Move to the right
            var c = new Coordinates(currentX+1, currentY);
            queue.offer(c);
        }
        if (currentY - 1 >= 0) {
            // Move up
            var c = new Coordinates(currentX, currentY-1);
            queue.offer(c);
        }
        if (currentX -1 >= 0) {
            // Move to the left
            var c = new Coordinates(currentX-1, currentY);
            queue.offer(c);
        }
    }
}