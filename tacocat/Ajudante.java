
package tacocat;

import java.awt.Graphics;
import java.util.LinkedList;


public class Ajudante {
    
    LinkedList<GameObject> objetos = new LinkedList<>();
    
    public void tick(){
        for(int i = 0; i < objetos.size(); i++){
            GameObject objetoTemporario = objetos.get(i);
            
            objetoTemporario.tick();
        }
    }
    
    public void render(Graphics g){
       for(int i = 0; i < objetos.size(); i++){
            GameObject objetoTemporario = objetos.get(i);
            
            objetoTemporario.render(g);
        }
    }
    
    public void addObjeto(GameObject objeto){
        this.objetos.add(objeto);
    }
    
    public void removerObjeto(GameObject objeto){
        this.objetos.remove(objeto);
    }
}
