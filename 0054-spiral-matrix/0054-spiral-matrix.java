class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            int i = left;
            int j = top;

            // Left -> Right
            while (i <= right) {
                ans.add(matrix[j][i++]);
            }
            top++;
            if (top > bottom) break;

            // Top -> Bottom
            i = right;
            while (j < bottom) {
                ans.add(matrix[++j][i]);
            }
            right--;
            if (left > right) break;

            // Right -> Left
            while (i > left) {
                ans.add(matrix[j][--i]);
            }
            bottom--;
            if (top > bottom) break;

            // Bottom -> Top
            while (j > top) {
                ans.add(matrix[--j][i]);
            }
            left++;
        }

        return ans;
    }
}