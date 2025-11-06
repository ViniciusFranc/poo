public abstract class Pessoa{
    protected String Nome;
    protected String Nascimento;
    protected String Falecimento;
    protected String Cep;
    protected Pessoa Pai;
    protected Pessoa Mae;

    public Pessoa (String Nome, String Nascimento, String Falecimento, String Cep, Pessoa Pai, Pessoa Mae) {
    this.Nome = Nome;
    this.Nascimento = Nascimento;
    this.Falecimento = Falecimento;
    this.Cep = Cep;
    this.Pai = Pai;
    this.Mae = Mae;
    }

    public abstract void Exibir(Pessoa p);
}