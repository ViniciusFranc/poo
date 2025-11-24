package Users;

import Accounts.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioSolo extends Usuario{


    public UsuarioSolo (int Id, String Nome, String Permissoes, String TipoPerfil, ArrayList<ContaFinanceira> contas){
        super(Id, Nome, Permissoes, TipoPerfil, contas);
    }

    @Override
<<<<<<< Updated upstream
    protected void ConsultarSaldoAgregado() {
        
        double TotalSaldo = 0;
        for (ContaFinanceira conta : contas) {
            TotalSaldo += conta.getSaldo();
        }
        System.out.println("Saldo total de contas: "+TotalSaldo);
    }

@Override
    protected void AdicionarConta() {
=======
    public void ConsultarSaldoAgregado() {

                double TotalSaldo = 0;
                for (ContaFinanceira conta : contas) {
                    TotalSaldo += conta.getSaldo();
                }
                System.out.println("Saldo total de contas: "+TotalSaldo);

    }

@Override
    public void AdicionarConta() throws UsuarioSemPermissaoException,CategoriaNaoEncontradaException {
        try{

>>>>>>> Stashed changes
        System.out.println("""
                           Menu de Contas: 
                           1 - Conta Corrente.
                           2 - Conta Digital.
                           3 - Cofrinho.
                           4 - Cartao de Credito
                           5 - Carteira de Investimentos.
                           Digite o numero referente a conta que voce quer adicionar""");
        Scanner l = new Scanner(System.in);
        int TipoConta = l.nextInt();
        switch (TipoConta) {
            case 1 -> {
                System.out.println("Digite o Saldo inicial da Conta Corrente que esta adicionando: ");
                Scanner saldo1 = new Scanner(System.in);
                double ValorSaldo1 = saldo1.nextDouble();
                contas.add(new ContaCorrente(ValorSaldo1));
            }
            case 2 -> {
                System.out.println("Digite o Saldo inicial da Conta Digital que esta adicionando: ");
                Scanner saldo2 = new Scanner(System.in);
                double ValorSaldo2 = saldo2.nextDouble();
                contas.add(new ContaDigital(ValorSaldo2));
            }
            case 3 -> {                
                System.out.println("Digite o Saldo inicial do Cofrinho que esta adicionando: ");
                Scanner saldo3 = new Scanner(System.in);
                double ValorSaldo3 = saldo3.nextDouble();
                contas.add(new Cofrinho(ValorSaldo3));
            }
            case 4 -> {
                System.out.println("Digite o limite do Cartao de Credito que esta adicionando: ");
                Scanner saldo4 = new Scanner(System.in);
                double ValorSaldo4 = saldo4.nextDouble();
                contas.add(new CartaoCredito(ValorSaldo4));
            }
            case 5 -> {
                System.out.println("Digite o valor do portfolio da Carteira de Investimentos que esta adicionando: ");
                Scanner saldo5 = new Scanner(System.in);
                double ValorSaldo5 = saldo5.nextDouble();
                contas.add(new CarteiraInvestimentos(ValorSaldo5));
            }
            default -> throw new AssertionError();
        }

    }

    @Override
<<<<<<< Updated upstream
    protected void RemoverConta() {
=======
    public void RemoverConta() throws UsuarioSemPermissaoException,CategoriaNaoEncontradaException{
        try{
>>>>>>> Stashed changes
        System.out.println("""
                           Menu de Contas: 
                           1 - Conta Corrente.
                           2 - Conta Digital.
                           3 - Cofrinho.
                           4 - Cartao de Credito
                           5 - Carteira de Investimentos.
                           Digite o numero referente a conta que voce quer remover""");
        Scanner l = new Scanner(System.in);
        int TipoConta = l.nextInt();

        for (ContaFinanceira conta : contas){
            if (TipoConta == 1 && conta instanceof ContaCorrente) {
                contas.remove(conta);
            } else if (TipoConta == 2 && conta instanceof ContaDigital) {
                contas.remove(conta);
            } else if (TipoConta == 3 && conta instanceof Cofrinho) {
                contas.remove(conta);
            } else if (TipoConta == 4 && conta instanceof CartaoCredito) {
                contas.remove(conta);
            } else if (TipoConta == 5 && conta instanceof CarteiraInvestimentos) {
                contas.remove(conta);
            }
        }


    }

    @Override
    public void listarContas() {
        System.out.println(contas);
    }

}
