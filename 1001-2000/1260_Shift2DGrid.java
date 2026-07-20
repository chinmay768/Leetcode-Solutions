class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int n = rows * cols;

        k %= n;

        reverse(grid, 0, n - 1, cols);
        reverse(grid, 0, k - 1, cols);
        reverse(grid, k, n - 1, cols);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(grid[i][j]);
            }
            res.add(row);
        }

        return res;
    }

    private void reverse(int[][] grid, int left, int right, int cols) {
        while (left < right) {
            int temp = grid[left / cols][left % cols];
            grid[left / cols][left % cols] = grid[right / cols][right % cols];
            grid[right / cols][right % cols] = temp;

            left++;
            right--;
        }
    }
}