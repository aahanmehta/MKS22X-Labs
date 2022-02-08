public class RecursionDemo{
  public static void main(String[] args) {
    makeWords(3, "");
  }
  public static void makeWords(int size, String ans){
    if(size == 0)System.out.print(ans + ", ");
    else{
      for(char c = 'a'; c <= 'z'; c++){
      makeWords(size -1, ans + c);
      }
    }
  }
}
