package Main;

import Accounts.*;
import Exceptions.*;
import Extratos.*;
import Users.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainTeste {

    public static void main(String[] args) {
        try {
            // 1) Monta sistema básico em memória
            SistemaFinanceiro sis = SistemaFinanceiro.getInstancia();
            Movimento movimento = sis.getMovimento();
            ArrayList<Usuario> usuarios = sis.getUsuarios();

            // 2) Cria usuario individual com uma conta corrente
            ArrayList<ContaFinanceira> contasJoao = new ArrayList<>();
            ContaCorrente ccJoao = new ContaCorrente(1000.0);
            contasJoao.add(ccJoao);
            UsuarioSolo joao = new UsuarioSolo(1, "Joao", "ADM", "Solo", contasJoao);
            usuarios.add(joao);

            // 3) Cria grupo com Cofrinho compartilhado
            ArrayList<ContaFinanceira> contasGrupo = new ArrayList<>();
            Cofrinho cofreGrupo = new Cofrinho(500.0);
            contasGrupo.add(cofreGrupo);
            Map<String, Double> membros = new HashMap<>();
            membros.put("Joao", 1.0);
            membros.put("Maria", 1.0);
            Grupo grupo = new Grupo(2, "Republica X", "ADM", "Grupo", contasGrupo, membros);
            usuarios.add(grupo);

            // 4) Lançamentos de teste para Joao
            // Receita
            Lancamento salJoao = new Lancamento(
                    "Salario",
                    ccJoao,
                    "Empresa Y",
                    joao,
                    "Mensal",
                    LocalDate.now().minusDays(10),
                    3000.0,
                    "Receita",
                    joao.getTipoPerfil()
            );
            ccJoao.EntradaValor(3000.0);
            movimento.AdicionarLancamento(salJoao);

            // Despesa
            Lancamento mercadoJoao = new Lancamento(
                    "Mercado",
                    ccJoao,
                    "Supermercado Z",
                    joao,
                    "Comida",
                    LocalDate.now().minusDays(5),
                    800.0,
                    "Despesa",
                    joao.getTipoPerfil()
            );
            ccJoao.SaidaValor(800.0);
            movimento.AdicionarLancamento(mercadoJoao);

            // 5) Lançamento de despesa compartilhada no grupo (rateio)
            Lancamento luzGrupo = new Lancamento(
                    "Contas",
                    cofreGrupo,
                    "Companhia de Luz",
                    grupo,
                    "Energia",
                    LocalDate.now().minusDays(3),
                    200.0,
                    "Despesa",
                    grupo.getTipoPerfil()
            );
            cofreGrupo.SaidaValor(200.0);
            movimento.AdicionarLancamento(luzGrupo);

            // 6) Testa ProjecaoSaldo
            LocalDate d1 = LocalDate.now().minusDays(30);
            LocalDate d2 = LocalDate.now();
            double proj = movimento.ProjecaoSaldo(d1, d2);
            System.out.println(">> Projecao de saldo no periodo (" + d1 + " a " + d2 + "): " + proj);

            // 7) Testa RankingDespesas
            System.out.println("\n>> Ranking de despesas:");
            for (Lancamento l : movimento.RankingDespesas()) {
                System.out.println(l.getValor() + " - " + l.getCategoria() + "/" + l.getSubcategoria());
            }

            // 8) Testa SugereEconomia
            System.out.println("\n>> Sugestao de economia por categoria:");
            movimento.SugereEconomia();

            // 9) Testa meta simples
            MetaOrcamento metaMercado = new MetaOrcamento("Mercado", 500.0, LocalDate.now().plusDays(10));
            double soma = 0.0;
            for (Lancamento l : movimento.ExtratoPerido(d1, metaMercado.getDataLimite())) {
                if (l.getCategoria().equalsIgnoreCase(metaMercado.getCategoria())
                        && l.getTipo().equalsIgnoreCase("Despesa")) {
                    soma += l.getValor();
                }
            }
            System.out.println("\n>> Meta categoria " + metaMercado.getCategoria()
                    + " | Limite: " + metaMercado.getValorMeta()
                    + " | Gasto: " + soma);
            if (soma > metaMercado.getValorMeta()) {
                System.out.println("ALERTA TESTE: Meta estourada para categoria " + metaMercado.getCategoria());
            } else {
                System.out.println("Meta ainda dentro do limite.");
            }

        } catch (SaldoInsuficienteException e) {
            System.out.println("Teste falhou por saldo insuficiente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado em MainTeste: " + e.getMessage());
        }
    }
}
