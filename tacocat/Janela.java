package tacocat;

import java.awt.Canvas;
import javax.swing.JFrame;

public class Janela extends Canvas{
       JFrame frame;

    //Esse daqui são as configurações da janela
    public Janela(int width, int height, String nome, Jogo jogo){
        frame = new JFrame(nome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setSize(width, height);   

        frame.setSize(width, height);   
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(jogo);
        frame.setResizable(false);
        jogo.start();        

    }
}
