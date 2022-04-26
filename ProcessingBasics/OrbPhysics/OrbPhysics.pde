ArrayList<Orb>orbList;
Orb Star;
void setup() {
  size(1000, 700);
  orbList = new ArrayList<Orb>();
  Star = new Orb(500, 350, 0, 0, 30, 0, 0);
  
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the size should be between [20.0,70.0)
  //the dx and dy should be [-3.0,3.0)
  orbList.add(new Orb(mouseX, mouseY, random(15)-3, random(6)-3, random(50)+20, 0, 0));
}
void draw() {
  
  background(255);
  Star.display();
  for (Orb o : orbList) {
    o.attract(Star);
    o.move();
    o.display();
    
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
}
public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float xAcc, yAcc;
  float radius;
  color c;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_, float xAcc_, float yAcc_) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    xAcc = xAcc_;
    yAcc = yAcc_;
    //random color... why not.
    c = color(random(255), random(255), random(255));
  }


  void display() {
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    fill(c);
    ellipse(x, y, radius, radius);
  }

  void move() {
    //PART 2

    xSpeed+=xAcc;
    ySpeed-=yAcc;
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    x+=xSpeed;
    y+=ySpeed;
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    if (x - radius/4 <= 0)xSpeed = Math.abs(xSpeed);
    if (x + radius/4 >= width)xSpeed = -Math.abs(xSpeed);
    if (y - radius/4 <= 0)ySpeed = Math.abs(ySpeed);
    if (y + radius/4 >= height)ySpeed = -Math.abs(ySpeed);
  }

  void attract(Orb other) {
    xSpeed += (other.x-x) / ( dist(x, y, other.x, other.y) * dist(x, y, other.x, other.y) ) * 10;
    ySpeed += (other.y-y) / ( dist(x, y, other.x, other.y) * dist(x, y, other.x, other.y) ) * 10;
  }
}
