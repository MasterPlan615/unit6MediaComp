import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    /** Method to set the blue to 0 */
    public void zeroOrange()
    {
        //work on
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                if(pixelObj.getBlue() <= 10 && pixelObj.getRed() >= 235 && pixelObj.getGreen() >= 70)
                {
                    pixelObj.setRed(0);
                    pixelObj.setBlue(255);
                    pixelObj.setGreen(165);
                }
            }
        }
    }
    
    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }

    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        } 
    }

    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        } 
    }

    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null, bottomPixel = null;
        if(pixels.length > pixels[0].length)
        {
            for(int row = 0; row < pixels[0].length; row++)
            {
                for(int col = 0; col < pixels[0].length; col++)
                {
                    topPixel = pixels[row][col];
                    bottomPixel = pixels[col][row];
                    bottomPixel.setColor(topPixel.getColor());
                }
            }
        }
        else if(pixels[0].length > pixels.length)
        {
            for(int row = 0; row < pixels.length; row++)
            {
                for(int col = 0; col < pixels.length; col++)
                {
                    topPixel = pixels[row][col];
                    bottomPixel = pixels[col][row];
                    bottomPixel.setColor(topPixel.getColor());
                }
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                count += 1;
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        System.out.println("Loop executes " + count + " times.");
    }

    public void mirrorArms()
    {
        int mirrorPoint = 195;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 157; row < mirrorPoint; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 103 ; col < 294; col++)
            {
                topPixel = pixels[row][col];      
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    public void mirrorGull()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    public void cropAndCopy( Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol, int startDestRow, int startDestCol )
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = sourcePicture.getPixels2D();
        for (int fromRow = startSourceRow, toRow = startDestRow; 
        fromRow < endSourceRow; 
        fromRow++, toRow++)
        {
            for (int fromCol = startSourceRow, toCol = startDestCol; 
            fromCol < endSourceCol;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    public void scaleByHalf()
    {
        Pixel[][] pixels = this.getPixels2D();
        int prow = 0;
        int pcol = 0;
        for(int row = 0; row < pixels.length; row++)
        {
            for(int col = 0; col < pixels[0].length; col++)
            {
                pixels[row / 2][col / 2].setColor(pixels[row][col].getColor());
                prow = row;
                pcol = col;
            }
        }
        for(int row = 0, col = 0; row <= prow; row++)
        {
            pixels[row][col].setColor(Color.WHITE);
        }
        for(int col = 0, row = 0; col <= pcol; col++)
        {
            pixels[row][col].setColor(Color.WHITE);
        }
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }
    
    public void createTheCollage()
    {
        Picture busterboy = new Picture("bustaboy.jpg");
        Picture busterboy2 = new Picture("bustaboy.jpg");
        Picture busterboy3 = new Picture("bustaboy.jpg");
        Picture busterboy4 = new Picture("bustaboy.jpg");
        this.copy(busterboy,0,0);
        this.copy(busterboy2,0,1890);
        this.copy(busterboy3,1483,0);
        this.copy(busterboy4,1483,1890);
        busterboy.mirrorVertical();
        busterboy.zeroBlue();
        Pixel[][] pixels = busterboy.getPixels2D();
        for(Pixel[] rowArray: pixels)
        {
          for(Pixel pixelObj: rowArray)
          {
              if(pixelObj.getGreen() >= 50 && pixelObj.getRed() >= 50)
              {
                  pixelObj.setRed(200);
                }
          }
        }
        busterboy2.mirrorDiagonal();
        //busterboy4.edgeDetection(10);
        Pixel[][] pixels4 = busterboy4.getPixels2D();
        for(Pixel[] rowArray: pixels4)
        {
          for(Pixel pixelObj: rowArray)
          {
              if(pixelObj.getGreen() <= 137 && pixelObj.getGreen() >= 60
                && pixelObj.getRed() <= 184 && pixelObj.getRed() >= 102
                && pixelObj.getBlue() <= 142 && pixelObj.getBlue() >= 69)
              {
                  pixelObj.setColor(Color.ORANGE);
              }
              else
              {
                  pixelObj.setColor(Color.BLUE);
              }
          }
        }
        Pixel[][] pixels3 = busterboy3.getPixels2D();
        for(Pixel[] rowArray: pixels3)
        {
          for(Pixel pixelObj: rowArray)
          {
              pixelObj.setBlue(255 - pixelObj.getBlue());
              pixelObj.setGreen(255 - pixelObj.getGreen());
              pixelObj.setRed(255 - pixelObj.getRed());
          }
        }
        busterboy3.mirrorHorizontal();
        busterboy3.mirrorVertical();
        Pixel[][] pixels2 = busterboy2.getPixels2D();
        for(int i = 0; i < pixels2.length; i+=2)
        {
            for(int j = 0; j < pixels2[0].length; j+=2)
            {
                pixels2[i][j].setColor(Color.WHITE);
            }
        }
        
        //3780x2966
        //this.copy(kamen,0,400);
        //this.copy(kamen,400,0);
        //busterboy.zeroBlue();
        //this.mirrorHorizontal();
        //this.mirrorVertical();
        
        this.write("collagelab.jpg");
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture collage = new Picture();
        collage.createTheCollage();
    }

} // this } is the end of class Picture, put all new methods before this
