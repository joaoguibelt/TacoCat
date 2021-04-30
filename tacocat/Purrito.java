package tacocat;

import java.awt.Color;
import java.awt.Graphics;

public class Purrito extends GameObject{
    
    public Purrito(int x, int y, int velx, int vely, int width, int height, boolean direita) {
        super(x, y,ID.Purrito, velx, vely,  width, height, 3, direita);
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
        //saber o lado que o inimigo está
        if(this.getX() > 230){
            this.setDireita(true);
        }
        else{
            this.setDireita(false);
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
