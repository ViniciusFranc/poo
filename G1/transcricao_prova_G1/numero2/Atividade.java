public abstract class Atividade implements Esforco{

    protected double distancia;
    protected int tempo;

    public Atividade(double distancia, int tempo){
        this.distancia = distancia;
        this.tempo = tempo;
    }

    public abstract void Iniciar();
    public abstract void Terminar();


}