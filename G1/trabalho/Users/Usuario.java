package Users;

import Accounts.ContaFinanceira;
import java.util.ArrayList;

public abstract class Usuario{
    protected String Nome;
    protected int Id;
    protected ArrayList<ContaFinanceira> contas;
    protected String TipoPerfil;
    protected String Permissoes;

    public Usuario(int Id, String Nome, String Permissoes, String TipoPerfil, ArrayList<ContaFinanceira> contas) {
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