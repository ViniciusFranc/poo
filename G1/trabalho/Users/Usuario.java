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

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public ArrayList<ContaFinanceira> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaFinanceira> contas) {
        this.contas = contas;
    }

    public String getTipoPerfil() {
        return TipoPerfil;
    }

    public void setTipoPerfil(String TipoPerfil) {
        this.TipoPerfil = TipoPerfil;
    }

    public String getPermissoes() {
        return Permissoes;
    }

    public void setPermissoes(String Permissoes) {
        this.Permissoes = Permissoes;
    }

}