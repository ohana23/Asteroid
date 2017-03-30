/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Daniel Ohana
*/

package asteroidgame;

import blobz.BlobUtils;
import blobz.PolyBlob;
import java.awt.Point;
import java.util.Random;


public class Asteroid extends PolyBlob {
    
    private static final Random random = new Random();
    
    public Asteroid (int idx, int jdx, double rot) {
        // Constructs a polyblob offscreen with the velocities
        // and rotation rate brought in from the Asteroid parameters.
        super(-100, -100, rot);
        setDelta(idx, jdx);

        // Generate a random number of sides between 5 and 9, inclusive
        int s = random.nextInt(9 - 5 + 1) + 5;
        
        int distance;
        double region;
        double angle;
        Point[] p = new Point[s];
        
        for (int i = 0; i < s; i++) {  
            
            // Distance from the origin is a random value between 5 and 15.
            distance = random.nextInt(15 - 5 + 1) + 5;
            
            // Create an angle for each vertex, in a random region.
            region = ((2 * Math.PI) / s);
            angle = (region * i) + (Math.random() * region);
           
            // Rotate a point clockwise on the axis at the angle.
            p[i] = BlobUtils.rotatePoint(distance, angle);
            p[i] = new Point((int) (p[i].getX()), (int) (p[i].getY()));
            
            // Set rotation rate and polygon shape.
            setRate(rot);
        }
        
        setPolygon(p);
        
    }
}