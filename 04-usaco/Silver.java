import java.util.*;
import java.io.*;
public class Silver{
  public static long find(long[][] pasture, int x, int y, int time){
    long[][] pasty = copy(pasture);
    while(time >= 0){
      for(int i = 0; i < pasture.length; i++){
        for(int j = 0; j < pasture[i].length; j++){
          if(time%2 == 0){
            pasty[i][j] = countNay(pasture, i, j);
            // if(pasture[i][j] != -1)pasture[i][j] = 0;
          }
          if(time%2 == 1){
            pasture[i][j] = countNay(pasty, i, j);
            // if(pasty[i][j] != -1)pasty[i][j] = 0;
          }
        }
      }
      // if(time%2 == 1)System.out.println(toString(pasty));
      // if(time%2 == 0)System.out.println(toString(pasture));
      time--;
    }
    // System.out.println(toString(pasture));
    // System.out.println(toString(pasty));
    return pasture[x][y];
  }

  public static long countNay(long[][] field, int x, int y){
    if(field[x][y] == -1)return -1l;
    long count = 0;
    if(inBounds(field, x+1, y) && field[x+1][y] != -1)count += field[x+1][y];
    if(inBounds(field, x-1, y) && field[x-1][y] != -1)count += field[x-1][y];
    if(inBounds(field, x, y+1) && field[x][y+1] != -1)count += field[x][y+1];
    if(inBounds(field, x, y-1) && field[x][y-1] != -1)count += field[x][y-1];
    return count;
  }

  public static long solve(String filename){
    try{
      File text = new File(filename);
      Scanner input = new Scanner(text);
      String line = input.nextLine();
      String[] set = line.split(" ");
      int rows = Integer.parseInt(set[0]);
      int cols = Integer.parseInt(set[1]);
      int time = Integer.parseInt(set[2]);
      // System.out.println(rows +" " + cols +" "+time);
      long[][] pasture = new long[rows][cols];
      for(int i = 0; i < rows; i++){
        line = input.nextLine();
        for(int j = 0; j < cols; j++){
          if(line.charAt(j) == '.')pasture[i][j] = 0l;
          if(line.charAt(j) == '*')pasture[i][j] = -1l;
        }
      }
      line = input.nextLine();
      set = line.split(" ");
      int R1 = Integer.parseInt(set[0]) -1;
      int C1 = Integer.parseInt(set[1]) -1;
      int R2 = Integer.parseInt(set[2]) -1;
      int C2 = Integer.parseInt(set[3]) -1;
      pasture[R1][C1] = 1l;
      // System.out.println(toString(pasture));
      // System.out.println(R1 +" " + C1 +" "+R2 + " " + C2);
      return find(pasture, R2, C2, time);
      //return find(pasture, R1, R2, C1, C2, time);
    }catch(FileNotFoundException ex){
      return -1l;
    }
  }

  public static String toString(long[][] lake){
    String ans = "";
    for(int i =0; i < lake.length; i++){
      for(int j =0; j< lake[i].length; j++){
        if(lake[i][j] >= 0)ans += lake[i][j] +"  ";
        if(lake[i][j] == -1)ans += lake[i][j] +" ";
      }
      ans += "\n";
    }
    return ans;
  }
  public static long[][] copy(long[][] arr){
    long[][] copy = new long[arr.length][arr[0].length];
    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr[i].length; j++){
        copy[i][j] = arr[i][j];
      }
    }
    return copy;
  }

  public static boolean inBounds(long[][] patch, int x, int y){
    try{
      long yes = patch[x][y];
      return true;
    }catch(IndexOutOfBoundsException ex){
      return false;
    }
  }

}
