package Main;
import Accounts.*;

public class Lancamentos {
    protected String Tipo;
    protected String Categoria;
    protected String Subcategoria;
    protected String Pagador;
    protected String Beneficiario;
    
    public static void main(String[] args) {
        ContaFinanceira invest = new CarteiraInvestimentos(0);

        CarteiraInvestimentos carteira = (CarteiraInvestimentos) invest;
        carteira.CadastrarInvestimento(10000.0d, 0.1, "hoje");
        invest.ConsultarSaldo();
        carteira.RemoverInvestimento("hoje");
        invest.ConsultarSaldo();





        ContaFinanceira credito = new CartaoCredito(10000d);
        credito.ConsultarSaldo();
        credito.SaidaValor(5000d);
        credito.ConsultarSaldo();
        credito.SaidaValor(2000d);
        credito.ConsultarSaldo();
        credito.EntradaValor(2000d);
        credito.ConsultarSaldo();
        credito.EntradaValor(5000d);
        credito.ConsultarSaldo();

    }
}