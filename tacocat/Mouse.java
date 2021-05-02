package tacocat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import tacocat.Jogo.ESTADO;
import static tacocat.Jogo.H;

public class Mouse extends MouseAdapter{
    
    private Ajudante ajudante;
    private Jogo jogo;
    
    public Mouse(Ajudante ajudante, Jogo jogo){
        this.ajudante = ajudante;
        this.jogo = jogo;
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        int nx = e.getX();
        int ny = e.getY();
        GameObject objetoTemporario = null;
        //Mouse dentro do jogo
        
        
        
        
        if(jogo.estadoJogo == ESTADO.Jogo){
            //pegando o player
            for(int i = 0; i < ajudante.objetos.size(); i++){
                if(ajudante.objetos.get(i).getId() == ID.Player){
                    objetoTemporario = ajudante.objetos.get(i);
                }
            }
            //animação de bater
            objetoTemporario.setParado(false);
            //batendo nos inimigos
            for(int i = 0; i < ajudante.objetos.size(); i++){
                if(ajudante.objetos.get(i).getId() != ID.Player){
                    if(mouseOver(nx,ny,ajudante.objetos.get(i).getX(),ajudante.objetos.get(i).getY(),ajudante.objetos.get(i).getWidth(),ajudante.objetos.get(i).getHeight())){
                        if(ajudante.objetos.get(i).isDireita() == objetoTemporario.isDireita()){
                                ajudante.objetos.get(i).setVida(ajudante.objetos.get(i).getVida() - 1);
                            if(ajudante.objetos.get(i).getVida() == 0){
                                ajudante.removerObjeto(ajudante.objetos.get(i));
                                i--;
                            }
                        }
                    }
                }
            }
        }
        //Mouse dentro do menu
        else if(jogo.estadoJogo == ESTADO.Menu){
            //Do menu para o jogo
            if(mouseOver(nx, ny, 135, 150, 250, 64)){
                jogo.estadoJogo = ESTADO.Jogo;
                ajudante.addObjeto(new Player(0, H - 130));
                //ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -3, 3, 0, 230, 20, 20));
                //ajudante.addObjeto(new Tacocat(r.nextInt(250)+245,r.nextInt(Jogo.H/2), -3, 3, 245, Jogo.W-10, 20, 20));
                //ajudante.addObjeto(new Purrito(r.nextInt(Jogo.W),r.nextInt(Jogo.H/2), -15, 15,50,50));
            }
            //Ir para o help
            else if(mouseOver(nx, ny, 135, 350, 250, 64)){
                jogo.estadoJogo = ESTADO.Help;
            }
            //Botão de quit
            else if(mouseOver(nx, ny, 8, 525, 26, 40)){
                System.exit(1);
            }
            //Score
            else if(mouseOver(nx, ny, 115, 250, 250, 64)){
                jogo.estadoJogo = ESTADO.Score;
            }
        }
        //Mouse dentro do help
        else if(jogo.estadoJogo == ESTADO.Help){
            //Voltar para o menu
            if(mouseOver(nx, ny, 115, 450, 250, 64)){
                jogo.estadoJogo = ESTADO.Menu;
            }
        }
        else if(jogo.estadoJogo == ESTADO.GameOver){
            if(mouseOver(nx, ny, 115, 450, 250, 64)){
                jogo.estadoJogo = ESTADO.Menu;
            }
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        if(jogo.estadoJogo == ESTADO.Jogo){
            for(int i = 0; i < ajudante.objetos.size(); i++){
                if(ajudante.objetos.get(i).getId() == ID.Player){
                    ajudante.objetos.get(i).setParado(true);
                }
            }
        }
    }
    
    private boolean mouseOver(int nx, int ny, int x, int y, int width, int height){
           if(nx > x && nx < x + width){
               if(ny > y && ny < y + height){
                   return true;
               }
               else{
                   return false;
               }
           }
           else{
               return false;
           }
    }
    
    
    
}
