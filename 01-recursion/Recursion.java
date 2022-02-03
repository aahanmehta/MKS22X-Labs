public class Recursion{
  public static void main(String[] args) {
    printAllWords(3);
  }
  public static void printAllWords(int size, String ans){
    if(size == 0)System.out.println(ans);
    else{
      for(char c = 'a'; c <= 'e'; c++){
      printAllWords(size -1, ans + c);
      }
    }
  }
  public static void printAllWords(int length){
    printAllWords(length, "");
  }
}
