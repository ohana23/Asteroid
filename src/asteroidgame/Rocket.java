/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Daniel Ohana
*/

package asteroidgame;

import blobz.BlobAction;
import blobz.BlobProximity;
import blobz.BlobUtils;
import blobz.PolyBlob;
import blobz.SandBox;
import static java.awt.Color.RED;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class Rocket extends PolyBlob implements BlobAction, BlobProximity {
    
    private final Point[] p = {
        new Point(10, 0),
        new Point(-10, -7),
        new Point(-5, 0),
        new Point(-10, 7)
    };
    
    private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    public SandBox sandbox;
    
    public Rocket(int x, int y, SandBox sb) {
        
        // Create a stationary Rocket blob at the position specified by 
        // the parameters.
        super(0, 0, 0);
        super.setLoc(x, y);
        sandbox = sb;
        
        // Set its velocity, rotation rate, and color.
        super.setDelta(0, 0);
        super.setRate(0);
        super.setColor(RED);
        
        // Set the rocket's initial rotation facing to the right.
        super.setAngle(angle);
        super.setPolygon(p);
    }
    

    @Override
    public void keyAction(KeyEvent e) {
        
        switch (e.getKeyCode()) {
            // Spacebar. Shoot missile.
            case 32:
                BlobUtils.playSound();
                launch();
                break;
            // Left arrow. Rotate counterclockwise.
            case 37:
                if (angle < 0)
                    angle += 2 * (Math.PI);
                else
                    angle = angle - delta;
                
                super.setAngle(angle);
                break;
            // Up arrow. Move rocket in its forward direction.
            case 38:
                int xloc = (int) super.getLoc().getX();
                int yloc = (int) super.getLoc().getY();
                
                xloc = xloc + (int) Math.round(speed * Math.cos(angle));
                yloc = yloc + (int) Math.round(speed * Math.sin(angle));
                
                super.setLoc(xloc, yloc);
                break;
            // Right arrow. Rotate clockwise.
            case 39:
                angle += delta;
                
                if (angle > (2 * Math.PI))
                    angle -= (2 * Math.PI);
                
                super.setAngle(angle);
                break;
            // Invalid key.
            default:
                System.out.println("(invalid key)");
                break;
        }
    }
    
    public void launch() {
        // Calculate launch point.
        int distance = 5;
        int boundRadius = getSize() / 2;
        
        Point location = BlobUtils.rotatePoint(distance, boundRadius);
        location = getLoc();
        
       // Instantiate a Missile and add it to the SandBox.
       Missile missile = new Missile(location.x, location.y, angle);       
       sandbox.addBlob(missile);       
    }



}