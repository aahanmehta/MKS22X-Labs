public class RecursionClasswork{
  public static void main(String[] args){
    //int[] a = {2,4,8};
    //System.out.println(partalSums(a, 9));

    // System.out.println(groupSum6(0, new int[]{5, 6, 2}, 8));
    System.out.println(splitArray(new int[]{2,2}));
    System.out.println(splitArray(new int[]{2,3}));
  }

  public static boolean groupSum(int[] nums, int target){
    return groupSum(0, nums, target);
  }

  public static boolean groupSum(int start, int[] nums, int target){
    if(target == 0)return true;
    if(start >= nums.length)return false;
    else{
      return(groupSum(start+1, nums, target - nums[target]) || groupSum(start+1, nums, target));
    }
  }

  public static boolean groupSum6(int start, int[] nums, int target){
    if(start >= nums.length)return target == 0;
    // if(start >= nums.length && target != 0)return false;
    // if(start >= nums.length && target == 0)return true;
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

  public static boolean splitOdd10(int[] nums){
    return odd10sort(nums, 0, 0, 0);
  }
  public static boolean odd10sort(int[] nums, int start, int oddSum, int tenSum){
    if(start >= nums.length)return tenSum%10 == 0 && oddSum%2 == 1;
    // if(start >= nums.length && (tenSum%10 != 0 || oddSum %2 != 1))return false;
    // if(start >= nums.length && (tenSum%10 == 0 || oddSum %2 == 1))return true;
    else{
      return odd10sort(nums, start+1, oddSum + nums[start], tenSum) || odd10sort(nums, start+1, oddSum, tenSum + nums[start]);
    }
  }

  public static boolean split53(int[] nums){
    return split53(nums, 0,0,0);
  }
  public static boolean split53(int[] nums, int start, int fiveSum, int threeSum){
    if(start >= nums.length)return( fiveSum == threeSum);
    else{
      if(nums[start] % 5 == 0)return split53(nums,start+1, fiveSum + nums[start], threeSum);
      else if (nums[start] % 3 == 0)return split53(nums, start + 1, fiveSum, threeSum + nums[start]);
      else{
        return split53(nums,start+1, fiveSum + nums[start], threeSum) || split53(nums, start + 1, fiveSum, threeSum + nums[start]);
      }
    }
  }

  public static boolean groupSum5(int start, int[] nums, int target){
    if(start >= nums.length)return target == 0;
    else{
      if(nums[start]%5 == 0 && start < nums.length-1 && nums[start+1] == 1){
        return groupSum5(start +2, nums, target - nums[start]);
      }
      else if(nums[start]%5 ==0)return groupSum5(start+1, nums, target - nums[start]);
      else{
        return groupSum5(start+1, nums,target) || groupSum5(start+1, nums, target - nums[start]);
      }
    }
  }

  public static boolean splitArray(int[]nums){
    return splitArray(nums,0,0);
  }

  public static boolean splitArray(int[]nums, int start, int sum){
    if(start >= nums.length)return sum == 0;
    else{
      return splitArray(nums,start +1, sum + nums[start]) || splitArray(nums,start +1, sum - nums[start]);
    }
  }

}
