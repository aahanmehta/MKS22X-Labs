final static int SPRING = 2;
 float SPRING_LENGTH = 50;
 float SPRING_DAMPEN = 0.990;
 float SPRING_CONSTANT = 0.015;
 float GRAVITY = 0.35;
final static int MODE = SPRING;
int CLICK_MODE;


OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
  CLICK_MODE = 0;
}
void mouseClicked() {
  if(CLICK_MODE == 0)orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
  if(CLICK_MODE == 1)orbs.add(mouseX,new OrbNode(mouseX, mouseY, 0, 0, 30));
  if(CLICK_MODE == 2)orbs.delete(orbs.getNodeAt(mouseX,mouseY));
}
void keyPressed() {
  if(key == '1')SPRING_CONSTANT*=1.2;
  if(key == '2')SPRING_CONSTANT*=0.8;
  
  if(key == '3')SPRING_DAMPEN*=1.01;
  if(key == '4')SPRING_DAMPEN*=0.99;
  
  if(key == '5')SPRING_LENGTH+=1.2;
  if(key == '6')SPRING_LENGTH*=0.8;
   
  if(key == '7')GRAVITY*=1.2;
  if(key == '8')GRAVITY*=0.8;
  
  if(key == ' '){
   CLICK_MODE = (CLICK_MODE + 1) % 3; 
  }
}
void draw() {
  if(SPRING_DAMPEN > 1)SPRING_DAMPEN = 0.9;
  background(255);
  orbs.processAll();
  orbs.display();
  
  text("Gravity: " + GRAVITY,20,70);
  text("SPRING_LENGTH: " + SPRING_LENGTH,20,50);
  text("SPRING_CONSTANT: " + SPRING_CONSTANT,20,10);
  text("SPRING_DAMPEN: " + SPRING_DAMPEN,20,30);
  if(CLICK_MODE == 0)text("Add",20,90);
  if(CLICK_MODE == 1)text("Insert",20,90);
  if(CLICK_MODE == 2)text("Delete",20,90);
}
