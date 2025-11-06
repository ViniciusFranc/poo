public class Mae extends Pessoa{

    public Mae (String Nome, String Nascimento, String Falecimento, String Cep, Pessoa Pai, Pessoa Mae) {
    super(Nome,Nascimento,Falecimento,Cep,Pai,Mae);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getNascimento() {
        return Nascimento;
    }

    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getFalecimento() {
        return Falecimento;
    }

    public void setFalecimento(String Falecimento) {
        this.Falecimento = Falecimento;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public Pessoa getPai() {
        return Pai;
    }

    public void setPai(Pessoa Pai) {
        this.Pai = Pai;
    }

    public Pessoa getMae() {
        return Mae;
    }

    public void setMae(Pessoa Mae) {
        this.Mae = Mae;
    }
    public void Exibir(Pessoa p){
        System.out.println("nome: " +Nome+ " - nascimento: " + Nascimento + " - falecimento: " + Falecimento+" - Cep: "+Cep+ " - pai: " + Pai + " - mae: " +Mae);
    }
}