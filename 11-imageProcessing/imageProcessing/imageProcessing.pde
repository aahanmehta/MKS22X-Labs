int mode = 0;

String[] names = new String[]{
  "Identity", "Blur", "Sharpen", 
  "Outline", "Left Sobel", "Right Sobel", 
  "Top Sobel", "Emboss"
};
Kernel[] kernels = new Kernel[] {
  new Kernel( new float[][] {
    {0, 0, 0}, 
    {0, 1, 0}, 
  {0, 0, 0}    }), 
  new Kernel( new float[][] {
    {.111, .111, .111}, 
    {.111, .111, .111}, 
  {.111, .111, .111}    }), 
  new Kernel( new float[][] {
    {0, -1, 0}, 
    {-1, 5, -1}, 
  {0, -1, 0}    }), 
  new Kernel( new float[][] {
    {-1, -1, -1}, 
    {-1, 8, -1}, 
  {-1, -1, -1}    }), 
  new Kernel( new float[][] {
    {1, 0, -1}, 
    {2, 0, -2}, 
  {1, 0, -1}    }), 
  new Kernel( new float[][] {
    {-1, 0, 1}, 
    {-2, 0, 2}, 
  {-1, 0, 1}    }), 
  new Kernel( new float[][] {
    {1, 2, 1}, 
    {0, 0, 0}, 
  {-1, -2, -1}    }), 
  new Kernel( new float[][] {
    {-2, -1, 0}, 
    {-1, 1, 1}, 
  {0, 1, 2}    })
};
void setup() {
  size(1450, 500);
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();

}
void keyPressed() {
  mode = (mode + 1)%8;
}

void draw(){
  
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
  kernels[mode].apply(car, output);
  image(car, 0, 0);
  image(output, car.width, 0);
  text("" + names[mode],1380,480);
}
