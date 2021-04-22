package tacocat;

import java.awt.Graphics;

//Objetos do jogo
public abstract class GameObject {
    private int x;
    private int y; 
    // velx e vely são as velocidades horizontais e verticais respectivamente
    private int velx;
    private int vely;
    
    // x e y são a posição do objeto na janela
    GameObject(int x, int y){
        this.x = x;
        this.y = y;
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
}
