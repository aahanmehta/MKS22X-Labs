public class MazeGenerator{
  public static void fill(char[][] maze){
    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[0].length; j++){
        maze[i][j] = '#';
      }
    }
  }

  public static boolean atBorder(char[][] maze,int startrow,int startcol){
    if(startcol == 0 || startrow == 0)return true;
    if(startrow == maze.length -1 || startcol == maze[0].length -1)return true;
    return false;
  }

  public static boolean lonely(char[][] maze,int startrow,int startcol){
    int bors = 0;
    if(maze[startrow+1][startcol] == ' ')bors ++;
    if(maze[startrow-1][startcol] == ' ')bors ++;
    if(maze[startrow][startcol+1] == ' ')bors ++;
    if(maze[startrow][startcol-1] == ' ')bors ++;
    return bors < 2;
  }

  public static int[] pickDir(){
    int[] dirs = {1,2,3,4};
    for(int i =0; i < 4; i++){
      int index = (int) (Math.random()*4 );
      int swap = dirs[i];
      dirs[i] = dirs[index];
      dirs[index] = swap;
    }
    return dirs;
  }

  public static void generate(char[][]maze, int startrow, int startcol){
    if(maze[startrow][startcol] == '#' && !atBorder(maze, startrow, startcol) && lonely(maze, startrow, startcol)){
      maze[startrow][startcol] = ' ';
      int[] direcs = pickDir();
      for(int i =0; i < 4; i++){
        if(direcs[i] == 1)generate(maze, startrow+1, startcol);
        if(direcs[i] == 2)generate(maze, startrow-1, startcol);
        if(direcs[i] == 3)generate(maze, startrow, startcol+1);
        if(direcs[i] == 4)generate(maze, startrow, startcol-1);
      }
    }
    else{
      return;
    }
  }
}
