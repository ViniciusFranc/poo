
import java.util.HashMap;
import java.util.Map;

public class CartaoCredito extends ContaFinanceira{

    private double limiteTotal;
    private Map<String, Double> PgtosPendentesMap = new HashMap<>();

  public CartaoCredito(double limiteTotal) {
        super(0);
        this.limiteTotal = limiteTotal;
    }

    @Override
    public void ConsultarSaldo(double valor) {
        System.out.println(limiteTotal);
    }
 
    @Override
    public void SaidaValor(double valor) {
        if (limiteTotal > valor){
        this.limiteTotal -= valor;
        // adicionar tracking no map ??? n sei ainda
        }else{
        System.out.println("limite insuficiente");
        }
    }

    @Override
    public void EntradaValor(double valor) {
        this.limiteTotal += valor;
        // adicionar funcionalidade de remover pagamento pendente do map.
    }
    
}