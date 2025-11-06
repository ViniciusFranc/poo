
public class Caneta{
    private String cor;
    private double especura;

    public Caneta(String cor, double especura){
        this.cor = cor;
        this.especura = especura;
        }

    public void escrever(String texto){
        System.out.println("[" + cor + "]" + " -> " + texto);
    }
    
    public String getCor(){
        return cor;
    }

    public double getEspecura(){
        return especura;
    }

    public void setCor(String cor){
        this.cor=cor;
    }

    public void setEspecura(double especura){
        this.especura = especura;
    }
}