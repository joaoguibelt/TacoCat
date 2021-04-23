package tacocat;

import java.awt.Color;
import java.awt.Graphics;

//HUD do jogo
public class HUD {
    
    public static int hp = 150;
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        //Barra de vida
        g.setColor(Color.gray);
        g.fillRect(0, 0, 16, 150);
        g.setColor(Color.green);
        g.fillRect(0, 0, 16, hp);
        g.setColor(Color.white);
        g.drawRect(0, 0, 16, 150);
    }
    
    
}
