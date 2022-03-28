public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "[";
    if(size == 0; return ans+"]");

    if(start <= end){
      for(int i = start; i<=end; i++){
        if(i != end){
          ans += data[i] + ", ";
        }
        else{
          ans += data[i] + "]";
        }
      }
    }

    if(start > end){
      for(int i = start; i < data.length; i++)}{
        ans += data[i] + ", ";
      }
      for(int i =0; i <= end; i++){
        if(i != end){
          ans += data[i] += ", ";
        }
        else{
          ans += data[i] + "]";
        }
      }
    }
    return ans;
  }

  public void addFirst(E element){
    if(size == data.length){
      
    }
    if(size == 0){
      start = 0;
      data[start] = element;
      end = 0;
    }

    else{
      if(start >0){
        start--;
        data[start] = element;
      }
      else{
        start == data.length-1;
        data[]
      }
    }

  }

  public void addLast(E element){ }

  public E removeFirst(){ }

  public E removeLast(){ }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }
}
