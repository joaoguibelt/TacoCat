package tacocat;

import java.awt.Color;
import java.awt.Graphics;

public class Tacocat extends Inimigos {
    
    public Tacocat(int x, int y) {
        super(x, y);
        this.setVelx(3);
        this.setVely(-2);
    }
   
    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(this.getX(), this.getY(), 20, 20);
    }
    
    @Override
    public void tick() {
        this.setX(this.getX() + this.getVelx());
        this.setY(this.getY() + this.getVely());
        
        if(this.getX() <= 0 || this.getX() >= (Jogo.W-100)/2){
            this.setVelx(this.getVelx()*-1);
        }
        if(this.getY() <= 0 || this.getY() >= (Jogo.H)/2){
            this.setVely(this.getVely()*-1);
        }
    }

    @Override
    public void morrer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void frenesi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
