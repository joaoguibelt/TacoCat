package tacocat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter{
    
    private Ajudante ajudante;
    
    public Mouse(Ajudante ajudante){
        this.ajudante = ajudante;
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        int nx = e.getX();
        int ny = e.getY();
        
        for(int i = 0; i < ajudante.objetos.size(); i++){
            if(ajudante.objetos.get(i).getId() != ID.Player){
                if(mouseOver(nx,ny,ajudante.objetos.get(i).getX(),ajudante.objetos.get(i).getY(),ajudante.objetos.get(i).getWidth(),ajudante.objetos.get(i).getHeight())){
                    System.out.println("hit");
                    ajudante.objetos.get(i).setVida(ajudante.objetos.get(i).getVida() - 1);
                    if(ajudante.objetos.get(i).getVida() == 0){
                        ajudante.objetos.get(i).morrer();
                    }
                }
            }
        }

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
