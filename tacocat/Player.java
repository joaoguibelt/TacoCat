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
   BufferedImage imageParadoflip;
   BufferedImage imageBatendoflip; 
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
        try {
            this.imageParadoflip = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\gatoParadoflip.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.imageBatendoflip = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\gatoBatendoflip.png"));
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
        if(this.isDireita() == false){
            if(isParado() == true){
                g.drawImage(imageParado, this.getX(), this.getY(), null);
            }
            else if(isParado() == false){
                g.drawImage(imageBatendo, this.getX(), this.getY(), null);
            }
        }
        else if(this.isDireita() == true){
            if(isParado() == true){
                g.drawImage(imageParadoflip, this.getX(), this.getY(), null);
            }
            else if(isParado() == false){
                g.drawImage(imageBatendoflip, this.getX(), this.getY(), null);
            }
        }
    }

    @Override
    public void frenesi() {    }


    
    
    
}
