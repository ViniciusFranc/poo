public class Ciclismo extends Atividade{

    protected float velMed;
    protected float elevacao;

    public Ciclismo(double distancia, int tempo, float velMed, float elevacao){
        super(distancia,tempo);
        this.velMed = velMed;
        this.elevacao = elevacao;
    }

    @Override
    public void Iniciar(){
        System.out.println("boa pedalada !!!!, velocidade media inicial: 0 -- elevacao inicial: 0");
    }

    @Override
    public void Terminar(){
        System.out.println("Parabens por concluir a pedalada !!!!, velocidade media inicial: "+this.velMed+" -- elevacao inicial: "+ this.elevacao);
    }


    @Override
    public void medirEsforco(){
        if (velMed > 10f && elevacao > 10f) {
            System.out.println("esforço de pedalar aumentando");
        }else{
            System.out.println("esforço de pedalar diminuindo");
        }
    }

    public float getVelMed() {
        return velMed;
    }

    public void setVelMed(float velMed) {
        this.velMed = velMed;
    }

    public float getElevacao() {
        return elevacao;
    }

    public double getDistancia() {
        return distancia;
    }

    public int getTempo() {
        return tempo;
    }

    public void setElevacao(float elevacao) {
        this.elevacao = elevacao;
    }
}