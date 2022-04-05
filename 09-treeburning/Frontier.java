import java.util.*;
public class Frontier{
  private LinkedList<int[]> frontier;

  public Frontier(){
    frontier = new LinkedList<int[]>();
  }

  public int size(){
    return frontier.size();
  }

  public void add(int[]location){
    frontier.addLast(location);
  }

  public int[] remove(){
    return frontier.removeFirst();
  }

  public static void main(String[] args) {
    Frontier data = new Frontier();
    data.add(new int[] {1,2});
    System.out.println(data.remove()[1]);
  }
}
