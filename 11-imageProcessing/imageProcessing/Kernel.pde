
public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color
   */
  color calcNewColor(PImage img, int x, int y) {
    color clr = 0;
    float r = 0;
    float g = 0;
    float b = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (inBounds(i, j)) {
          r += red(img.get(x+i, y+j)) * kernel[i+1][j+1];
          g += green(img.get(x+i, y+j)) * kernel[i+1][j+1];
          b += blue(img.get(x+i, y+j)) * kernel[i+1][j+1];
        }
        if (r>255)r=255; if (r<0)r=0;
        if (g>255)g=255; if (g<0)g=0;
        if (b>255)b=255; if (b<0)b=0;
      }
    }

    clr = color(r, g, b);
    return clr;
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int i = 0; i < source.width; i++) {
      for (int j = 0; j < source.height; j++) {
        destination.set(i, j, calcNewColor(source, i, j));
      }
    }
  }
  boolean inBounds(int x, int y) {
    if (x >= 0 && x <= width && y >= 0 && y <= height)return true;
    return false;
  }
}
