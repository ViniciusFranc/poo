package Accounts;

import Exceptions.*;

public class CarteiraInvestimentos extends ContaFinanceira implements IInvestidor{

    @SuppressWarnings("FieldMayBeFinal")
    private GerenciadorInvestimentos gerenciador = new GerenciadorInvestimentos();

    public CarteiraInvestimentos(double SaldoInicial) {
        super(SaldoInicial);
    }

    @Override
    public void ConsultarSaldo() {
        System.out.println("Valor total do portfolio: " + Saldo);
    }


    @Override
    public void SaidaValor(double valor) throws SaldoInsuficienteException{
        if(Saldo > valor){
        this.Saldo -= valor;
    }


    @Override
    public void EntradaValor(double valor) {
        this.Saldo += valor;
    }


    @Override
    public double RemoverInvestimento(String dataPayback) {
        double valorSaida = gerenciador.RemoverInvestimento(dataPayback);
        this.SaidaValor(valorSaida);
        return valorSaida;

        }catch(SaldoInsuficienteException msg){
    
        }
        return 0d;

    }

    @Override
    public void CadastrarInvestimento(double valor, double rentabilidade, String dataPayback) {
        gerenciador.CadastrarInvestimento(valor, rentabilidade, dataPayback);
        this.EntradaValor(valor);
    }
                    
    
    public double getSaldo() {
        return Saldo;
    }

    

}

