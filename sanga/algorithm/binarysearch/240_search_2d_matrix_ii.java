package src.sanga.algorithm.binarysearch;

/**
 * m x n 행렬에서 값을 찾아내는 효율적인 알고리즘을 구현하라. 행렬은 왼쪽에서 오른쪽, 위에서 아래 오름차순으로 정렬되어 있다.
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                row += 1;
            } else {
                column -= 1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int column = 0;

        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                column += 1;
            } else {
                row -= 1;
            }
        }

        return false;
    }

}