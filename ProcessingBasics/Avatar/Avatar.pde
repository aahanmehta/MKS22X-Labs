/** Avatar: a function that draws a face/character/animal/object,

 *at a particular x,y location.


 */
 
 
 
void avatar(int x, int y){
  fill(0,0,0);
  rect(x-100,y-100,200,170);
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
   
   
  // 200x180, x,y between eyes
  
}



  int x,y;
  int MODE;
  int click;
  void setup(){
           size(800,800);
           MODE = 3;
           x = width/2;
           y = height/2;
           click = 0;
  }
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
           if(click%2==0 && mousePressed){
             MODE+=1;
             if(MODE == 4)MODE =1;
           }
  }
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change each by +1, 0, or -1 randomly
     mode 3: change by +1 each, but if they hit the end of the screen ,
           wrap back around to the other end of the screen
    */

    switch(MODE){
     case 1:
       return (int) (random(800));
     case 2:
       int[] options = {1,-1,0};
       return x+options[(int)(random(3))];
     case 3:
       if(x == 800){
        x=0;y=0;
        return 0;
       }
       return x+1;
     default:
       return 0;
    }
    
  }
