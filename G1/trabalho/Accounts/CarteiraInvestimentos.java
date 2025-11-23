
import java.util.HashMap;
import java.util.Map;

public class CarteiraInvestimentos extends ContaFinanceira{
    
    private Map<String, Investimentos> investimentosMap = new HashMap<String,Investimentos>();


    public CarteiraInvestimentos(double SaldoInicial) {
        super(SaldoInicial);
    }
    

    @Override
    public void ConsultarSaldo(double valor) {
        System.out.println("Valor total do portfolio: " + Saldo);
    }


    @Override
    public void SaidaValor(double valor) {
        if (Saldo > valor){
        this.Saldo -= valor;
        // adicionar tracking no map
        // possivel saida de resgate invest e entrada direta em conta corrente/digital
        }
    }


    @Override
    public void EntradaValor(double valor) {
        this.Saldo += valor;
    // adicionar tracking no map
    }

    public void CadastrarInvestimento(double valor, double rentabilidade) {
        EntradaValor(valor);
        Investimentos investimento = new Investimentos(valor, rentabilidade);
        // adicionar uma chave : objeto no Map.
    }
    
}