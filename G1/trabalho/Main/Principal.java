package Main;

import Accounts.*;
import Exceptions.*;
import Extratos.*;
import Users.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args)  throws  SaldoInsuficienteException {
        // Teste de Conta Corrente
        ContaCorrente cc = new ContaCorrente(500.0);
        cc.ConsultarSaldo();
        cc.EntradaValor(100);
        cc.ConsultarSaldo();
        cc.SaidaValor(200);
        cc.ConsultarSaldo();

        // Teste de Cofrinho
        Cofrinho cofrinho = new Cofrinho(200.0);
        cofrinho.ConsultarSaldo();
        cofrinho.EntradaValor(50.0);
        cofrinho.ConsultarSaldo();
        cofrinho.SaidaValor(60.0);
        cofrinho.ConsultarSaldo();

        // Teste de Carteira de Investimentos
        CarteiraInvestimentos carteira = new CarteiraInvestimentos(1000.0);
        carteira.ConsultarSaldo();
        carteira.CadastrarInvestimento(100, 0.07, "2025-12-01");
        carteira.CadastrarInvestimento(300, 0.12, "2026-05-10");
        carteira.ConsultarSaldo();
        carteira.RemoverInvestimento("2025-12-01");
        carteira.ConsultarSaldo();

        // Teste de Cartão de Crédito
        CartaoCredito cartao = new CartaoCredito(2000.0);
        cartao.ConsultarSaldo();
        cartao.SaidaValor(150);
        cartao.ConsultarSaldo();
        cartao.EntradaValor(150);
        cartao.ConsultarSaldo();

        // Teste de Usuário Solo
        ArrayList<ContaFinanceira> contasSolo = new ArrayList<>();
        contasSolo.add(cc);
        UsuarioSolo solo = new UsuarioSolo(1, "Carlos", "User", "Solo", contasSolo);
        solo.listarContas();
        solo.ConsultarSaldoAgregado();

        // Teste de Grupo
        ArrayList<ContaFinanceira> contasGrupo = new ArrayList<>();
        contasGrupo.add(cofrinho);
        contasGrupo.add(cartao);
        Grupo grupo = new Grupo(10, "Equipe", "ADM", "Grupo", contasGrupo);
        grupo.listarContas();
        grupo.ConsultarSaldoAgregado();
         Movimento mov = new Movimento();

        Lancamento l1 = new Lancamento(
                "Alimentacao",
                cc,                    // alguma ContaFinanceira já criada
                "Mercado X",
                "Carlos",
                "Supermercado",
                LocalDate.of(2025, 1, 10),
                150.0
        );

        Lancamento l2 = new Lancamento(
                "Transporte",
                cc,
                "Uber",
                "Carlos",
                "Corrida",
                LocalDate.of(2025, 1, 12),
                40.0
        );

        Lancamento l3 = new Lancamento(
                "Alimentacao",
                cc,
                "Restaurante Y",
                "Carlos",
                "Restaurante",
                LocalDate.of(2025, 2, 5),
                90.0
        );

        mov.AdicionarLancamento(l1);
        mov.AdicionarLancamento(l2);
        mov.AdicionarLancamento(l3);

        // Extrato por período
        System.out.println("=== Extrato 01/01/2025 a 31/01/2025 ===");
        ArrayList<Lancamento> periodo = mov.ExtratoPerido(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 31)
        );
        for (Lancamento lanc : periodo) {
            System.out.println(lanc.getData() + " - " +
                    lanc.getCategoria() + "/" + lanc.getSubcategoria() +
                    " - " + lanc.getValor());
        }

        // Extrato por categoria/subcategoria
        System.out.println("=== Extrato categoria Alimentacao / Supermercado ===");
        ArrayList<Lancamento> cat = mov.ExtratoCategoria("Alimentacao", "Supermercado");
        for (Lancamento lanc : cat) {
            System.out.println(lanc.getData() + " - " +
                    lanc.getCategoria() + "/" + lanc.getSubcategoria() +
                    " - " + lanc.getValor());
        }

        // Ranking de despesas (ordenado por valor desc)
        System.out.println("=== Ranking de despesas ===");
        ArrayList<Lancamento> ranking = mov.RankingDespesas();
        for (Lancamento lanc : ranking) {
            System.out.println(lanc.getValor() + " - " +
                    lanc.getCategoria() + "/" + lanc.getSubcategoria() +
                    " - " + lanc.getData());
        }
    }
}

