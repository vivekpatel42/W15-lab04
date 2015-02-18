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
	A Ringed Lollipop
	
	@author Vivek Patel
	@version for CS56, W15, UCSB 02/11/2015
*/

public class RingedLollipop extends Lollipop implements Shape {

	/**
		Constructor
		@param x x coordinate of upper left hand corner of ringed lollipop
		@param y y coordinate of upper left hand corner of ringed lollipop
		@param height Height of the ringed lollipop
		@param width Width of the ringed lollipop
	*/
	
	public RingedLollipop(double x, double y, double width, double height) {
		// Construct the basic lollipop shell
		super(x, y, width, height);
		Ellipse2D [] rings = new Ellipse2D[3];
		GeneralPath gp = this.get();
		double ringX;
		double ringY;
		double scale = 0.8;
		//Creates 3 rings inside lollipop, each one scaling 20% smaller than the one before
		for (int i = 0; i < 3; i++) {
			ringX = x + width/2.0 - width*scale/2.0;
			ringY = y + width/2.0 - width*scale/2.0;
			Ellipse2D.Double ring = new Ellipse2D.Double(ringX, ringY, width*scale, width*scale);
			rings[i] = ring;
			scale -= 0.2;
		}
		GeneralPath wholeLollipop = this.get();
		for (int i = 0; i < 3; i++) {
			wholeLollipop.append(rings[i], false);
		}
	}

}
