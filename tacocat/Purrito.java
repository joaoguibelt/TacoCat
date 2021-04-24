package tacocat;

import java.awt.Color;
import java.awt.Graphics;

public class Purrito extends Inimigos{
    
    public Purrito(int x, int y) {
        super(x, y);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(this.getX(), this.getY(), 50, 100);
    }

    @Override
    public void tick() {
        this.setX(this.getX() + this.getVelx());
        this.setY(this.getY() + this.getVely());
    }
    
}
