package edu.ucsb.cs56.w15.drawings.vivek_patel.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Vivek Patel
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few lollipops
     */

    public static void drawPicture1(Graphics2D g2) {

	Lollipop l1 = new Lollipop(100,250,50,75);
	g2.setColor(Color.BLUE); g2.draw(l1);
	
	// Make a blue lollipop that's half the size, 
	// and moved over 150 pixels in x direction

	Shape l2 = ShapeTransforms.scaledCopyOfLL(l1,0.5,0.5);
	l2 = ShapeTransforms.translatedCopyOf(l2,150,0);
	g2.setColor(Color.BLACK); g2.draw(l2);
	
	// Here's a lollipop that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	l2 = ShapeTransforms.scaledCopyOfLL(l2,4,4);
	l2 = ShapeTransforms.translatedCopyOf(l2,150,0);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(l2); 
	
	// Draw two Ringed Lollipops
	
	RingedLollipop rl1 = new RingedLollipop(50,350,40,75);
	RingedLollipop rl2 = new RingedLollipop(550,200,100,200);
	
	g2.draw(rl1);
	g2.setColor(new Color(0xA52A2A)); g2.draw(rl2);
	
	g2.setColor(Color.BLACK); 
	g2.drawString("Some lollipops by Vivek Patel", 20,20);
    }


    /** Draw a picture with a few lollipops (plain and ringed)
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some lollipops.
	
	Lollipop large = new Lollipop(100,50,150,225);
	Lollipop small = new Lollipop(20,50,20,50);
	Lollipop skinny = new Lollipop(20,150,20,70);
	Lollipop tiny = new Lollipop(20,225,10,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(skinny);
	g2.setColor(Color.MAGENTA); g2.draw(tiny);
	
	Lollipop l1 = new Lollipop(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(l1);
	
	// Make a black lollipop that's half the size, 
	// and moved over 150 pixels in x direction
	Shape l2 = ShapeTransforms.scaledCopyOf(l1,0.5,0.5);
	l2 = ShapeTransforms.translatedCopyOf(l2,150,0);
	g2.setColor(Color.BLACK); g2.draw(l2);
	
	// Here's a lollipop that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	l2 = ShapeTransforms.scaledCopyOf(l2,4,4);
	l2 = ShapeTransforms.translatedCopyOf(l2,150,0);
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x

	g2.setColor(new Color(0x002FA7)); 
	g2.draw(l2); 
	
	// Draw two Ringed Lollipops
	
	RingedLollipop rl1 = new RingedLollipop(50,350,40,75);
	RingedLollipop rl2 = new RingedLollipop(400,150,100,300);
	
	g2.draw(rl1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second Ringed lollipop 45 degrees around its center.
	Shape rl3 = ShapeTransforms.rotatedCopyOf(rl2, Math.PI/4.0);

	g2.draw(rl3);
	
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of lollipops by Vivek Patel", 20,20);
    }
  
    /** Draw a different picture with some lollipops
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A couple of Lollipops by Vivek Patel", 20,20);

	
	// Draw some lollipops (plain and ringed).
	
       RingedLollipop large = new RingedLollipop(100,100,150,250);
       Lollipop small = new Lollipop(20,60,30,60);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
