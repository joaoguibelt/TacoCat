package tacocat;

import static tacocat.HUD.getHp;
import static tacocat.HUD.setHp;


public class ExplosaoDosInimigos {
        
    Ajudante ajudante;
    HUD hud;
    
    public ExplosaoDosInimigos(Ajudante ajudante, HUD hud){
        this.ajudante = ajudante;
    }
    
    
    
    public void tick(){
        
        for(int i = 0; i < ajudante.objetos.size(); i++){
                if(ajudante.objetos.get(i).getId() == ID.Tacocat){
                    ajudante.objetos.get(i).setTimer(ajudante.objetos.get(i).getTimer() + 1);
                    if(ajudante.objetos.get(i).getTimer() >= 500){
                        ajudante.removerObjeto(ajudante.objetos.get(i));
                        i--;
                        setHp(getHp() - 15);
                    }
                }
                else if(ajudante.objetos.get(i).getId() == ID.Purrito){
                    ajudante.objetos.get(i).setTimer(ajudante.objetos.get(i).getTimer() + 1);
                    if(ajudante.objetos.get(i).getTimer() >= 1500){
                        ajudante.removerObjeto(ajudante.objetos.get(i));
                        i--;
                        setHp(getHp() - 30);
                    }
                }
            }
    }
    
    public void render(){
        
    }
       
}
