package internship.graph;

public class FloodFill {
	private void fill(int[][] image, int x, int y,int m,int n,int oldColor, int newColor){
        if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] != oldColor)
            return ;
        image[x][y] = newColor;
        fill(image,x+1,y,m,n,oldColor,newColor);
        fill(image,x-1,y,m,n,oldColor,newColor);
        fill(image,x,y+1,m,n,oldColor,newColor);
        fill(image,x,y-1,m,n,oldColor,newColor);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];
        if(oldColor != newColor) 
            fill(image,sr,sc,m,n,oldColor,newColor);
        return image;
    }
}
