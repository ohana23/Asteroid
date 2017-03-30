/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Daniel Ohana
*/

package asteroidgame;

import blobz.Blob;
import blobz.BlobProximity;
import java.awt.Color;


public class Missile extends Blob implements BlobProximity {
    
    public Missile(int x, int y, double theta) {
        super(x, y, Color.YELLOW);
        super.setSize(5);
        
        double speed = 5.0;
        int dx = (int) Math.round(speed * Math.cos(theta));
        int dy = (int) Math.round(speed * Math.sin(theta));
        
        super.setDelta(dx, dy);
    }
    
}