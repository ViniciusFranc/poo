
import java.util.HashMap;
import java.util.Map;

public class CartaoCredito extends ContaFinanceira{

    private double limiteTotal;
    private Map<String, Double> PagamentosPendentes = new HashMap<>();

  public CartaoCredito(double limiteTotal) {
        super(0);
        this.limiteTotal = limiteTotal;
    }

    @Override
    protected void ConsultarSaldo(double valor) {
        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
        System.out.println("Saldo insuficiente");
        }
    }

    @Override
    protected void SaidaValor(double valor) {
        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
        System.out.println("Saldo insuficiente");
        }
    }

    @Override
    protected void EntradaValor(double valor) {
        this.Saldo += valor;
    }
    
}