import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Maze {
  public static char[][] getValuesFromFile(String filename) throws FileNotFoundException{
    try{
      File text = new File(filename);
      //code here to read file into array
      ArrayList< ArrayList<Character> > inpet = new ArrayList< ArrayList<Character> >();
      String line = "";
      Scanner input = new Scanner(text);
      while(input.hasNextLine()){
        line = input.nextLine();
        ArrayList<Character> row = new ArrayList<Character>();
        for(int i = 0; i < line.length(); i++){
          row.add(line.charAt(i));
        }
        inpet.add(row);
      }
      input.close();
      char[][] maze = new char[inpet.size()][inpet.get(0).size()];
      for(int i = 0; i < maze.length; i++){
        for(int j = 0; j < maze[0].length; j++){
          maze[i][j] = inpet.get(i).get(j);
        }
      }
      return maze;
    }catch(FileNotFoundException ex){
       
    }
  }

  public static void main(String args[]){
    try{
      getValuesFromFile("Maze1.txt");
    }catch(FileNotFoundException ex){
      System.out.println("nop");
    }
  }
}
