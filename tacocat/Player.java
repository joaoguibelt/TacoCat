
package tacocat;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Player extends GameObject{

    Random r = new Random();
    
    Player(int x, int y){
        super(x,y);
      
        this.setVelx(r.nextInt(5) + 1);
        this.setVely(r.nextInt(5) + 1);


  
    }
    
    
    @Override
    public void tick() {
        this.setX(this.getX() + this.getVelx());
        this.setY(this.getY() + this.getVely());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.getX(), this.getY(), 32, 32);
    }
    
}
