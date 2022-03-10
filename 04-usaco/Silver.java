import java.util.*;
import java.io.*;
public class Silver{
  public static void main(String[] args) {
    try{
      System.out.println(solve("ctravel.in"));
    }catch(FileNotFoundException ex){
      System.out.println("busted");
    }
  }

  public static long find(char[][] pasture, int R1, int R2, int C1, int C2, int time){
    pasture[R1][C1] = 'S';
    pasture[R2][C2] = 'E';
    long paths = find(pasture,R1,C1,time);
    return paths;
  }

  public static long find(char[][] pasture, int x, int y, int time){
    if(x > pasture.length || y > pasture[0].length)return 0;
    if(time == 0 && pasture[x][y] != 'E')return 0;
    if(pasture[x][y] == '*')return 0;
    if(time == 0 && pasture[x][y] == 'E')return 1;
    else{
      return find(pasture, x++, y, time--) + find(pasture, x--, y, time--) + find(pasture, x, y++, time--) + find(pasture, x,y--, time--);
    }
  }

  public static long solve(String filename)throws FileNotFoundException{
    File text = new File(filename);
    Scanner input = new Scanner(text);
    String line = input.nextLine();
    String[] set = line.split(" ");
    int rows = Integer.parseInt(set[0]);
    int cols = Integer.parseInt(set[1]);
    int time = Integer.parseInt(set[2]);
    System.out.println(rows +" " + cols +" "+time);
    char[][] pasture = new char[rows][cols];
    for(int i = 0; i < rows; i++){
      line = input.nextLine();
      for(int j = 0; j < cols; j++){
        pasture[i][j] = line.charAt(j);
      }
    }
    System.out.println(toString(pasture));
    line = input.nextLine();
    set = line.split(" ");
    int R1 = Integer.parseInt(set[0]) -1;
    int C1 = Integer.parseInt(set[1]) -1;
    int R2 = Integer.parseInt(set[2]) -1;
    int C2 = Integer.parseInt(set[3]) -1;
    System.out.println(R1 +" " + C1 +" "+R2 + "" + C2);
    return 1l;
    //return find(pasture, R1, R2, C1, C2, time);
  }

  public static String toString(char[][] lake){
    String ans = "";
    for(int i =0; i < lake.length; i++){
      for(int j =0; j< lake[i].length; j++){
        ans += lake[i][j] +" ";
      }
      ans += "\n";
    }
    return ans;
  }

}
