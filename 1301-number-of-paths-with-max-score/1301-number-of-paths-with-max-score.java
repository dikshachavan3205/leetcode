class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int row = board.size();
        int col = board.getFirst().length();
        int MOD = 1000000007;
        int maxScore = 0;
        int maxScoreCount = 0;
        boolean noPath = true;
        char[][] boardChar = new char[board.size()][board.getFirst().length()];
        int[][] boardMaxScore = new int[board.size()][board.getFirst().length()];
        int[][] boardMaxScoreCount = new int[board.size()][board.getFirst().length()];

        int[][] directions = {{0, 1}, {1, 0}, {1, 1}};

        for (int i = 0; i < board.size(); i++) {
            boardChar[i] = board.get(i).toCharArray();
        }

        if (boardChar[row - 1][col - 1] == 'S') {
            boardChar[row - 1][col - 1] = '0';
            boardMaxScoreCount[row - 1][col - 1] = 1;
        }

        if (boardChar[0][0] == 'E') {
            boardChar[0][0] = '0';
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                noPath = true;

                for (int k = 0; k < directions.length; k++) {
                    int iRow = i + directions[k][0];
                    int iCol = j + directions[k][1];

                    if (iRow < row && iCol < col &&
                        boardChar[iRow][iCol] != 'X' &&
                        boardChar[i][j] != 'X') {

                        int candidate = boardMaxScore[iRow][iCol] + boardChar[i][j] - '0';

                        if (boardMaxScore[i][j] == candidate) {
                            noPath = false;
                            boardMaxScoreCount[i][j] =
                                (boardMaxScoreCount[i][j] + boardMaxScoreCount[iRow][iCol]) % MOD;
                        } else if (boardMaxScore[i][j] < candidate) {
                            boardMaxScore[i][j] = candidate;
                            boardMaxScoreCount[i][j] = boardMaxScoreCount[iRow][iCol];
                            noPath = false;
                        }
                    }
                }

                if (noPath && (i < row - 1 || j < col - 1)) {
                    boardChar[i][j] = 'X';
                }
            }
        }

        return new int[]{boardMaxScore[0][0], boardMaxScoreCount[0][0]};
    }
}