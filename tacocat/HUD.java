package tacocat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import tacocat.Jogo.ESTADO;

//HUD do jogo
public class HUD {
    
    Jogo jogo;
    
    
    public HUD(Jogo jogo){
        this.jogo = jogo;
    }
    
    
    private static int hp = 150;
    
    private int pontuacao = 0;
    private int level = 0;
    private boolean contFrenesi = false;

    public boolean getContFrenesi() {
        return contFrenesi;
    }

    public void setContFrenesi(boolean contFrenesi) {
        this.contFrenesi = contFrenesi;
    }

    

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    
    
    
    public void tick(){
         pontuacao ++;
         
         if(hp <= 0){
             jogo.estadoJogo = ESTADO.GameOver;
             GravarScore score = new GravarScore(this.pontuacao);
             hp = 150;
             level = 0;
             pontuacao = 0;
         }
    }


    public void render(Graphics g){
        //Barra de vida
        g.setColor(Color.gray);
        g.fillRect(170, 550, 150, 16);
        g.setColor(Color.green);

        g.fillRect(170, 550, hp, 16);
        g.setColor(Color.white);
        g.drawRect(170, 550, 150, 16);

        
        Font fonteHud = new Font("Segoe UI Black", 5, 15);
        g.setColor(Color.black);
        g.setFont(fonteHud);
        g.drawString("Pontução: "+ pontuacao, 188, 20);
        g.drawString("Level: "+ level, 210, 40);
        
        Font dificuldade = new Font("Segoe UI Black", 5, 18);
        g.setFont(dificuldade);
        g.setColor(Color.white);
        
        if((level >= 0) && (level < 5)){ 
            g.drawString("+ Easy +", 200, 65);
        }
        else if((level >= 5) && (level < 10)){
            g.drawString("++ Medium ++", 170, 65);  
        }
        else if((level >= 10) && (level < 15)){
            g.drawString("+++ Hard +++", 175, 65);
        }
        else if((level >= 15) && (level < 20)){
            g.drawString("++++ Severe ++++", 160, 65);
        }
        else if(level >= 20){
            g.drawString("+++++ Impossible +++++", 130, 65);
        }      
        
        
        
        if(contFrenesi == true){
            
            g.setColor(Color.BLUE);
            Font modoFrenesi = new Font("Segoe UI Black",5, 20);
            g.setFont(modoFrenesi);
            g.drawString("Modo frenesi!", 170, 120);
        }
        
    }
  public static int getHp() {
        return hp;
    }


    public static void setHp(int aHp) {
        hp = aHp;
    }


}
  