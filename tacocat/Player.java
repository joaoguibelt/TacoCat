package tacocat;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Player extends GameObject{
 
   BufferedImage imageParado;
   BufferedImage imageBatendo;
    
    Player(int x, int y){
        super(x, y, ID.Player, true);
        File file = new File("");
        
        try {

            this.imageParado = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\gatoParado.png"));


        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            this.imageBatendo = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\gatoBatendo.png"));



        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @Override
    public void tick() {
        this.setX(this.getX());
        this.setY(this.getY());
    }

    @Override
    public void render(Graphics g) {
        g.fillRect(this.getX(), this.getY(), 50, 100);
        if(isParado() == true){
            g.drawImage(imageParado, this.getX(), this.getY(), null);
        }
        else if(isParado() == false){
            g.drawImage(imageBatendo, this.getX(), this.getY(), null);
        }
    }

    @Override
    public void frenesi() {    }


    
    
    
}
