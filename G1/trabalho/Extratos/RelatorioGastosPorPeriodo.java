package Extratos;

import Main.Lancamento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RelatorioGastosPorPeriodo implements IRelatorio {

    @Override
    public void gerar(Movimento movimento, Scanner sc) {
        System.out.print("Data inicial (AAAA-MM-DD): ");
        LocalDate d1 = LocalDate.parse(sc.nextLine());
        System.out.print("Data final (AAAA-MM-DD): ");
        LocalDate d2 = LocalDate.parse(sc.nextLine());

        ArrayList<Lancamento> lista = movimento.ExtratoPerido(d1, d2);
        System.out.println("=== Extrato de " + d1 + " a " + d2 + " ===");
        for (Lancamento l : lista) {
            System.out.println(l.getData() + " - " +
                    l.getCategoria() + "/" + l.getSubcategoria() +
                    " - " + l.getValor());
        }
    }
}
