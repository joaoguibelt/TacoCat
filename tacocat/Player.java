package tacocat;

import java.awt.Color;
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
        super(x, y, ID.Player);
      
        File file = new File("");
        
        try {
<<<<<<< Updated upstream
            this.imageParado = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\gatoBatendo.png"));
=======

            this.imageParado = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\gatoParado.png"));

>>>>>>> Stashed changes
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
<<<<<<< Updated upstream
            this.imageBatendo = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\gatoBatendo.png"));
=======

            this.imageBatendo = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\gatoParado.png"));

>>>>>>> Stashed changes
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
        g.drawImage(imageParado, this.getX(), this.getY(), null);
        
    }

    @Override
    public void morrer() {    }

    @Override
    public void frenesi() {    }
    
}
