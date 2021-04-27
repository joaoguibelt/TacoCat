package tacocat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Mouse extends MouseAdapter{
    
    private Ajudante ajudante;
    private Random r = new Random();
    
    public Mouse(Ajudante ajudante){
        this.ajudante = ajudante;
        
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -3, 3, 0, 230));

    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        
    }
    
    private boolean mouseOver(int nx, int ny, int x, int y, int width, int height){
           if(nx > x && nx < x + width){
               if(ny > y && ny < y + height){
                   return true;
               }
               else{
                   return false;
               }
           }
           else{
               return false;
           }
    }
    
    
    
}
