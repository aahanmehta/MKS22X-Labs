public class Recursion{
  public static void main(String[] args) {
    //printAllWords(3);
    char[] lets = {'a','b','c'};
    //printNoDoubleLetterWords(3,lets);
    //System.out.println(countNoDoubleLetterWords(3, ""));
    // System.out.println(sqrt());
    //System.out.println(fibIter(3,1,0));
    // System.out.println(reverse("abcd"));
  }

  /*Print all words that are made of the letters a-e inclusive.
  *@param length : either how many more letters or the total length depending on implementation
  *@param word   : the partial word so far.
  */
  public static void printAllWords(int length, String ans){
    if(length == 0)System.out.println(ans);
    else{
      for(char c = 'a'; c <= 'e'; c++){
        printAllWords(length -1, ans + c);
      }
    }
  }
  /*Print all words that are made of the letters a-e inclusive.
  *@param length : the length of the words that are to be printed
  */
  public static void printAllWords(int length){
    printAllWords(length, "");
  }

  /*Print all words that are made of the characters in the array of letters.
  *There may not be consecutive equal letters, so:
  *aax is not allowed, but axa is allowed.
  *@param length : the length of the words that are to be printed
  *@param letters: the letters you should be using,
  *@precondition: letters contains at least 2 characters, and has no duplicates.
  */
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

  /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
  *aax is not allowed, but axa is allowed.
  *@param length : either how many more letters need to be
  *@param word   : the partial word so far.
  *@param letters: the letters you should be using
  */
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    //WRITE THIS METHOD
    if(length == 0)System.out.println(word);
    else{
      for(int i = 0; i < letters.length; i++){
        if( word.length() == 0 || letters[i] != word.charAt(word.length()-1) ){
          printNoDoubleLetterWords(length-1,word + letters[i], letters);
        }
      }
    }
  }
  /*
  *@param s any string
  *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion.
  */
  public static String reverse(String s){
    if(s.length() == 0)return s;
    else{
      return reverse(s.substring(1)) + s.charAt(0) ;
    }
  }

  /*
  *@param n any non-negative value you want to take the sqrt of
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  public static double sqrt(double n){
    //Hint: This is a wrapper method.
    return sqrt(n, 1);
  }
  /*
  *@param n any non-negative value you want to take the sqrt of
  *@param guess starting guess of sqrt of param n
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  public static double sqrt(double n, double guess){
    if(n == 0) return 0;
    if(Math.abs(guess*guess - n) <= 0.00001)return guess;
    else{
      return sqrt(n, (n/guess + guess)/2 );
    }

  }

  /*
  *@param length how long the words must be
  *param word the variable to store the partial solution (should start at "")
  *@return the number of words that have no adjacent matching letters using the letters a-z.
  *Repetition allowed except when letters are adjacent.
  */
  public static long countNoDoubleLetterWords(int length,String word){
    //Hint: not a wrapper method, but you must call it starting with "" as your word.
    long count = 0;
    if(length == 0)count +=1;
    else{
      for(char c = 'a'; c <= 'z' ; c++){
        if( word.length() == 0 || c != word.charAt(word.length()-1) ){
          count += countNoDoubleLetterWords(length-1,word + c);
        }
      }
    }
    return count;
  }

  /*
  *@param n any non-negative value
  *@return the nth term of the fibonacci sequence. 0, 1, 1, 2, 3, 5 etc.
  */
  public static int fibIter(int n, int f1, int f2){
    //DO NOT call fibIter more than once
    if(n == 0)return f2;
    else{
      return fibIter(n-1, f1 +f2, f1);
    }
  }

  public static boolean partalSums(int[] ary, int target){
    return partialSums(ary, target, 0,1);
  }
  public static boolean partialSums(int ary[], int target, int i, int i1){
    if(target == 0)return true;
    if(i == ary.length())return false;
    if(i1 == ary.length)return partialSums(ary, target,i+1, 1)
  }
}
