package tacocat;


public abstract class Inimigos extends GameObject {
    private int vida;
    private float velocidade;

    public Inimigos(int x, int y) {
        super(x, y, ID.Inimigo);
    }

    
}
