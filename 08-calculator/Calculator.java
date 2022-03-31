public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
  */
  public static double eval(String s){
    String[] postfix = s.split(" ");
    Deque<Double> stack = new Deque<Double>();
    for(String i:s){
      if(i.equals("+"))stack.addFirst(stack.removeFirst() + stack.removeFirst());
      if(i.equals("*"))stack.addFirst(stack.removeFirst() * stack.removeFirst());
      if(i.equals("-"){
        double x = stack.removeFirst();
        double y = stack.removeFirst();
        stack.addFirst(y-x);
      }
      if(i.equals("/"){
        double x = stack.removeFirst();
        double y = stack.removeFirst();
        stack.addFirst(y/x);
      }
      if(i.equals("%"){
        double x = stack.removeFirst();
        double y = stack.removeFirst();
        stack.addFirst(y%x);
      }

    }
    return stack.removeFirst();
  }

}
