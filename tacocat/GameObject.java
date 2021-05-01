package tacocat;

import java.awt.Graphics;

//Objetos do jogo
public abstract class GameObject {
    // x e y são a posição do objeto na janela
    private int x;
    private int y; 
    //Identidade do objeto
    private ID id;
    // velx e vely são as velocidades horizontais e verticais respectivamente
    private int velx;
    private int vely;
    // tamanho das hit boxes
    private int width;
    private int height;
    //vida dos inimigos
    private int vida;
    //lado que os objetos se encontram no jogo
    private boolean direita;
    //timer para os inimigos morrerem 
    private int timer;
    //Estado do player
    private boolean parado;  
    GameObject(int x, int y, ID id, boolean parado){
        this.x = x;
        this.y = y;
        this.id = id;
        this.direita = false;
        this.parado = parado;
    }
    // construtor para os inimigos
    GameObject(int x, int y, ID id, int velx, int vely, int width, int height, int vida, boolean direita){
        this.x = x;
        this.y = y;
        this.velx = velx;
        this.vely = vely;
        this.id = id;
        this.width = width;
        this.height = height;
        this.vida = vida;
        this.direita = direita;
        this.timer = 0;
    }
    
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
    public int getX() {
        return x;
    }

   
    public void setX(int x) {
        this.x = x;
    }

    
    public int getY() {
        return y;
    }

   
    public void setY(int y) {
        this.y = y;
    }

    
    public int getVelx() {
        return velx;
    }

  
    public void setVelx(int velx) {
        this.velx = velx;
    }

  
    public int getVely() {
        return vely;
    }

 
    public void setVely(int vely) {
        this.vely = vely;
    }


    public ID getId() {
        return id;
    }


    public void setId(ID id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public abstract void frenesi();
    

    public boolean isDireita() {
        return direita;
    }

 
    public void setDireita(boolean direita) {
        this.direita = direita;
    }


    public int getTimer() {
        return timer;
    }


    public void setTimer(int timer) {
        this.timer = timer;
    }


    public boolean isParado() {
        return parado;
    }


    public void setParado(boolean parado) {
        this.parado = parado;
    }
    
}
