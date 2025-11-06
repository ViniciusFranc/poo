public class Corrida extends Atividade{

    protected double ritmo;
    protected double cadencia;

    public Corrida(double distancia, int tempo, double ritmo, double cadencia){
        super(distancia,tempo);
        this.ritmo = ritmo;
        this.cadencia = cadencia;
    }

    @Override
    public void Iniciar(){
        System.out.println("boa corrida !!!!, distancia inicial: 0 -- ritmo inicial: 0");
    }

    @Override
    public void Terminar(){
        System.out.println("Parabens por concluir a corrida !!!!, distancia Final: "+this.distancia+" -- ritmo Final: "+ this.ritmo);
    }


    @Override
    public void medirEsforco(){
        if (ritmo <= 10d) {
            System.out.println("esforço de corrida aumentando");
        }else{
            System.out.println("esforço de corrida diminuindo");
        }
    }

    public double getRitmo() {
        return ritmo;
    }

    public void setRitmo(double ritmo) {
        this.ritmo = ritmo;
    }

    public double getCadencia() {
        return cadencia;
    }

    public void setCadencia(double cadencia) {
        this.cadencia = cadencia;
    }

        public double getDistancia() {
        return distancia;
    }

    public int getTempo() {
        return tempo;
    }
}
