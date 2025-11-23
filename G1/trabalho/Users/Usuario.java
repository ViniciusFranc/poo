package Users;

public abstract class Usuario{
    protected String Nome;
    protected int Id;
    protected String contas;
    protected String TipoPerfil;
    protected String Permissoes;

    public Usuario(int Id, String Nome, String Permissoes, String TipoPerfil, String contas) {
        this.Id = Id;
        this.Nome = Nome;
        this.Permissoes = Permissoes;
        this.TipoPerfil = TipoPerfil;
        this.contas = contas;
    }

    protected abstract void AdicionarConta();
    protected abstract void RemoverConta();
    protected abstract void listarContas();
    protected abstract void ConsultarSaldoAgregado();

}