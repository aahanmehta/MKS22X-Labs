public class Driver{
  public static void main(String[] args){
    QueenBoard board = new QueenBoard(8);
    System.out.println(Text.CLEAR_SCREEN);
    System.out.println(Text.HIDE_CURSOR);
    System.out.println(Text.go(1,1));
    //call your solve
    System.out.println(board.solve());
    System.out.println(Text.RESET);


  }
}
