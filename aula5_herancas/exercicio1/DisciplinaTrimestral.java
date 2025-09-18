public class DisciplinaTrimestral extends Disciplina{
    public void avaliacao(){
        double soma = (nota1*0.4)+(nota2*0.6);
        System.out.println("Sua média trimestral é: " + soma);
    }
}