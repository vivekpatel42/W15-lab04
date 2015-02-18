package edu.ucsb.cs56.w15.drawings.vivek_patel.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
	A Lollipop
	
	@author Vivek Patel
	@version for CS56, W15, UCSB 02/11/2015
*/
public class Lollipop extends GeneralPathWrapper implements Shape {
	
	/**
		Constructor
		@param x x coordinate of upper left hand corner of lollipop
		@param y y coordinate of upper left hand corner of lollipop
		@param height Height of the lollipop
		@param width Width of the lollipop
	*/
	
	public Lollipop(double x, double y, double width, double height) {
		
		Ellipse2D.Double candy = new Ellipse2D.Double(x, y, width, width);
		
		// Calculates starting x and y coordinates and width and height of stick depending on parameters
		
		double stickX = x + width/2.0 - width/8.0;
		double stickY = y + width;
		double stickWidth = width/5.0;
		double stickHeight = height - width;
		
		Rectangle2D.Double stick = new Rectangle2D.Double(stickX, stickY, stickWidth, stickHeight);
		
		GeneralPath wholeLollipop = this.get();
		wholeLollipop.append(candy, false);
		wholeLollipop.append(stick,false);
	}

}
