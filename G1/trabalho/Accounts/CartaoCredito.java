package Accounts;

import java.util.HashMap;
import java.util.Map;

public class CartaoCredito extends ContaFinanceira{

    private int ComprasCounter = 0;
    private double limiteTotal;
    private Map<Integer, Double> PgtosPendentesMap = new HashMap<>();

  public CartaoCredito(double limiteTotal) {
        super(0);
        this.limiteTotal = limiteTotal;
    }

 @Override
    public void ConsultarSaldo() {
        System.out.println("Valor total Limite: " + limiteTotal);
    }
 
    @Override
    public void SaidaValor(double valor) {
        if (limiteTotal > valor){
            this.limiteTotal -= valor;
            PgtosPendentesMap.put(ComprasCounter, valor);
            ComprasCounter +=1;
        }else{
            System.out.println("limite insuficiente");
        }
    }

    @Override
    public void EntradaValor(double valor) {
        if (PgtosPendentesMap.containsValue(valor)){
            for (Integer chave : PgtosPendentesMap.keySet()){
                if (PgtosPendentesMap.get(chave) == valor){
                    PgtosPendentesMap.remove(chave);
                    this.limiteTotal += valor;
                }
            }
        }
    }
}