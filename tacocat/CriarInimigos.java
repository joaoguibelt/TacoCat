/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tacocat;

/**
 *
 * @author Guilherme
 */
import java.util.Random;

public class CriarInimigos {
    private Ajudante ajudante;
    private HUD hud;
    private int pontosTemp1 = 0;
    private int pontosTemp2 = 0;
    private Random r = new Random();

    public CriarInimigos(Ajudante ajudante, HUD hud) {
        this.ajudante = ajudante;
        this.hud = hud;
    }
    
    public void tick(){
        pontosTemp1 ++;
        pontosTemp2 ++;
        
        if (pontosTemp1 >= 100){
            pontosTemp1 = 0;
            ajudante.addObjeto(new Purrito(r.nextInt(Jogo.W),r.nextInt(Jogo.H/2), -15, 15));
            
            //if (hud.getLevel() == 2){
            //    ajudante.addObjeto(new Purrito(r.nextInt(Jogo.W),r.nextInt(Jogo.H/2), -15, 15));
            //}
        } 
        
        if (pontosTemp2 >= 200){
            hud.setLevel(hud.getLevel() + 1);
            ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -3, 3, 0, 230));
            ajudante.addObjeto(new Tacocat(r.nextInt(250)+245,r.nextInt(Jogo.H/2), -3, 3, 245, Jogo.W-10));    
            hud.setLevel(hud.getLevel() + 1);
            pontosTemp2 = 0;   
            }    
        }
        
    
}   
