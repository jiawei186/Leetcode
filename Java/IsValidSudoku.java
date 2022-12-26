// 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sub = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int num = c - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if (row[i][num] || col[j][num] || sub[k][num]) {
                    return false;
                }
                row[i][num] = true;
                col[j][num] = true;
                sub[k][num] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] a = new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
            ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        IsValidSudoku b = new IsValidSudoku();

        System.out.println(b.isValidSudoku(a));
    }
}
