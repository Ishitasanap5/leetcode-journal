class Solution {

    List<List<String>> ans = new ArrayList<>();
    char[][] board;
    int n;

    public List<List<String>> solveNQueens(int n) {

        this.n = n;
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0);

        return ans;
    }

    private void solve(int row) {

        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {

                board[row][col] = 'Q';

                solve(row + 1);

                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col) {

        // column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {

            if (board[i][j] == 'Q')
                return false;

            i--;
            j--;
        }

        // right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {

            if (board[i][j] == 'Q')
                return false;

            i--;
            j++;
        }

        return true;
    }
}