/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testZeroOrange()
  {
      Picture busterboy = new Picture("bustaboy.jpg");
      Picture kamen = new Picture("kamen.jpg");
      Pixel[][] pixels = busterboy.getPixels2D();
      Pixel[][] pixels2 = kamen.getPixels2D();
      busterboy.cropAndCopy(kamen, 20, 400, 45, 600, 500, 600);
      busterboy.zeroBlue();
      busterboy.mirrorHorizontal();
      busterboy.mirrorVertical();
      for(Pixel[] rowArray: pixels)
      {
          for(Pixel pixelObj: rowArray)
          {
              if(pixelObj.getGreen() <= 50 && pixelObj.getRed() <= 50)
              {
                  pixelObj.setBlue(pixelObj.getBlue() + 50);
                }
            }
        }
      busterboy.explore();
    }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorDiagonal()
  {
    Picture zerg = new Picture("zerg.jpg");
    zerg.explore();
    zerg.mirrorDiagonal();
    zerg.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorArms()
  {
    Picture temple = new Picture("snowman.jpg");
    temple.explore();
    temple.mirrorArms();
    temple.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorGull()
  {
    Picture temple = new Picture("seagull.jpg");
    temple.explore();
    temple.mirrorGull();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testCopy()
  {
    Picture swan = new Picture("swan.jpg");
    swan.copy(swan,10,50);
    swan.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testCropAndCopy()
  {
    Picture swan = new Picture("swan.jpg");
    Picture zerg = new Picture("zerg.jpg");
    swan.cropAndCopy(zerg,10,110,105,125,100,150);
    swan.explore();
  }
  
  public static void testScaleByHalf()
  {
      Picture zerg = new Picture("zerg.jpg");
      Picture o_zerg = new Picture ("zerg.jpg");
      zerg.scaleByHalf();
      o_zerg.explore();
      zerg.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    testZeroOrange();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    testMirrorVerticalRightToLeft();
    testMirrorHorizontal();
    testMirrorHorizontalBotToTop();
    testMirrorDiagonal();
    //testMirrorTemple();
    testMirrorArms();
    testMirrorGull();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    testCopy();
    testScaleByHalf();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}