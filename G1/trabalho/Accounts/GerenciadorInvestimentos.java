package Accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorInvestimentos implements IInvestidor{
    
    private int InvestCounter = 0;
    @SuppressWarnings("FieldMayBeFinal")
    private Map<String, Investimentos> investimentosMap = new HashMap<>();

    public void CadastrarInvestimento(double valor, double rentabilidade, String dataPayback) {

        String investMapKey = dataPayback+ "," + InvestCounter;


        Investimentos investimento = new Investimentos(valor, rentabilidade, dataPayback);

        investimentosMap.put(investMapKey, investimento);

        InvestCounter +=1;
    }

    public double RemoverInvestimento(String dataPayback){
        double valor = 0;
        ArrayList<String> removeInverst = new ArrayList<String>();
        System.out.println("Extrato das Datas de retorno de seus investimentos: ");

        for (String chave : investimentosMap.keySet()) {
            String[] Key = chave.split(",");
            if (dataPayback.equals(Key[0])) {
                System.out.println(chave + " " + investimentosMap.get(chave));
                valor += investimentosMap.get(chave).getValor();
                removeInverst.add(chave);
            }
        }
        for(int i=0; i < removeInverst.size(); i++){
            investimentosMap.remove(removeInverst.get(i));
        }
        System.out.println(investimentosMap);
        
        return valor;

    }
    
}