package tacocat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Purrito extends GameObject{
    BufferedImage purrito;

    Color c=new Color(1f,0f,0f,.5f );
    

    public Purrito(int x, int y, int velx, int vely, int width, int height, boolean direita) {
        super(x, y,ID.Purrito, velx, vely,  width, height, 3, direita);
        
        File file = new File("");
        
        try {

            this.purrito = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\main\\java\\tacocat\\Sprites\\purrito.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
    @Override
    public void render(Graphics g) {

        g.drawImage(purrito, this.getX()-5, this.getY()-5, null);
        g.setColor(c);

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
