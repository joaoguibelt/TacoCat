package tacocat;


public abstract class Inimigos extends GameObject {
    private int vida;

    public Inimigos(int x, int y) {
        super(x, y, ID.Inimigo);
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
