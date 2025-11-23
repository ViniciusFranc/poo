package Users;

import Accounts.ContaFinanceira;
import java.util.ArrayList;

public class Grupo extends Usuario{
    
    private ArrayList<ContaFinanceira> ContasUserGrupo = new ArrayList<>();


    public Grupo(int Id, String Nome,String Permissoes,String TipoPerfil,String contas){
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