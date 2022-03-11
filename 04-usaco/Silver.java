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

  public static long find(int[][] pasture, int R1, int R2, int C1, int C2, int time){
    int[][] pasty = pasture;
    pasty[i][j] == 1;
    while(time >= 0){
      for(int i = 0; i < pasture.length; i++){
        for(int j = 0; j < pasture[i].length; j++){
          pasture[i][j] == countNay(pasty);
        }
      }
    }
    return 1l;

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
    int[][] pasture = new int[rows][cols];
    for(int i = 0; i < rows; i++){
      line = input.nextLine();
      for(int j = 0; j < cols; j++){
        if(line.charAt(j) == '.')pasture[i][j] = 0;
        if(line.charAt(j) == '*')pasture[i][j] = -1;
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

  public static String toString(int[][] lake){
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

}
