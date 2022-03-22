import java.util.Arrays;
public class Merge{

  public static void main(String[] args) {
    int[] t1 = {1,2,5,7,54};
    int[] t2 = {1,2,3,5,6};
    int[] t3 = {53,5,56,2,4,36,43,1,6,2};
    // int[] yea = merge(t1,t2);
    int[] t4 = {1,2,3,4,2,3,4};
    System.out.println(Arrays.toString(t4));
    int[] t5 = t4.clone();
    merge(t4,t5,0,6);
    System.out.println(Arrays.toString(t4));

    // System.out.println(Arrays.toString(yea));
  }


  public static void merge(int[] data, int[] temp, int leftIndex, int rightIndex){
    int middle = (leftIndex+rightIndex)/2;
    int rightStart = middle;
    int i = 0;
    while(leftIndex < middle && rightStart < rightIndex){
      if(temp[leftIndex] < temp[rightIndex]){
        data[i] = temp[leftIndex];
        i++;leftIndex++;
      }
      else{
        data[i] = temp[rightStart];
        rightStart++;i++;
      }
    }
    for(int j = rightStart; j < rightIndex; j++){
      data[i] = temp[j];
      i++;
    }
    for(int j = leftIndex; j < middle; j++){
      data[i] = temp[j];
      i++;
    }

  }

  public static int[] merge(int[] left, int[] right){
    int[] merged = new int[left.length + right.length];
    int lCt = 0;
    int rCt = 0;
    int i = 0;
    while(lCt<left.length && rCt<right.length){
      if(left[lCt] < right[rCt]){
        merged[i] = left[lCt];
        i++;lCt++;
      }
      else{
        merged[i] = right[rCt];
        i++;rCt++;
      }
      //System.out.println(Arrays.toString(merged));
    }
    for(int j = rCt; j < right.length; j++){
      merged[i] = right[j];
      i++;
    }
    for(int j = lCt; j < left.length; j++){
      merged[i] = left[j];
      i++;
    }


    //System.out.println(merged.length);
    return merged;
  }
  public static void mergesort(int[] data){
    //if(data.length < 44)insertionSort(data);
    int[] temp = new int[data.length];
    for(int i =0; i <data.length; i++){
      temp[i] = data[i];
    }
    mergesort(data, temp);
    // int[] temp = mergesortH(data);
    // for(int i = 0; i < temp.length; i++){
    //   data[i] = temp[i];
    // }
  }

  public static int[] mergesortH(int[] data){
    if(data.length > 1){
      int halfway = data.length/2;
      int[] left = new int[halfway];
      int[] right = new int[data.length-halfway];
      copy(left, data, 0, halfway);
      copy(right, data, halfway, data.length);
      mergesort(left);
      mergesort(right);
      data = merge(left, right);
    }
    return data;
  }

  public static void mergesort(int[] data, int[] temp){
    if(data.length > 1){
      return;
    }
  }

  public static void insertionSort(int[] ary){
    /*Your implementation here*/
    for(int i = 1; i < ary.length; i++){
      int prev = i-1;
      int rightpos = i;
      int val = ary[i];
      while(prev >= 0 && ary[i] < ary[prev]){
        rightpos--;
        prev--;
      }
      for(int j = i -1; j >= rightpos; j--){
        ary[j+1] = ary[j];
      }
      ary[rightpos] = val;
    }
  }

  private static void copy(int[] copy, int[] og, int start, int end){
    for(int i = start; i < end; i++){
      copy[i-start] = og[i];
    }
  }



}
