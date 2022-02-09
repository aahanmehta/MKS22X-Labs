public class SubsetRecursion.java{
  public static boolean partalSums(int[] ary, int target){
    return partialSums(ary, target, 0);
  }

  public static boolean partialSums(int[] ary, int target, int i){
    if(target == 0)return true;
    if(i >= ary.length)return false;
    else{
      return(partialSums(ary, target - ary[i], i+1) || partialSums(ary, target, i+1));
    }
  }
  public static void main(String[] args){

  }
}
