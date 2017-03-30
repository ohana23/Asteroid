/*
 * University of Central Florida
 * COP3330 Spring 2017
 * Author: Daniel Ohana
*/

package asteroidgame;

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;

public class AsteroidGame implements BlobGUI {

    public static void main(String[] args) {
        new AsteroidGame();
    }
    
    public SandBox sb = new SandBox();
    
    public AsteroidGame() {
        sb.setSandBoxMode(SandBoxMode.FLOW);
        sb.setFrameRate(15);
        sb.init(this);
    }

    @Override
    public void generate() {
      int rx = 300, ry = 300;
      int x = 0, y = 0;
      double rotation, test = 0;

      Random rand = new Random();

      Rocket rocket = new Rocket(rx, ry, sb);
      sb.addBlob(rocket);

      for (int i = 0; i < 10; i++)
      {
        Random random = new Random();
        int max = 3, min = -3;

        do {
          x = random.nextInt(max - min) + min;
          y = random.nextInt(max - min) + min;
        } while ((x == 0) & (y == 0));

        if ((test = rand.nextInt(100) + 1) <= 500) 
            rotation = 0.1;
        else 
            rotation = -0.1;

        Asteroid asteroid = new Asteroid(x, y, rotation);
        sb.addBlob(asteroid);
      }
      
    }
}
