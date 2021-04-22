package tacocat;

import java.awt.Canvas;
import javax.swing.JFrame;


public class Janela extends Canvas{
    //Esse daqui são as configurações da janela
    public Janela(int width, int height, String nome, Jogo jogo){
        JFrame frame = new JFrame(nome);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(width, height);        
        frame.add(jogo);
        frame.setResizable(false);
        jogo.start();
    }
}
