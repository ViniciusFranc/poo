package Accounts;

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
<<<<<<< Updated upstream
    public void SaidaValor(double valor) {
=======
    public void SaidaValor(double valor) throws SaldoInsuficienteException{
        if(Saldo > valor){
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======

        }catch(SaldoInsuficienteException msg){
    
        }
        return 0d;

>>>>>>> Stashed changes
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

