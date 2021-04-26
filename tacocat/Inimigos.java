package tacocat;


public abstract class Inimigos extends GameObject {
    private int vida;

    public Inimigos(int x, int y, int velx, int vely, ID id) {
        super(x, y, id, velx, vely);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public abstract void morrer();
    
    public abstract void frenesi();
    
}
