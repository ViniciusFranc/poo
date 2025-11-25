package Extratos;

import Main.Lancamento;
import java.util.ArrayList;
import java.util.Scanner;

public class RelatorioRankingDespesas implements IRelatorio {

    @Override
    public void gerar(Movimento movimento, Scanner sc) {
        ArrayList<Lancamento> ranking = movimento.RankingDespesas();
        System.out.println("=== Ranking de despesas ===");
        for (Lancamento l : ranking) {
            System.out.println(l.getValor() + " - " +
                    l.getCategoria() + "/" + l.getSubcategoria() +
                    " - " + l.getData());
        }
    }
}
