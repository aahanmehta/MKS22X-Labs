public class Text{
  /*Base colors*/
  public static int BLACK = 30;
  public static int RED = 31;
  public static int GREEN = 32;
  public static int YELLOW = 33;
  public static int BLUE = 34;
  public static int MAGENTA = 35;
  public static int CYAN = 36;
  public static int WHITE = 37;

  /*Text modifiers to be ADDED to a color*/
  public static int BACKGROUND = 10;
  public static int BRIGHT = 60;

  /*Text modifiers that are separate from color*/
  public static int BOLD = 1;
  public static int UNDERLINE = 4;
  public static int INVERTED = 7;

  public static final String CLEAR_SCREEN =  "\033[2J";
  public static final String HIDE_CURSOR =  "\033[?25l";
  public static final String SHOW_CURSOR =  "\033[?25h";
  //use this to go back to normal terminal colors
  public static final String RESET = "\033[0m"+SHOW_CURSOR;
  /*Reset colors*/
  public static void reset(){
    System.out.print("\u001b[0m");
  }


  public static void hideCursor(){
    System.out.print("\u001b[?25l");
  }

  public static void showCursor(){
    System.out.print("\u001b[?25h");
  }

  //terminal specific character to move the cursor to a location
  //top left is 1,1
  public static String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
  }

  public static void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  /*Erases all text on the terminal.*/
  public static void clear(){
    System.out.print("\u001b[2J");
  }

  /*Overloaded Colorize methods.
  c1,c2 and c3 are any color modifiers such as bold/color/background color etc.
  */
  public static String colorize(String text,int c1){
    return ("\u001b[" + c1 + "m"+text+"\u001b[0m");
  }
  public static String colorize(String text,int c1,int c2){
    return ("\u001b[" + c1 + ";" + c2 + "m"+text+"\u001b[0m");
  }
  public static String colorize(String text,int c1,int c2,int c3){
    return ("\u001b[" + c1 + ";" + c2 + ";" + c3 + "m"+text+"\u001b[0m");
  }


  //Tested and working in:
  //git-bash (windows 10),    wsl (windows 10+11),   powershell windows 11
  public static void main(String[] args) {
    hideCursor();
    clear();

    go(1,1);
    System.out.println("Abra cadabra hocus pocus...");
    System.out.println("Abra "+colorize("cadabra",BOLD,YELLOW+BRIGHT,BLUE+BACKGROUND)+" hocus pocus...");
    System.out.println(colorize("Abra",BOLD,BLACK,YELLOW+BACKGROUND+BRIGHT)+" cadabra hocus pocus...");

    go(1,1);//top left
    System.out.print("TOP!");//overwrites the "Abra" on line 1

    go(4,30);
    System.out.print("right?");

    go(5,1);//put the terminal at the end of the output again before the program ends.
    reset();
    showCursor();
  }
}
