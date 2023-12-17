import java.awt.Color;

import acm.program.*;
import acm.graphics.*;
import acm.util.*;


public class ImageManip extends GraphicsProgram {
	public void run() {
		GImage rock = new GImage("kids.jpg");
		add(createGrayscale(rock));

	}
	
	private GImage applyColorTint(GImage grayscaleImage, int redTint, int greenTint, int blueTint) {
	    int[][] grayscaleArray = grayscaleImage.getPixelArray();
	    int height = grayscaleArray.length;
	    int width = grayscaleArray[0].length;

	    int[][] colorArray = new int[height][width];

	    // Iterate through each pixel in the grayscale image
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < width; j++) {
	            int grayValue = GImage.getRed(grayscaleArray[i][j]);

	            // Map the grayscale value to the specified color tint
	            int newRed = (int) (grayValue * (redTint / 255.0));
	            int newGreen = (int) (grayValue * (greenTint / 255.0));
	            int newBlue = (int) (grayValue * (blueTint / 255.0));

	            // Ensure that the color values are within the valid range (0-255)
	            newRed = Math.min(255, Math.max(0, newRed));
	            newGreen = Math.min(255, Math.max(0, newGreen));
	            newBlue = Math.min(255, Math.max(0, newBlue));

	            // Create a new RGB pixel with the color tint
	            colorArray[i][j] = GImage.createRGBPixel(newRed, newGreen, newBlue);
	        }
	    }

	    // Create and return a new GImage from the modified color array
	    return new GImage(colorArray);
	}
	
	private GImage createGrayscale(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = array[i][j];
				
				int r = GImage.getRed(pixel);
				int g = GImage.getGreen(pixel);
				int b = GImage.getBlue(pixel);
				
				int invertedR = 255 - r;
				int invertedG = 255 - g;
				int invertedB = 255 - b;
				
				int xx = computeLuminosity(r, g, b);
				
				int greenTint = Math.min(255, (int) (1.5 * g)); // Adjust the factor as needed
				
				int sepiaR = Math.min(255, (int) (0.393 * r + 0.769 * g + 0.189 * b));
	            int sepiaG = Math.min(255, (int) (0.349 * r + 0.686 * g + 0.168 * b));
	            int sepiaB = Math.min(255, (int) (0.272 * r + 0.534 * g + 0.131 * b));

				
				array[i][j] = GImage.createRGBPixel(invertedR, invertedG, invertedB);
			}
		}
		return new GImage(array);
	}
	
	private int computeLuminosity(int r, int g, int b) {
		return GMath.round(0.299 * r + 0.587 * g + 0.114 * b);
		
	}
	
	private GImage flipVertical(GImage image) {
		int [][] array = image.getPixelArray();
		int height = array.length;
		for (int p1 = 0; p1 < height / 2; p1++) {
			int p2 = height - p1 - 1;
			int[] temp = array[p1];
			array[p1] = array[p2];
			array[p2] = temp;
		}
		return new GImage(array);
	}
	
	private GImage flipHorizontal(GImage image) {
		int [][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		for (int i = 0; i < height; i++) {
			for (int p1 = 0; p1 < width / 2; p1++) {
				int p2 = width - p1 - 1;
				int temp = array[i][p1];
				array[i][p1] = array[i][p2];
				array[i][p2] = temp;
			}
		}
		return new GImage(array);
	}
	
	private GImage rotateLeft(GImage image) {
		int [][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		int[][] transposedArray = new int[width][height];
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < width; j++) {
	            transposedArray[j][i] = array[i][j];
	        }
	    }
	    
	
		return new GImage(transposedArray);
	}
	
	private GImage rotateRight(GImage image) {
		 int[][] array = image.getPixelArray();
		    int height = array.length;
		    int width = array[0].length;

		    for (int p1 = 0; p1 < height / 2; p1++) {
				int p2 = height - p1 - 1;
				int[] temp = array[rgen.nextInt(p1, p2)];
				array[rgen.nextInt(p1, p2)] = array[rgen.nextInt(p1, p2)];
				array[p2] = temp;
		    }
		        
		    return new GImage(array);
	}
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
