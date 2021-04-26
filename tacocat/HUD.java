package tacocat;

import java.awt.Color;
import java.awt.Graphics;

//HUD do jogo
public class HUD {
    
    public static int hp = 150;
    
    private int pontuacao = 0;
    private int level = 1;
    
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
    }


    public void render(Graphics g){
        //Barra de vida
        g.setColor(Color.gray);
        g.fillRect(0, 0, 16, 150);
        g.setColor(Color.green);
        g.fillRect(0, 0, 16, hp);
        g.setColor(Color.white);
        g.drawRect(0, 0, 16, 150);
        
        g.setColor(Color.black);
        g.drawString("Pontução: "+ pontuacao, 200, 20);
        g.drawString("Level: "+ level, 215, 40);
    }
    
    
}
