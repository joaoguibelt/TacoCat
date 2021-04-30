package tacocat;

import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
        
public class CriarInimigos {
    private Ajudante ajudante;
    private HUD hud;
    private int pontosTemp1 = 0;
    private int pontosTemp2 = 0;
    private int frenesiCont = 0;
    private Random r = new Random();

    public CriarInimigos(Ajudante ajudante, HUD hud) {
        this.ajudante = ajudante;
        this.hud = hud;
    }
    
    public void tick(){
        pontosTemp1 ++;
        pontosTemp2 ++;
        
        //Dificuldade 1
        if ((hud.getLevel()>= 0) && (hud.getLevel()<5)){
            
            
            if (pontosTemp1 >= 500){
            pontosTemp1 = 0;

            ajudante.addObjeto(new Purrito(r.nextInt(230),r.nextInt(Jogo.H/2), -2, 2, 50, 50, false));
            
            } 
        
            if (pontosTemp2 >= 200){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -1, 1, 0, 230, 30, 30, false));
                ajudante.addObjeto(new Tacocat(r.nextInt(250)+245,r.nextInt(Jogo.H/2), -1, 1, 245, Jogo.W-10, 30, 30, true));    
                hud.setLevel(hud.getLevel() + 1);
                pontosTemp2 = 0;   
            }    
        }
        
        //Dificuldade 2
        if ((hud.getLevel()>= 5) && (hud.getLevel()<10)){
            
            
            if (pontosTemp1 >= 500){
            pontosTemp1 = 0;
            ajudante.addObjeto(new Purrito(r.nextInt(250) + 245,r.nextInt(Jogo.H/2), -3, 3, 50, 50, true));
            
            } 

            if (pontosTemp2 >= 200){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -2, 2, 0, 230, 30, 30, false));
                ajudante.addObjeto(new Tacocat(r.nextInt(250)+245,r.nextInt(Jogo.H/2), -2, 2, 245, Jogo.W-10, 30, 30, true));    
                hud.setLevel(hud.getLevel() + 1);
                pontosTemp2 = 0;   
            }    
        }
        
        //Dificuldade 3
        if (hud.getLevel()>= 10){
            if (pontosTemp1 >= 500){
            pontosTemp1 = 0;
            ajudante.addObjeto(new Purrito(r.nextInt(Jogo.W),r.nextInt(Jogo.H/2), -4, 4, 50, 50));
            
            } 

            if (pontosTemp2 >= 200){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -3, 3, 0, 230, 30, 30));
                ajudante.addObjeto(new Tacocat(r.nextInt(250)+245,r.nextInt(Jogo.H/2), -3, 3, 245, Jogo.W-10, 30, 30));    
                hud.setLevel(hud.getLevel() + 1);
                pontosTemp2 = 0;   
            }
            
            
            
        }

    }
        
    
}   
