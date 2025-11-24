package Accounts;

public interface IInvestidor{
    public void CadastrarInvestimento(double valor, double rentabilidade, String dataPayback);
    public double RemoverInvestimento(String dataPayback);
}