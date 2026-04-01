class Solution {
    public int countBattleships(char[][] board) {
        var visitedCoordinates = new HashSet<List<Integer>>();
        var battleshipsCount = 0;

        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                var startingCoordinates = List.of(row, col);
                if (board[row][col] == 'X' && !visitedCoordinates.contains(startingCoordinates)) {
                    performBattleshipTraversal(board, startingCoordinates, visitedCoordinates);
                    battleshipsCount += 1;
                }
            }
        }

        return battleshipsCount;
    }

    public void performBattleshipTraversal(
        char[][] board,
        List<Integer> startingCoordinates,
        HashSet<List<Integer>> visitedCoordinates
    ) {
        var stack = new LinkedList<List<Integer>>();
        stack.add(startingCoordinates);

        while (!stack.isEmpty()) {
            var cur = stack.removeLast();
            visitedCoordinates.add(cur);

            Predicate<List<Integer>> isValid = (List<Integer> it) -> {
                int x = it.get(0), y = it.get(1);
                return inBounds(0, x, board.length)
                    && inBounds(0, y, board[0].length)
                    && board[x][y] == 'X'
                    && !visitedCoordinates.contains(it);
            };

            int row = cur.get(0), col = cur.get(1);
            var horizontalNeighbors = List.of(
                    List.of(row - 1, col),
                    List.of(row + 1, col)
                ).stream()
                .filter(isValid)
                .toList();

            var verticalNeighbors = List.of(
                    List.of(row, col - 1),
                    List.of(row, col + 1)
                ).stream()
                .filter(isValid)
                .toList();

            stack.addAll(
                horizontalNeighbors.size() > 0
                ? horizontalNeighbors
                : verticalNeighbors
            );
        }
    }

    public boolean inBounds(int l, int n, int r) {
        return l <= n && n < r;
    }
}