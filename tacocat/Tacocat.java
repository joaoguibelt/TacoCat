package tacocat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Tacocat extends GameObject {
    private int limiteEsquerda;
    private int limiteDireita;
    BufferedImage tacocat;

    Color c = new Color(0.5f, 0.1f, 1f,.5f);

    
    public Tacocat(int x, int y, int velx, int vely, int limEsq, int limDir, int width, int height, boolean direita) {
        super(x, y, ID.Tacocat, velx, vely, width, height, 1, direita);
        this.limiteDireita = limDir;
        this.limiteEsquerda = limEsq;
        

        
        
        File file = new File("");
        
        try {


            this.tacocat = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\main\\java\\tacocat\\Sprites\\tacocat.png"));
          
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void render(Graphics g) {

        g.drawImage(tacocat, this.getX()-17, this.getY()-15, null);
        
    }
    
    @Override
    public void tick() {
        this.setX(this.getX() + this.getVelx());
        this.setY(this.getY() + this.getVely());
        
        if(this.getX() <= limiteEsquerda || this.getX() >= (limiteDireita)){
            this.setVelx(this.getVelx()*-1);
        }
        if(this.getY() <= 0 || this.getY() >= (Jogo.H)/2){
            this.setVely(this.getVely()*-1);
        }
        
    }


    @Override
    public void frenesi() {
       this.setX(this.getX() + this.getVelx());
        this.setY(this.getY() + this.getVely());
        
        if(this.getX() <= limiteEsquerda || this.getX() >= (limiteDireita)){
            this.setVelx(this.getVelx()*-1);
        }
        if(this.getY() <= 0 || this.getY() >= (Jogo.H)/2){
            this.setVely(this.getVely()*-1);
        }
    }
    

}
