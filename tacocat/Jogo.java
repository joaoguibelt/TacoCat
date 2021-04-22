
package tacocat;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Jogo extends Canvas implements Runnable{
   
    
    public static final int W = 490;
    public static final int H = 600;
    
    private Thread thread;
    private boolean rodando = false;
    private Ajudante ajudante;
    
    private Random r;
    
    public Jogo(){
        Janela j = new Janela(W, H, "TacoCat", this);
        
        ajudante = new Ajudante();
        
        for(int i = 0; i < 50; i++){
            r = new Random(); 
            ajudante.addObjeto(new Player(1, 1));
        }
        
       
    }
    
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        rodando = true;
    }
    
     public synchronized void stop(){
        try {
            thread.join();
            rodando = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(rodando){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(rodando){
                render();
            }
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        ajudante.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.orange);
        g.fillRect(0, 0, W, H);
        
        ajudante.render(g);
        
        g.dispose();
        bs.show();
    }             
}
