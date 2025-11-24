package Users;

import Accounts.ContaFinanceira;
import Exceptions.*;
import java.util.ArrayList;

public abstract class Usuario{
    protected String Nome;
    protected int Id;
    protected ArrayList<ContaFinanceira> contas;
    protected String TipoPerfil;
    protected String Permissoes;

    protected abstract void AdicionarConta()throws UsuarioSemPermissaoException,CategoriaNaoEncontradaException;
    protected abstract void RemoverConta() throws UsuarioSemPermissaoException,CategoriaNaoEncontradaException;
    protected abstract void listarContas();
    protected abstract void ConsultarSaldoAgregado();

    public Usuario(int Id, String Nome, String Permissoes, String TipoPerfil, ArrayList<ContaFinanceira> contas) {
        this.Id = Id;
        this.Nome = Nome;
        this.Permissoes = Permissoes;
        this.TipoPerfil = TipoPerfil;
        this.contas = contas;
    }

}