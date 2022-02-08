package internship.graph;

public class FindNoOfIsland {
	public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i,j,n,m,grid);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int x,int y,int n,int m,char grid[][]){
        if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == '0')
            return;
            
        grid[x][y] = '0';
        
        dfs(x+1,y,n,m,grid);
        dfs(x-1,y,n,m,grid);
        dfs(x,y+1,n,m,grid);
        dfs(x,y-1,n,m,grid);
        dfs(x-1,y-1,n,m,grid);
        dfs(x+1,y-1,n,m,grid);
        dfs(x-1,y+1,n,m,grid);
        dfs(x+1,y+1,n,m,grid);
    } 
}
