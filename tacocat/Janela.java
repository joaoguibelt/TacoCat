package tacocat;

import java.awt.Canvas;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;


public class Janela extends Canvas{
    BufferedImage fundo;
    //Esse daqui são as configurações da janela
    public Janela(int width, int height, String nome, Jogo jogo){
        JFrame frame = new JFrame(nome);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< Updated upstream
=======
      

        frame.setSize(width, height);   
        frame.setResizable(false);
>>>>>>> Stashed changes
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(width, height);        
        frame.add(jogo);
<<<<<<< Updated upstream
        frame.setResizable(false);
        jogo.start();
=======
         
        jogo.start();        
       
>>>>>>> Stashed changes
    }
}
