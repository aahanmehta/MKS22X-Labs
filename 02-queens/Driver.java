public class Driver{
  public static void main(String[] args){
    QueenBoard board = new QueenBoard(4);
    System.out.println(board);
    board.addQueen(1,1);
    System.out.println(board);
    board.addQueen(0,3);
    // System.out.println(board.addQueen(0,3));
    // board.removeQueen(0,1);
    System.out.println(board);

  }
}
