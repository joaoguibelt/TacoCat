package tacocat;

import java.util.Random;
        
public class CriarInimigos {
    private Ajudante ajudante;
    private HUD hud;
    private int pontosTemp1 = 0;
    private int pontosTemp2 = 0;
    private int pontosTemp3 = 0;
    private int pontosFrenesi = 0;
    
    private Random r = new Random();

    public CriarInimigos(Ajudante ajudante, HUD hud) {
        this.ajudante = ajudante;
        this.hud = hud;
    }
    
    public void tick(){
        pontosTemp1 ++;
        pontosTemp2 ++;
        pontosTemp3 ++;
        pontosFrenesi ++;
        
        //Modo Frenesi(velocidade dos inimigos aumentada)
        if ((pontosFrenesi >= 300) && (pontosFrenesi <= 400)){
            hud.setContFrenesi(true);
            for(int i = 0; i < ajudante.objetos.size(); i++){
                ajudante.objetos.get(i).frenesi();
            }
            
        }
        if (pontosFrenesi > 400){
            pontosFrenesi = 0;
            hud.setContFrenesi(false);
        }
        
        
        //Dificuldade 1
        if ((hud.getLevel()>= 0) && (hud.getLevel()<5)){
            
            if (pontosTemp1 >= 500){
                pontosTemp1 = 0;
                ajudante.addObjeto(new Purrito(r.nextInt(230),r.nextInt(Jogo.H/2), -2, 2, 50, 50, false));
            } 
        
            if (pontosTemp2 >= 200){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -1, 1, 0, 230, 30, 30, false));
                ajudante.addObjeto(new Tacocat(r.nextInt(250)+195,r.nextInt(Jogo.H/2), -1, 1, 245, Jogo.W-30, 30, 30, true));    
                hud.setLevel(hud.getLevel() + 1);
                pontosTemp2 = 0;   
            }
            
            if (pontosTemp3 == 1){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -1, 1, 0, 230, 30, 30, false));
                ajudante.addObjeto(new Tacocat(r.nextInt(250)+195,r.nextInt(Jogo.H/2), -1, 1, 245, Jogo.W-30, 30, 30, true));        
            }
            
        }
        
        //Dificuldade 2
        if ((hud.getLevel()>= 5) && (hud.getLevel()<10)){

            if (pontosTemp1 >= 500){

                pontosTemp1 = 0;
                ajudante.addObjeto(new Purrito(r.nextInt(195) + 250,r.nextInt(Jogo.H/2), -3, 3, 50, 50, true));

            } 

            if (pontosTemp2 >= 200){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -2, 2, 0, 230, 30, 30, false));
                ajudante.addObjeto(new Tacocat(r.nextInt(195)+250,r.nextInt(Jogo.H/2), -2, 2, 245, Jogo.W-33, 30, 30, true));    
                hud.setLevel(hud.getLevel() + 1);
                pontosTemp2 = 0;   
            }  

        }
        
        //Dificuldade 3

        if ((hud.getLevel()>= 10) && (hud.getLevel()<15)){

            
            if (pontosTemp1 >= 500){
                pontosTemp1 = 0;
                ajudante.addObjeto(new Purrito(r.nextInt(230),r.nextInt(Jogo.H/2), -4, 4, 50, 50,false)); 
            } 

            if (pontosTemp2 >= 200){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -3, 3, 0, 230, 30, 30,false));
                ajudante.addObjeto(new Tacocat(r.nextInt(195)+250,r.nextInt(Jogo.H/2), -3, 3, 245, Jogo.W-33, 30, 30,true));    
                hud.setLevel(hud.getLevel() + 1);
                pontosTemp2 = 0;   
            }
            
        }    
        
        //Dificuldade 4   
        if ((hud.getLevel()>= 15) && (hud.getLevel()<20)){
            
            if (pontosTemp1 >= 500){
                pontosTemp1 = 0;
                ajudante.addObjeto(new Purrito(r.nextInt(230),r.nextInt(Jogo.H/2), -5, 5, 50, 50,false));
            } 

            if (pontosTemp2 >= 200){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -4, 4, 0, 230, 30, 30,false));
                ajudante.addObjeto(new Tacocat(r.nextInt(195)+250,r.nextInt(Jogo.H/2), -4, 4, 245, Jogo.W-33, 30, 30,true));    
                hud.setLevel(hud.getLevel() + 1);
                pontosTemp2 = 0;   
            }   
                           
        }
        
        //Dificuldade5(maxima)
        if (hud.getLevel()>= 20){
            
            if (pontosTemp1 >= 500){
                pontosTemp1 = 0;
                ajudante.addObjeto(new Purrito(r.nextInt(230),r.nextInt(Jogo.H/2), -6, 6, 50, 50,false));
            } 

            if (pontosTemp2 >= 200){
                ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -5, 5, 0, 230, 30, 30,false));
                ajudante.addObjeto(new Tacocat(r.nextInt(195)+250,r.nextInt(Jogo.H/2), -5, 5, 245, Jogo.W-33, 30, 30,true));    
                hud.setLevel(hud.getLevel() + 1);
                pontosTemp2 = 0;   
            } 
           
            
                 
        }
    }     
}   
