package tacocat;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject{
    //Classe player vai ser o gato por enquanto só to testando as possibilidades
    
    Player(int x, int y){
        super(x, y, ID.Player);
      
  
    }
    
    
    @Override
    public void tick() {
        this.setX(this.getX() + this.getVelx());
        this.setY(this.getY() + this.getVely());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.getX(), this.getY(), 50, 100);
    }
    
}
