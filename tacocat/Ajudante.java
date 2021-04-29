package tacocat;

import java.awt.Graphics;
import java.util.LinkedList;


public class Ajudante {
    // Essa classe organiza os objetos e faz as coisas acontecerem com eles
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
    //adiciona objetos da lista
    public void addObjeto(GameObject objeto){
        this.objetos.add(objeto);
    }
    //remove objetos da lista
    public void removerObjeto(GameObject objeto){
        this.objetos.remove(objeto);
    }
}
