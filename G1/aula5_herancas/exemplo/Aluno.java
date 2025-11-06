public class Aluno extends Pessoa{
    private String ra;
    private float valorPagar;
    private String curso; 

    public void almaNome(){
        System.out.println(ESO+" "+nome);
    }

    public static void main (String args []){
        Aluno aluno = new Aluno();
        aluno.almaNome();
    }

}