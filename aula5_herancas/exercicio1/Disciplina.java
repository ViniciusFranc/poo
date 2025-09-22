public abstract  class Disciplina{
    protected String nome;
    protected String periodo;
    protected double nota1;
    protected double nota2;
    protected double media;

    public Disciplina(float nota1, float nota2){
        this.nota1=nota1;
        this.nota2=nota2;
    }

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

    public abstract void avaliacao();

    public void exibir(){
        System.out.println("exibir classe disciplina!!"
        );
    }
}