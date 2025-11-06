public class DisciplinaSemestral extends Disciplina{
    protected double nota3;

    public DisciplinaSemestral(float nota1, float nota2, float nota3){
        super(nota1, nota2);
        this.nota3 = nota3;
        avaliacao();
    }

    public void avaliacao(){
        media = (nota1+nota2+nota3)/3;
    }

    public void exibir(){
        super.exibir();

        System.err.println("Disciplina " + nome);
        System.err.println("nota1 " + nota1);
        System.err.println("nota2 " + nota2);
        System.err.println("nota3 " + nota3);
        System.err.println("media " + media);
    }

    public void setNota3(double n){
        nota3 = n;
    }

    public double getNota3(){
        return nota3;
    }
}