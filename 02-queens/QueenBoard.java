public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
    for(int i = 0; i < size; i++){
      for(int j =0; j < size; j++){
        board[i][j] = 0;
      }
    }
  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */
  public String toString(){
    String Board = "";
    for(int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if(board[i][j] == -1)Board += "Q ";
        else Board += board[i][j] + " ";;
      }
      Board += "\n";
    }
    return Board;
  }

  private void changeThreat(int x, int r, int c){
    for(int i = r+1; i<board.length; i++){
      board[i][c] += x;
    }
    for(int j = c+1; j<board.length; j++){
      board[r][j] += x;
    }
    for(int i = 1; i < board.length-r; i++){
      if(i < board.length-c) board[r+i][c+i] += x;
    }
    for(int i = board.length-r-1; i >= 0; i--){
      if(c - i >=0) board[r+i][c-i] += x;
    }
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */
  public boolean addQueen(int r, int c){
    if(board[r][c] != 0) return false;
    changeThreat(1, r, c);
    board[r][c] = -1;
    return true;


  }

  /**Remove the queen that was added to r,c
  *@precondition there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  public void removeQueen(int r, int c){
    if(board[r][c] == -1){
      changeThreat(-1, r, c);
      board[r][c] =0;
    }
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  public boolean solve(){
    return solve(0);
  }
  private void animation(){

    System.out.println(Text.go(1,1));
    System.out.println(this);//can change this to your debug print as well
    Text.wait(100);//change the delay 1000 = 1 second
  }
  public boolean solve(int row){
    if(row >= board.length)return true;
    else{
      for(int j = 0; j < board.length; j++){
        if(addQueen(row, j)){
          animation();
          if(solve(row+1)){
            return true;
          }
          else{
            removeQueen(row, j);
            animation();
          }
        }
      }
    }
    return false;
  }

  // /**Find all possible solutions to this size board.
  // *@return the number of solutions found, and leaves the board filled with only 0's
  // *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  // */
  // public int countSolutions(){
  //
  // }
}
