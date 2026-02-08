class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    islandDFS(grid,i,j);
                }
            }
        }
        return islands;
    }

    public static void islandDFS(char grid[][],int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0';

        islandDFS(grid, i-1, j);
        islandDFS(grid, i+1, j);
        islandDFS(grid, i, j+1);
        islandDFS(grid, i, j-1);
    }
}