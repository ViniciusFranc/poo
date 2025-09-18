public class DisciplinaSemestral extends Disciplina{
    protected double nota3;

    public void avaliacao(){
        double soma = (nota1+nota2+nota3)/3;
        System.out.printf("Sua média semestral é:  %.2f %n", soma );
    }

    public void setNota3(double n){
        nota3 = n;
    }

    public double getNota3(){
        return nota3;
    }
}