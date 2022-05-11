final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
final static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(mouseX,new OrbNode(mouseX, mouseY, 0, 0, 30));
}
void keyPressed() {
  if(key == 1)SPRING_CONSTANT*=1.2;
  if(key == 2)SPRING_CONSTANT*=0.8;
  
  if(key == 3)SPRING_DAMPEN*=1.2;
  if(key == 4)SPRING_DAMPEN*=0.8;
  
  if(key == 5)SPRING_LENGTH*=1.2;
  if(key == 6)SPRING_LENGTH*=0.8;
   
  if(key == 7)GRAVITY*=1.2;
  if(key == 8)GRAVITY*=0.8;
  
  if(key == BACKSPACE)orbs.delete(getNodeAt(x,y));
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
}