package tacocat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import tacocat.Jogo.ESTADO;


public class Menu {
    
    private Jogo jogo;
    private Ajudante ajudante;
    private BufferedImage logo;
    
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
        Font fnt4 = new Font("Segoe UI Black", 1, 40);
        Font fnt5 = new Font("Segoe UI Black", 2, 55);
        Font fnt6 = new Font("Segoe UI Black", 2, 15);

        //Imagens do menu

        if(jogo.estadoJogo == ESTADO.Menu){

            File file = new File("");
            try {
                this.logo = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\main\\java\\tacocat\\Sprites\\TacoLogo3.png"));
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.drawImage(logo, 170, 25, null);          
             
            g.setFont(fnt2);
            g.setColor(Color.black);
            g.drawString("Play", 200, 195);
            g.drawRect(115, 150, 250, 64);
        
            g.drawString("Score", 185, 295);
            g.setColor(Color.black);
            g.drawRect(115, 250, 250, 64);
        
            g.drawString("Como Jogar", 124, 395);
            g.setColor(Color.black);
            g.drawRect(115, 350, 250, 64);
 
            g.drawString("Quit", 200, 495);
            g.setColor(Color.black);
            g.drawRect(115, 450, 250, 64);
            
            g.setFont(fnt6);
            g.drawString("Developed by Tacool", 320, 560);
            g.setColor(Color.black);
            
            
        }
        //Imagens no help
        else if(jogo.estadoJogo == ESTADO.Help){            
            g.setFont(fnt2);
            g.setColor(Color.black);
            g.drawString("Voltar", 180, 495);
            g.drawRect(115, 450, 250, 64);
            g.setFont(fnt4);
            g.drawString("COMO JOGAR", 95, 55);
            
            g.setFont(fnt3);
            g.drawString("1- Para se mover: Utilize as teclas \"A\" e \"D\";", 10, 95);
            g.drawString("2- Para acertar os tacocats do lado direito da tela ", 10,130);
            g.drawString("é necessário estar no lado direito, utilizando do", 10,150);
            g.drawString("1º passo, o mesmo para o lado esquerdo da tela; ", 10,170);
            g.drawString("3- Para eliminar os inimigos clique sobre eles:", 10,200);
            g.drawString("→O tacocat é morre com 1 click, o purrito em 3.", 10,220);
            g.drawString("4- Caso demore para eliminar um inimigo, o ", 10,250);
            g.drawString("mesmo sumirá e causará dano a sua vida ", 10,270);
            g.setFont(fnt4);
            g.drawString("BOM JOGO!", 117,400);
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
