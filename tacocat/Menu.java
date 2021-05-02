package tacocat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
    private Janela janela;
    private int top1;
    private int top2;
    private int top3;
    private BufferedImage logo;
    private String pontuacao;
    private BufferedImage quitImagem;
    public Menu(Jogo jogo, Ajudante ajudante, Janela janela){
        this.jogo = jogo;
        this.ajudante = ajudante;
        this.janela = janela;
        
    }
    
    
    public void tick(){
        
    }
    
    
    public void render(Graphics g){

        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 40);
        Font fnt3 = new Font("arial", 1, 20);
        Font fnt4 = new Font("Segoe UI Black", 1, 40);
        Font fnt5 = new Font("arial", 1, 10);
        Font fnt6 = new Font("Segoe UI Black", 2, 15);
        Font fnt7 = new Font("Segoe UI Black", 2, 40);

        //Imagens do menu

        if(jogo.estadoJogo == ESTADO.Menu){

            File file = new File("");
            
            try {
                this.quitImagem = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\portaQuit.png"));
                this.logo = ImageIO.read(new File(file.getAbsoluteFile()+"\\src\\tacocat\\Sprites\\TacoLogo3.png"));
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
            
            g.setFont(fnt5);
   
            g.setColor(Color.black);
            g.drawImage(quitImagem, -10, 515,null);
            
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
            
            g.setFont(fnt2);
            g.setColor(Color.black);
            g.drawString("Sua pontuação:", 100, 250);
            
            g.setFont(fnt7);
            g.setColor(Color.black);
            g.drawString(pontuacao, 200, 300);
            
            g.setFont(fnt);
            g.drawString("Game Over", 105, 90);
             
        }else if(jogo.estadoJogo == ESTADO.Score){
            File file = new File("");
            top1 = 0;
            top2 = 0;
            top3 = 0;




            try{
                FileInputStream arquivo = new FileInputStream(file.getAbsoluteFile()+"\\src\\tacocat\\Files\\Score.txt");
                InputStreamReader input = new InputStreamReader(arquivo);
                BufferedReader  br = new BufferedReader(input);
                String scoreAtual;
                while( (scoreAtual = br.readLine()) != null){
                    if(Integer.parseInt(scoreAtual) > top1){
                        top2 = top1;
                        top1 = Integer.parseInt(scoreAtual);

                    }else if(Integer.parseInt(scoreAtual) > top2){
                        top3 = top2; 
                        top2 = Integer.parseInt(scoreAtual);
                    }else if(Integer.parseInt(scoreAtual) > top3){
                        top3 = Integer.parseInt(scoreAtual);
                    }
                }
                arquivo.close();

            }catch(IOException e){
            }
        
            g.setFont(fnt7);
            g.setColor(Color.black);
            g.drawString("MAIORES PONTUAÇÕES", 6, 55);
            g.drawString(Integer.toString(top1), 180, 200);
            g.drawString(Integer.toString(top2), 180, 250);
            g.drawString(Integer.toString(top3), 180, 300);
        }
    }
    
    public void mostrarPontuacao(int score){
        if(jogo.estadoJogo == ESTADO.GameOver){
            pontuacao = Integer.toString(score);
        }
    }
    
}
