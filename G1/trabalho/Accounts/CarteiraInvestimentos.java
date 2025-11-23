package Accounts;

import java.util.HashMap;
import java.util.Map;

public class CarteiraInvestimentos extends ContaFinanceira{

    private int InvestCounter = 0;
    private Map<String, Investimentos> investimentosMap = new HashMap<>();


    public CarteiraInvestimentos(double SaldoInicial) {
        super(SaldoInicial);
    }
    

    @Override
    public void ConsultarSaldo() {
        System.out.println("Valor total do portfolio: " + Saldo);
    }


    @Override
    public void SaidaValor(double valor) {
        this.Saldo -= valor;
    }


    @Override
    public void EntradaValor(double valor) {
        this.Saldo += valor;
    }

    public void CadastrarInvestimento(double valor, double rentabilidade, String dataPayback) {

        String investMapKey = dataPayback+ "," + InvestCounter;

        EntradaValor(valor);

        Investimentos investimento = new Investimentos(valor, rentabilidade, dataPayback);

        investimentosMap.put(investMapKey, investimento);

        InvestCounter +=1;
    }

    public void RemoverInvestimento(String dataPayback){

        System.out.println("Extrato das Datas de retorno de seus investimentos: ");

        for (String chave : investimentosMap.keySet()) {
            String[] Key = chave.split(",");
            if ("hoje".equals(Key[0])) {
                System.out.println(chave + " " + investimentosMap.get(chave));
                SaidaValor(investimentosMap.get(chave).getValor());
                investimentosMap.remove(chave);
            }
        }
        System.out.println(investimentosMap);
        
    }
    
}