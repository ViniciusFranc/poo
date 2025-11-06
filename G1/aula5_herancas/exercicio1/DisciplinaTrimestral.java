public class DisciplinaTrimestral extends Disciplina{

    public DisciplinaTrimestral(float nota1, float nota2){
        super(nota1,nota2);
        avaliacao();
    } 

    public void avaliacao(){
        media = (nota1*0.4f)+(nota2*0.6f);
    }

    public void exibir(){
        super.exibir();

        System.out.println("Disciplina" + nome);
        System.out.println("Nota1" + nota1);
        System.out.println("Nota2" + nota2);
        System.out.println("Media" + media);
    }
}