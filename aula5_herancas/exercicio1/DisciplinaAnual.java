public class DisciplinaAnual extends Disciplina{
    protected double nota3;
    protected double nota4;
    protected double nota5;
    protected double nota6;

    public void avaliacao(){
        double soma = (nota1+nota2+nota3+nota4+nota5)/5.0*0.6+(nota6*0.4);
        System.out.println("Sua média anual é: "+ soma);
    }

    public void setNota3(double n){
        nota3 = n;
    }
    public void setNota4(double n){
        nota4 = n;
    }
    public void setNota5(double n){
        nota5 = n;
    }
    public void setNota6(double n){
        nota6 = n;
    }

    public double getNota3(){
        return nota3;
    }
    public double getNota4(){
        return nota4;
    }
    public double getNota5(){
        return nota5;
    }
    public double getNota6(){
        return nota6;
    }
}