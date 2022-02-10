public class RecursionClasswork{
  public static void main(String[] args){
    //int[] a = {2,4,8};
    //System.out.println(partalSums(a, 9));

    // System.out.println(groupSum6(0, new int[]{5, 6, 2}, 8));
    System.out.println(groupSum6(0, new int[]{5, 6, 2}, 9));
    System.out.println(groupSum6(0, new int[]{5, 6, 2}, 7));
  }

  public static boolean groupSum(int[] nums, int target){
    return groupSum(nums, target, 0);
  }

  public static boolean groupSum(int start, int[] nums, int target){
    if(target == 0)return true;
    if(start >= nums.length)return false;
    else{
      return(groupSum(start+1, nums, target - nums[target]) || groupSum(start+1, nums, target));
    }
  }

  public static boolean groupSum6(int start, int[] nums, int target){
    if(start >= nums.length && target != 0)return false;
    if(start >= nums.length && target == 0)return true;
    else{
      if(nums[start] == 6)return groupSum6(start +1, nums, target -6);
      else{
        return(groupSum6(start +1, nums, target - nums[start]) || groupSum6(start +1, nums, target));
      }
    }
  }

  public static boolean groupNoAdj(int start, int[] nums, int target){
    if(target == 0)return true;
    if(start >= nums.length)return false;
    else{
      return(groupNoAdj(start +2, nums, target - nums[start]) || groupNoAdj(start + 1, nums, target));
      }
    }
  }

}
