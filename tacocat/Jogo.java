package tacocat;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
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
    private CriarInimigos cria;
    private Menu menu;
    private ExplosaoDosInimigos explosao;
    //Janelas do jogo
    public enum ESTADO{
        Jogo,
        Help,
        GameOver,
        Menu
    };
    BufferedImage fundo;
    public ESTADO estadoJogo = ESTADO.Menu;
    
    //Construtor
    public Jogo(){
        
       
        
        ajudante = new Ajudante();
        menu = new Menu(this, ajudante);
        r = new Random();
        this.addKeyListener(new Teclado(ajudante));
        this.addMouseListener(new Mouse(ajudante, this));
        Janela j = new Janela(W, H, "TacoCat", this);
        hud = new HUD(this);
        cria = new CriarInimigos(ajudante,hud);

        explosao = new ExplosaoDosInimigos(ajudante, hud);

        
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
        if(estadoJogo == ESTADO.Jogo){
            hud.tick();
            cria.tick();
            explosao.tick();
        }
        else if(estadoJogo == ESTADO.Menu){
            menu.tick();
        }
    }
    //O que renderiza as imagens
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.gray);
        g.fillRect(0, 0, W, H);
        
        ajudante.render(g);
        
        if(estadoJogo == ESTADO.Jogo){
            hud.render(g);
        }
        else if(estadoJogo == ESTADO.Menu || estadoJogo == ESTADO.Help || estadoJogo == ESTADO.GameOver){
            menu.render(g);
        }
        
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
