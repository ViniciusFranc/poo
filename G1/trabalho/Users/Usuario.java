package Users;

import Accounts.ContaFinanceira;
import java.util.ArrayList;

public abstract class Usuario{
    protected String Nome;
    protected int Id;
    protected ArrayList<ContaFinanceira> contas;
    protected String TipoPerfil;
    protected String Permissoes;

    public abstract void AdicionarConta()throws UsuarioSemPermissaoException,CategoriaNaoEncontradaException;
    public abstract void RemoverConta() throws UsuarioSemPermissaoException,CategoriaNaoEncontradaException;
    public abstract void listarContas();
    public abstract void ConsultarSaldoAgregado();

    public Usuario(int Id, String Nome, String Permissoes, String TipoPerfil, ArrayList<ContaFinanceira> contas) {
        this.Id = Id;
        this.Nome = Nome;
        this.Permissoes = Permissoes;
        this.TipoPerfil = TipoPerfil;
        this.contas = contas;
    }

<<<<<<< Updated upstream
    protected abstract void AdicionarConta();
    protected abstract void RemoverConta();
    protected abstract void listarContas();
    protected abstract void ConsultarSaldoAgregado();

=======
>>>>>>> Stashed changes
}