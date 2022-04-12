/** Avatar: a function that draws a face/character/animal/object,

 *at a particular x,y location.


 */
void avatar(int x, int y){
  //skull structure
  noStroke();
  fill(255);
  ellipse(x,y, 150, 100);
  rect(x-35,y+20,75, 50, 0,0,15,15);
  
  //eyes and nose
  fill(0,0,0);
  circle(x-20,y,30); circle(x+20,y,30);
  circle(x,y+20,10);
  
  //mouth and teeth
  stroke(0,0,0);
  strokeWeight(3);
  fill(255,255,255);
  rect(x-25,y+40,50,10);
  rect(x-25,y+51,50,10);
  rect(x-10,y+40,0.01,20);
  rect(x+10,y+40,0.01,20);
  
  //hat and band
  fill(228,217,111);
  rect(x-100,y-35,200,10);
  noStroke();
  arc(x,y-30,140,140,PI,2*PI);
  stroke(0,0,0);
  fill(255,0,0);
  rect(x-68,y-56,135,20,15);
  
  ////skull cross part
  //fill(255,255,255);
  //rotate(PI/4);
  //rect(x,y,200,40,25);
 
  
}



//to test your code, here is a setup/draw

//The code should draw 3 avatars, one of them moves.
int xp,yp;
void setup(){
  size(800,600);
  xp = 0;
  yp = 0;
}
void draw(){
  background(0,0,0);
  avatar(xp,yp);
  xp++;
  yp++;
  avatar(100,100);
  avatar(600,300);
}
