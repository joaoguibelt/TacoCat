package tacocat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

//HUD do jogo
public class HUD {
    
    private static int hp = 150;
    
    private int pontuacao = 0;
    private int level = 0;
    
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
             System.exit(1);
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
        
        g.setColor(Color.black);
        g.drawString("Pontução: "+ pontuacao, 200, 20);
        g.drawString("Level: "+ level, 215, 40);
        
        if((level == 6) || (level == 11)){
            g.setColor(Color.RED);
            Font speedup = new Font("arial", 1, 15);
            g.setFont(speedup);
            g.setColor(Color.MAGENTA);
            g.drawString("Speed up!!", 200, 100);
        }
        
    }


    public static int getHp() {
        return hp;
    }


    public static void setHp(int aHp) {
        hp = aHp;
    }
    
    
}
