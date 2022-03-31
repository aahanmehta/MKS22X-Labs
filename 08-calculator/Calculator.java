import java.util.*;
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
    Scanner scan = new Scanner(s);
    ArrayDeque<Double> bob = new ArrayDeque<Double>();
    int operands = 0;
    int operators = 0;
    while(scan.hasNext()){
      String mary = scan.next();
      if(mary.equals("+")){
	bob.push(bob.pop() + bob.pop());
	operators++;
      }
      else if(mary.equals("*")){
	bob.push(bob.pop() * bob.pop());
	operators++;
      }
      else if(mary.equals("-")){
        double a = bob.pop();
	double b = bob.pop();
	bob.push(b-a);
	operators++;
      }
      else if(mary.equals("/")){
	double a = bob.pop();
	double b = bob.pop();
	bob.push(b/a);
	operators++;
      }
      else if(mary.equals("%")){
	double a = bob.pop();
	double b = bob.pop();
	bob.push(b%a);
	operators++;
      }
      else{
	bob.push(Double.parseDouble(mary));
	operands++;
      }
    }
    if(operators>operands)throw new IllegalArgumentException("too many operators");

    return bob.pop();
  }

  public static void main(String[] args) {
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
  }
}
