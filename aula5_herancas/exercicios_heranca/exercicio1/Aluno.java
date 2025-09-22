public class Aluno extends Pessoa{
    protected String Matricula;

    public Aluno(String m, String n, int i){
        Matricula = m;
        Nome = n;
        Idade = i;
    }

    public String GetNome(){
        return Nome;
    }
    public String GetMatricula(){
        return Matricula;
    }
    public int Getidade(){
        return Idade;
    }

}