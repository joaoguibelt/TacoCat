package tacocat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import tacocat.Jogo.ESTADO;


public class Menu {
    
    private Jogo jogo;
    private Ajudante ajudante;
    
    public Menu(Jogo jogo, Ajudante ajudante){
        this.jogo = jogo;
        this.ajudante = ajudante;
    }
    
    
    public void tick(){
        
    }
    
    
    public void render(Graphics g){
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 40);
        Font fnt3 = new Font("arial", 1, 20);
        //Imagens do menu
        if(jogo.estadoJogo == ESTADO.Menu){
            g.setFont(fnt);
            g.setColor(Color.black);
            g.drawString("Menu", 175, 100);
        
            g.setFont(fnt2);
            g.drawString("Play", 185, 195);
            g.setColor(Color.black);
            g.drawRect(115, 150, 250, 64);
        
            g.drawString("Score", 185, 295);
            g.setColor(Color.black);
            g.drawRect(115, 250, 250, 64);
        
            g.drawString("Como Jogar", 130, 395);
            g.setColor(Color.black);
            g.drawRect(115, 350, 250, 64);
 
            g.drawString("Quit", 185, 495);
            g.setColor(Color.black);
            g.drawRect(115, 450, 250, 64);
        }
        //Imagens no help
        else if(jogo.estadoJogo == ESTADO.Help){            
            g.setFont(fnt2);
            g.setColor(Color.black);
            g.drawString("Voltar", 180, 495);
            g.drawRect(115, 450, 250, 64);
            
            g.setFont(fnt3);
            g.drawString("Use as teclas A e D para se mover de um lado ", 10, 95);
            g.drawString("para o outro. Para acertar os inimigos use o ", 10,115);
            g.drawString("mouse. O personagem precisa estar do mesmo ", 10,135);
            g.drawString("lado da tela do que o inimigo para acertá-lo. ", 10,155);
        }
        //Imagens do gameover e limpar a string de objetos
        else if(jogo.estadoJogo == ESTADO.GameOver){           
            for(int i = 0; i < ajudante.objetos.size(); i++){
                ajudante.removerObjeto(ajudante.objetos.get(i));
                i--;
            }
            
            g.setFont(fnt2);
            g.setColor(Color.black);
            g.drawString("Voltar", 180, 495);
            g.drawRect(115, 450, 250, 64);
            
            
            g.setFont(fnt);
            g.drawString("Game Over", 105, 90);
        }
    }
}
