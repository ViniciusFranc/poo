public class DisciplinaAnual extends Disciplina{
    protected double nota3;
    protected double nota4;
    protected double nota5;
    protected double nota6;

    public DisciplinaAnual (float nota1, float nota2, float nota3, float nota4, float nota5, float nota6){
        super(nota1, nota2);
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.nota5 = nota5;
        this.nota6 = nota6;
        avaliacao();
    }

    public void avaliacao(){
        media = (nota1+nota2+nota3+nota4+nota5)/5f*0.6f+(nota6*0.4f);
    }

    public void exibir() {
        super.exibir();

        System.err.println("Disciplina " + nome);
        System.err.println("nota1 " + nota1);
        System.err.println("nota2 " + nota2);
        System.err.println("nota3 " + nota3);
        System.err.println("nota4 " + nota4);
        System.err.println("nota5 " + nota5);
        System.err.println("nota6 " + nota6);
        System.err.println("media " + media);
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