public class RecursionClasswork.java{
  public static boolean partalSums(int[] ary, int target){
    return groupSum(ary, target, 0);
  }

  public static boolean groupSum(int[] ary, int target, int i){
    if(target == 0)return true;
    if(i >= ary.length)return false;
    else{
      return(groupSum(ary, target - ary[i], i+1) || groupSum(ary, target, i+1));
    }
  }
  public static void main(String[] args){
  }
}

