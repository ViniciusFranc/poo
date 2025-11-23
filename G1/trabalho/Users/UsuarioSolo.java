package Users;

import Accounts.ContaFinanceira;
import java.util.ArrayList;

public class UsuarioSolo extends Usuario{

    private ArrayList<ContaFinanceira> ContasUserIndividual = new ArrayList<>();

    public UsuarioSolo (int Id, String Nome, String Permissoes, String TipoPerfil, String contas){
        super(Id, Nome, Permissoes, TipoPerfil, contas);
    }

    @Override
    protected void ConsultarSaldoAgregado() {
    }

    @Override
    protected void AdicionarConta() {
    }

    @Override
    protected void RemoverConta() {
    }

    @Override
    protected void listarContas() {
    }

}
