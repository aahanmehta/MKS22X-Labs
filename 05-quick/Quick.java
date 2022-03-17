import java.util.Arrays;
public class Quick{
  public static void main(String[] args) {
    int [] d1 = new int[] {-4,3,-2,-1,0,8,9,-15};
    int [] d2 = new int[] {0};
    int [] d3 = new int[] {1,1,1,1,1};
    int [] d4 = new int[] {993,994,995,4,3,2,1,0,997,998,999};
    int [] d5 = new int[] {1};
    int [] d6 = new int[] {997,998,999,4,3,2,1,0};
    int [] d7 = new int[] {999,5,999,5,1,4,2,5,5,999,99};
    int[][] data = new int[][] {d1,d2,d3,d4,d5,d6,d7};
    // for(int i = 0; i < data.length; i++){
    //   System.out.println("Original: "+Arrays.toString(data[i]));
    //   int pivot = partition( data[i] , 0, data[i].length-1);
    //   System.out.println("Pivot value: "+data[i][pivot]+ ", Pivot index: "+pivot);
    //   System.out.println("Modified: "+Arrays.toString(data[i]));
    //   System.out.println();
    // }
    for(int i = 0; i < data.length; i++){
      System.out.println("Original: "+Arrays.toString(data[i]));
      quicksort(data[i]);
      System.out.println("Original: "+Arrays.toString(data[i]));
      System.out.println();
    }

  }


  public static void quicksort(int[] data){
    quicksort(data,0,data.length-1);
  }
  public static void quicksort(int[] data, int start, int end){
    if(end - start >= 1){  
      int pIndex = partition(data, start, end);
      quicksort(data, start, pIndex-1);
      quicksort(data, pIndex+1, end);
    }
  }

  public static int quickselect(int[] data, int k){
    if(k>=data.length || k<0)return -1;
    int pIndex = partition(data, 0, data.length-1);
    while(k != pIndex){
      if(k < pIndex){
        pIndex = partition(data, 0, pIndex-1);
      }
      else{
        pIndex = partition(data, pIndex+1, data.length-1);
      }
    }
    return data[k];
  }
  /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the
  * corresponding element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element
  * are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are
  *placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */
  public static int partition ( int [] data, int start, int end){
    int index = (int) (Math.random() * (end-start) + start);
    //System.out.println(index);
    int pivot = data[index];
    //System.out.println(pivot);
    boolean alt = false;
    swap(data, index, start);
    index = start;
    // System.out.println(Arrays.toString(data));
    // System.out.println(index);
    // System.out.println("loop");
    // System.out.println();
    for(int i = start+1; i <= end; i++){
      if(data[i] < pivot){
        swap(data, i, index);
        index++;
      }
      else if(data[i] > pivot){
        swap(data, i, end);
        end--;
        i--;
      }
      else if(data[i] == pivot){
        if(alt){
          alt = false;
          swap(data, i, index);
          index++;
        }
        else{
          alt = true;
          swap(data,i,end);
          end--;
          i--;
        }
      }
      // System.out.println(Arrays.toString(data));
      // System.out.println(index);
      // System.out.println();
    }

    // System.out.println(pivot);
    // System.out.println(toString(data));
    return index;
  }

  private static void swap(int[] data, int x, int y) {
    int swap = data[x];
    data[x] = data[y];
    data[y] = swap;
  }

  public static String toString(int[] ary){
    String ans = "[";
    for(int c:ary){
      ans += c + ", ";
    }
    return ans + ']';
  }

}
