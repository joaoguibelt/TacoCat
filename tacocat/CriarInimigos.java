package tacocat;

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
        
        if (pontosTemp1 >= 2000){
            pontosTemp1 = 0;
            ajudante.addObjeto(new Purrito(r.nextInt(230),r.nextInt(Jogo.H/2), -15, 15, 50, 50, false));
            
            if (hud.getLevel() == 2){
                ajudante.addObjeto(new Purrito(r.nextInt(250) + 245,r.nextInt(Jogo.H/2), -15, 15, 50, 50, true));
            }
        } 
        
        if (pontosTemp2 >= 1000){
            hud.setLevel(hud.getLevel() + 1);
            ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -3, 3, 0, 230, 20, 20, false));
            ajudante.addObjeto(new Tacocat(r.nextInt(250)+245,r.nextInt(Jogo.H/2), -3, 3, 245, Jogo.W-10, 20, 20, true));    
            hud.setLevel(hud.getLevel() + 1);
            pontosTemp2 = 0;   
            }    
        }
        
    
}   
