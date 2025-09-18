public class Disciplina{
    protected String nome;
    protected String periodo;
    protected double nota1;
    protected double nota2;

    public void setNota1(double n){
        nota1 = n;
    }
    public double getNota1(){
        return nota1;
    }

    public void setNota2(double n){
        nota1 = n;
    }
    public double getNota2(){
        return nota1;
    }

    public void avaliacao(){
        System.out.println("Disciplina sem calculo");
    }
}