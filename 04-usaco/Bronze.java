import java.util.*;
import java.io.*;
public class Bronze{
  public static void main(String[] args) {
    try{
      System.out.println(solve("makelake.in"));
    }catch(FileNotFoundException ex){
      System.out.println("busted");
    }
  }

  public static void stomp(int[][] lake, int x, int y, int D_s){
    int peak = maxElev(lake, x, y);
    for(int c = 0; c < D_s; c++){
      for(int i = 0; i<3; i++){
        for(int j = 0; j<3; j++){
          if(i+x>lake.length && j+y>lake[0].length && lake[i+x][j+y] == peak) lake[i+x][j+y] = lake[i+x][j+y] -1;
        }
      }
      D_s--;
    }
  }

  public static long getVol(int[][] lake, int elev){
    int aggDep = 0;
    for(int[] row: lake){
      for(int c: row){
        if(c<elev){
          aggDep += elev-c;
        }
      }
    }
    return aggDep * 72 * 72;
  }

  public static int maxElev(int[][]lake, int x, int y){
    int maxElev = lake[x][y];
    for(int i = 0; i<3; i++){
      for(int j = 0; j<3; j++){
        if(i+x>lake.length && j+y>lake[0].length && lake[i+x][j+y] > maxElev) maxElev = lake[i+x][j+y];
      }
    }
    return maxElev;
  }

  public static long solve(String filename)throws FileNotFoundException{
      File text = new File(filename);
      Scanner input = new Scanner(text);
      int r = input.nextInt();
      int c = input.nextInt();
      int[][] lake = new int[r][c];
      int e = input.nextInt();
      int n = input.nextInt();

      //setting up the initial depths
      for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
          lake[i][j] = input.nextInt();
        }
      }

      //begin stomping
      while(input.hasNextLine()){
        int x = input.nextInt();
        int y = input.nextInt();
        int D_s = input.nextInt();
        stomp(lake, x, y, D_s);
      }
      return getVol(lake, e);
  }
}
