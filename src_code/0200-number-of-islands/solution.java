class Solution {
    int row, column, count;
    char[][] arr;
    private static char LAND_AREA = '1';

    public int numIslands(char[][] grid) {
        row = grid.length;
        column = grid[0].length;
        arr = grid;

        count = 0;
        for(int i = 0; i < row; i++) {
            check(grid[i],i);
        }
        return count;
    }

    private void check(char[] arr_row,int arr_column) {
        for(int j = 0; j < column; j++) {
            if(LAND_AREA == arr_row[j]) {
                hasLand(arr_column, j);
                count++;
            }
        }
    }

    private void hasLand(int i, int j){
        arr[i][j] = 2;
        if(i - 1 >= 0 && arr[i-1][j] == LAND_AREA) {
            hasLand(i-1, j);
        }
        if(i + 1 < row && arr[i+1][j] == LAND_AREA) {
            hasLand(i+1, j);
        }
        if(j - 1 >= 0 && arr[i][j-1] == LAND_AREA) {
            hasLand(i, j-1);
        }
        if(j + 1 < column && arr[i][j+1] == LAND_AREA) {
            hasLand(i, j+1);
        }
    }
}
