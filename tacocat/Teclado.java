package tacocat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Classe que vee as entradas do teclado
public class Teclado extends KeyAdapter{
    
    private Ajudante ajudante;
    
    public Teclado(Ajudante ajudante){
        this.ajudante = ajudante;
    }
    
    
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        //Movimento para os lados do player
        for(int i = 0; i < ajudante.objetos.size(); i++){
            GameObject objetoTemporario = ajudante.objetos.get(i);
            if(objetoTemporario.getId() == ID.Player){
                if(key == KeyEvent.VK_D){
                    objetoTemporario.setX(480 - 106);
                    ajudante.objetos.get(i).setDireita(true);
                }
                else if(key == KeyEvent.VK_A){
                    objetoTemporario.setX(0);
                    ajudante.objetos.get(i).setDireita(false);
                }
            }
        }
    }
       
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
    }
}
