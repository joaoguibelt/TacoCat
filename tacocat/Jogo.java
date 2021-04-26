package tacocat;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Jogo extends Canvas implements Runnable{
   
   //Altura e Largura da janela 
    public static final int W = 490;
    public static final int H = 600;
    
    private Thread thread;
    private boolean rodando = false;
    private Ajudante ajudante;
    private HUD hud;
    private Random r;
    //Construtor
    public Jogo(){
        ajudante = new Ajudante();
        r = new Random();
        this.addKeyListener(new Teclado(ajudante));
        Janela j = new Janela(W, H, "TacoCat", this);
        hud = new HUD();
        ajudante.addObjeto(new Player(0, H - 130));
        ajudante.addObjeto(new Tacocat(r.nextInt(230), r.nextInt(Jogo.H/2), -3, 3, 0, 230));
        ajudante.addObjeto(new Tacocat(r.nextInt(250)+245,r.nextInt(Jogo.H/2), -3, 3, 245, Jogo.W-10));
        ajudante.addObjeto(new Purrito(r.nextInt(Jogo.W),r.nextInt(Jogo.H/2), -15, 15));
    }
    
    //Começa o jogo
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        rodando = true;
    }
    //Pausa o jogo
     public synchronized void stop(){
        try {
            thread.join();
            rodando = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Gameloop
    @Override
    public void run() {
        this.requestFocus();
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
    //O que roda todo frame
    private void tick() {
        ajudante.tick();
        hud.tick();
    }
    //O que renderiza as imagens
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
        hud.render(g);
        g.dispose();
        bs.show();
    }  
    
    //NÃO ULTRAPASSAR A BORDA DO JOGO
    public static int limiteResolucao(int var, int min, int max){
       if(var >= max){
           return var = max;
       }else if(var <= min){
           return var = min;
       }else{
           return var;
       }
    }
}
