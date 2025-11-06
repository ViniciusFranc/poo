public class Natacao extends Atividade{

    protected int bracada;

    public Natacao(double distancia, int tempo, int bracada){
        super(distancia,tempo);
        this.bracada = bracada;
    }

    @Override
    public void Iniciar(){
        System.out.println("boa nadada? !!!!, distancia inicial: 0 -- contagem de braçadas: 0");
    }

    @Override
    public void Terminar(){
        System.out.println("Parabens por concluir a nadada? !!!!, distancia final: "+this.tempo+" -- numero de bracadas: "+ this.bracada);
    }


    @Override
    public void medirEsforco(){
        if (tempo < 10f && bracada < 10f) {
            System.out.println("esforço de nadar aumentando");
        }else{
            System.out.println("esforço de nadar diminuindo");
        }
    }

    public int getBracada() {
        return bracada;
    }

    public void setBracada(int bracada) {
        this.bracada = bracada;
    }
        public double getDistancia() {
        return distancia;
    }

    public int getTempo() {
        return tempo;
    }
}