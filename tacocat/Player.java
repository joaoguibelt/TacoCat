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
    //Classe player vai ser o gato por enquanto só to testando as possibilidades

           
    BufferedImage imageParado;
   // BufferedImage imageBatendo = null;
    
    Player(int x, int y){
        super(x, y, ID.Player);
      
        
        try {
            this.imageParado = ImageIO.read(getClass().getResource("/tacocat/Sprites/tacocat_gato_parado.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
       // try {
          //  this.imageBatendo = ImageIO.read(new File("tacocat gato batendo.png"));
       // } catch (IOException ex) {
         //   Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }
    
    
    @Override
    public void tick() {
        this.setX(this.getX());
        this.setY(this.getY());
    }

    @Override
    public void render(Graphics g) {
        
        g.drawImage(imageParado, this.getX(), this.getY(), null);
        
        //g.setColor(Color.red);
       // g.fillRect(this.getX(), this.getY(), 50, 100);
    }

    @Override
    public void morrer() {    }

    @Override
    public void frenesi() {    }
    
}
