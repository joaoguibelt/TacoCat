package tacocat;

import java.awt.Color;
import java.awt.Graphics;

public class Purrito extends Inimigos{
    
    public Purrito(int x, int y, int velx, int vely) {
        super(x, y, velx, vely, ID.Purrito);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(this.getX(), this.getY(), 50, 50);
    }

    @Override
    public void tick() {
        this.setX(this.getX() + this.getVelx());
        this.setY(this.getY() + this.getVely());
        if(this.getX() <= 0 || this.getX() >= (Jogo.W-30)){
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
