package Main;

import Accounts.*;
import Exceptions.*;
import Extratos.*;
import Users.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    private static ArrayList<MetaOrcamento> metas = new ArrayList<>();

    public static void main(String[] args) {
        SistemaFinanceiro.getInstancia().executar();
    }

    // =========================================================
    // MENU PRINCIPAL
    // =========================================================
    public static void menuPrincipal(Scanner sc, SistemaFinanceiro sis) {

        boolean executando = true;

        while (executando) {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Cadastro de usuarios");
            System.out.println("2 - Inserir lancamento");
            System.out.println("3 - Relatorios");
            System.out.println("4 - Metas e simulacoes (versao simples)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = Integer.parseInt(sc.nextLine());

            try {
                switch (opcao) {
                    case 1:
                        menuCadastroUsuarios(sc, sis);
                        break;
                    case 2:
                        menuInserirLancamento(sc, sis);
                        break;
                    case 3:
                        menuRelatorios(sc, sis);
                        break;
                    case 4:
                        menuMetasSimulacoes(sc, sis);
                        break;
                    case 0:
                        executando = false;
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Encerrando sistema...");
    }

    // =========================================================
    // 1) CADASTRO DE USUARIOS
    // =========================================================
    private static void menuCadastroUsuarios(Scanner sc, SistemaFinanceiro sis) {
        System.out.println("\n--- Cadastro de Usuarios ---");
        System.out.println("1 - Usuario individual");
        System.out.println("2 - Grupo");
        System.out.print("Escolha: ");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Permissoes (ADM/User): ");
        String permissoes = sc.nextLine();

        ArrayList<ContaFinanceira> contas = new ArrayList<>();

        if (tipo == 1) {
            UsuarioSolo u = new UsuarioSolo(sis.getUsuarios().size() + 1, nome, permissoes, "Solo", contas);
            sis.getUsuarios().add(u);
            System.out.println("Usuario individual cadastrado com ID " + u.getId());
        } else if (tipo == 2) {
            // Map vazio para o rateio funcionar
            Map<String, Double> valorPorMembro = new HashMap<>();
            Grupo g = new Grupo(sis.getUsuarios().size() + 1, nome, permissoes, "Grupo", contas, valorPorMembro);
            sis.getUsuarios().add(g);
            System.out.println("Grupo cadastrado com ID " + g.getId());
        } else {
            System.out.println("Tipo invalido.");
        }
    }

    // =========================================================
    // 2) INSERIR LANCAMENTO
    // =========================================================
    private static void menuInserirLancamento(Scanner sc, SistemaFinanceiro sis) throws SaldoInsuficienteException {
        if (sis.getUsuarios().isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }

        System.out.println("\n--- Inserir Lancamento ---");
        Usuario u = escolherUsuario(sc, sis);
        if (u == null) return;

        if (u.getContas().isEmpty()) {
            System.out.println("Usuario sem contas. Use o proprio usuario para adicionar contas.");
            try {
                u.AdicionarConta();
            } catch (Exception e) {
                System.out.println("Erro ao adicionar conta: " + e.getMessage());
                return;
            }
        }

        // listarContas ANTES de escolher a conta (polimorfismo)
        u.listarContas();

        ContaFinanceira conta = escolherConta(sc, u);
        if (conta == null) return;

        System.out.print("Tipo (Receita/Despesa/Transferencia): ");
        String tipo = sc.nextLine();

        System.out.print("Categoria: ");
        String categoria = sc.nextLine();
        System.out.print("Subcategoria: ");
        String subcategoria = sc.nextLine();
        System.out.print("Destinatario/Pagador: ");
        String destinatario = sc.nextLine();

        System.out.print("Data (AAAA-MM-DD): ");
        String dataStr = sc.nextLine();
        LocalDate data = LocalDate.parse(dataStr);

        System.out.print("Valor: ");
        double valor = Double.parseDouble(sc.nextLine());

        // Validacao de saldo simples
        if (tipo.equalsIgnoreCase("Despesa")) {
            if (conta.getSaldo() < valor) {
                throw new SaldoInsuficienteException("Saldo insuficiente para a despesa.");
            }
        }

        // Atualiza saldo na conta
        if (tipo.equalsIgnoreCase("Receita")) {
            conta.EntradaValor(valor);
        } else if (tipo.equalsIgnoreCase("Despesa")) {
            conta.SaidaValor(valor);
        }

        // Cria lancamento e adiciona ao movimento
        Lancamento lanc = new Lancamento(
                categoria,
                conta,
                destinatario,
                u,
                subcategoria,
                data,
                valor,
                tipo,
                u.getTipoPerfil()
        );
        sis.getMovimento().AdicionarLancamento(lanc);

        System.out.println("Lancamento inserido com sucesso.");
    }

    // =========================================================
    // 3) RELATORIOS
    // =========================================================
    private static void menuRelatorios(Scanner sc, SistemaFinanceiro sis) {
        System.out.println("\n--- Relatorios ---");
        System.out.println("1 - Gastos por periodo");
        System.out.println("2 - Extrato por categoria");
        System.out.println("3 - Ranking de maiores despesas");
        System.out.println("4 - Projecao de saldo (periodo)");
        System.out.println("5 - Sugestao de economia por categoria");
        System.out.print("Escolha: ");

        int opcao = Integer.parseInt(sc.nextLine());

        IRelatorio relatorio = null;

        switch (opcao) {
            case 1:
                relatorio = new RelatorioGastosPorPeriodo();
                break;
            case 3:
                relatorio = new RelatorioRankingDespesas();
                break;
            case 2:
                relatorioPorCategoria(sc, sis); // ainda direto, se quiser pode virar Relatorio também
                return;
            case 4:
                relatorioProjecaoSaldo(sc, sis);
                return;
            case 5:
                relatorioSugestaoEconomia(sis.getMovimento());
                return;
            default:
                System.out.println("Opcao invalida.");
                return;
        }

        if (relatorio != null) {
            relatorio.gerar(sis.getMovimento(), sc);
        }
    }

    private static void relatorioPorPeriodo(Scanner sc, SistemaFinanceiro sis) {
        System.out.print("Data inicial (AAAA-MM-DD): ");
        LocalDate d1 = LocalDate.parse(sc.nextLine());
        System.out.print("Data final (AAAA-MM-DD): ");
        LocalDate d2 = LocalDate.parse(sc.nextLine());

        ArrayList<Lancamento> lista = sis.getMovimento().ExtratoPerido(d1, d2);
        System.out.println("=== Extrato de " + d1 + " a " + d2 + " ===");
        for (Lancamento l : lista) {
            System.out.println(l.getData() + " - " +
                    l.getCategoria() + "/" + l.getSubcategoria() +
                    " - " + l.getValor());
        }
    }

    private static void relatorioPorCategoria(Scanner sc, SistemaFinanceiro sis) {
        System.out.print("Categoria: ");
        String cat = sc.nextLine();
        System.out.print("Subcategoria: ");
        String sub = sc.nextLine();

        ArrayList<Lancamento> lista = sis.getMovimento().ExtratoCategoria(cat, sub);
        System.out.println("=== Extrato categoria " + cat + " / " + sub + " ===");
        for (Lancamento l : lista) {
            System.out.println(l.getData() + " - " +
                    l.getCategoria() + "/" + l.getSubcategoria() +
                    " - " + l.getValor());
        }
    }

    private static void relatorioRanking(Movimento movimento) {
        ArrayList<Lancamento> ranking = movimento.RankingDespesas();
        System.out.println("=== Ranking de despesas ===");
        for (Lancamento l : ranking) {
            System.out.println(l.getValor() + " - " +
                    l.getCategoria() + "/" + l.getSubcategoria() +
                    " - " + l.getData());
        }
    }

    private static void relatorioProjecaoSaldo(Scanner sc, SistemaFinanceiro sis) {
        System.out.print("Data inicial (AAAA-MM-DD): ");
        LocalDate d1 = LocalDate.parse(sc.nextLine());
        System.out.print("Data final (AAAA-MM-DD): ");
        LocalDate d2 = LocalDate.parse(sc.nextLine());

        double proj = sis.getMovimento().ProjecaoSaldo(d1, d2);
        System.out.println("Projecao de saldo no periodo: " + proj);
    }

    private static void relatorioSugestaoEconomia(Movimento movimento) {
        System.out.println("=== Sugestao de economia por categoria ===");
        movimento.SugereEconomia();
    }

    // =========================================================
    // 4) METAS E SIMULACOES
    // =========================================================
    private static void menuMetasSimulacoes(Scanner sc, SistemaFinanceiro sis) {
        System.out.println("\n--- Metas e Simulacoes ---");
        System.out.println("1 - Simulacao 'E se eu gastar X a menos/a mais'");
        System.out.println("2 - Cadastrar meta por categoria");
        System.out.println("3 - Verificar metas (alerta de estouro)");
        System.out.print("Escolha: ");
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1:
                System.out.print("Data inicial (AAAA-MM-DD): ");
                LocalDate d1 = LocalDate.parse(sc.nextLine());
                System.out.print("Data final (AAAA-MM-DD): ");
                LocalDate d2 = LocalDate.parse(sc.nextLine());
                System.out.print("Valor X para simular: ");
                double x = Double.parseDouble(sc.nextLine());

                double proj = sis.getMovimento().ProjecaoSaldo(d1, d2);
                System.out.println("Saldo projetado atual: " + proj);
                System.out.println("Se gastar X a menos: " + (proj + x));
                System.out.println("Se gastar X a mais: " + (proj - x));
                break;

            case 2:
                System.out.print("Categoria da meta: ");
                String cat = sc.nextLine();
                System.out.print("Valor limite (meta): ");
                double limite = Double.parseDouble(sc.nextLine());
                System.out.print("Data limite (AAAA-MM-DD): ");
                LocalDate dataLimite = LocalDate.parse(sc.nextLine());

                MetaOrcamento meta = new MetaOrcamento(cat, limite, dataLimite);
                metas.add(meta);
                System.out.println("Meta cadastrada.");
                break;

            case 3:
                if (metas.isEmpty()) {
                    System.out.println("Nenhuma meta cadastrada.");
                    break;
                }

                LocalDate hoje = LocalDate.now();
                for (MetaOrcamento m : metas) {
                    // soma gastos da categoria ate a data limite
                    double soma = 0.0;
                    for (Lancamento l : sis.getMovimento().ExtratoPerido(hoje.minusYears(1), m.getDataLimite())) {
                        if (l.getCategoria().equalsIgnoreCase(m.getCategoria())
                                && l.getTipo().equalsIgnoreCase("Despesa")) {
                            soma += l.getValor();
                        }
                    }
                    System.out.println("Meta categoria " + m.getCategoria()
                            + " | Limite: " + m.getValorMeta()
                            + " | Gasto ate agora: " + soma);
                    if (soma > m.getValorMeta()) {
                        System.out.println("ALERTA: Meta estourada para categoria " + m.getCategoria());
                    }
                }
                break;

            default:
                System.out.println("Opcao invalida.");
        }
    }

    // =========================================================
    // 5) HELPERS: escolher usuario/conta
    // =========================================================
    private static Usuario escolherUsuario(Scanner sc, SistemaFinanceiro sis) {
        System.out.println("Usuarios cadastrados:");
        for (Usuario u : sis.getUsuarios()) {
            System.out.println(u.getId() + " - " + u.getNome() + " (" + u.getTipoPerfil() + ")");
        }
        System.out.print("Digite o ID do usuario: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Usuario u : sis.getUsuarios()) {
            if (u.getId() == id) {
                return u;
            }
        }
        System.out.println("Usuario nao encontrado.");
        return null;
    }

    private static ContaFinanceira escolherConta(Scanner sc, Usuario u) {
        ArrayList<ContaFinanceira> contas = u.getContas();
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada.");
            return null;
        }
        System.out.println("Contas do usuario:");
        for (int i = 0; i < contas.size(); i++) {
            ContaFinanceira c = contas.get(i);
            System.out.println(i + " - " + c.getClass().getSimpleName() + " | Saldo: " + c.getSaldo());
        }
        System.out.print("Escolha o indice da conta: ");
        int idx = Integer.parseInt(sc.nextLine());
        if (idx < 0 || idx >= contas.size()) {
            System.out.println("Indice invalido.");
            return null;
        }
        return contas.get(idx);
    }
}
