package edu.ucsb.cs56.w15.drawings.vivek_patel.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;   
    
    private double x = 100;
    private double y = 100;
    private double delta = .1;

    private RingedLollipop test = new RingedLollipop(450.0, 275.0, 100.0, 200.0);
    private RingedLollipop test2 = new RingedLollipop(100.0, 75.0, 50.0, 100.0);		
    
    private double dx = 3;
    private double count = -5;
    private double scale = 2.0;			
    private double scale2 = 1.5;
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(1000,750);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
			
	});
      }
      // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {
	if (scale > 2.4) {
		delta *= -1; 	
	} else if (scale < 0.2) {
		delta *= -1;
	}
	scale += delta;
	scale2 += delta;	
        Graphics2D g2 = (Graphics2D) g;
        // Clear the panel first
        g2.setColor(Color.white);
        g2.fillRect(0,0,this.getWidth(), this.getHeight());

        // Draw the Lollipops
	Shape test1 = ShapeTransforms.rotatedCopyOf(test, (dx*Math.PI)/180);
	test1 = ShapeTransforms.scaledCopyOf(test1, scale, scale);
	Shape test3 = ShapeTransforms.rotatedCopyOf(test2, (dx*Math.PI)/150);
	test3 = ShapeTransforms.scaledCopyOf(test3, scale2, scale2);
	g2.setColor(pickColor());
        g2.draw(test1);
	g2.setColor(pickColor());
	g2.draw(test3);
       }
	
	public Color pickColor() { 
		int randomColor = (int)(Math.random() * 5);
		Color returnColor = Color.BLACK;
		switch(randomColor) {
			case(1): returnColor = Color.RED;
				 break;
			case(2): returnColor = Color.LIGHT_GRAY;
				 break;
			case(3): returnColor = Color.MAGENTA;
			         break;
			case(4): returnColor = Color.CYAN;
				 break;
			case(5): returnColor = Color.ORANGE;
				 break;
		}
		return returnColor;
	}  		
    }
    
    class Animation extends Thread {
      public void run() {
        try {
	while (true) {
            // Bounce off the walls	
	dx += 3;
	panel.repaint();
	Thread.sleep(35);
			}
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
