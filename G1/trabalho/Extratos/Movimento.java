package Extratos;

import Main.Lancamento;
import Users.Grupo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Movimento{

    ArrayList<Lancamento> Extrato= new ArrayList<>();



    public void AdicionarLancamento(Lancamento l) {

        if (l.getRemetente() instanceof Grupo && l.getTipo().equals("Despesa")) {
            Grupo grupo = (Grupo) l.getRemetente();
            Map<String, Double> membros = grupo.getValorPorMembro(); 
            int totalMembros = membros.size();
            double valorIndividual = l.getValor() / totalMembros;

            for (String membro : membros.keySet()) {

                Lancamento lancMembro = new Lancamento(
                    l.getCategoria(),
                    l.getConta(),
                    l.getDestinatario(),
                    grupo,
                    l.getSubcategoria(),
                    l.getData(),
                    valorIndividual,
                    l.getTipo(),
                    l.getTipoUser()
                );
                Extrato.add(lancMembro);
            }
        } else {
            Extrato.add(l);
        }
    }


    public ArrayList<Lancamento> ExtratoPerido(LocalDate d1, LocalDate d2){
    ArrayList<Lancamento> LancPeriodo= new ArrayList<>();
    for (Lancamento lanc : Extrato) {
    if ((lanc.getData().isEqual(d1) || lanc.getData().isAfter(d1)) && 
        (lanc.getData().isEqual(d2) || lanc.getData().isBefore(d2))) {
        LancPeriodo.add(lanc);
    }}
    return LancPeriodo;
    }


    public ArrayList<Lancamento> ExtratoCategoria(String Categoria,String Subcategoria){
    ArrayList<Lancamento> LancCat= new ArrayList<>();
    for (Lancamento lanc : Extrato) {
    if (lanc.getCategoria().equals(Categoria) && 
        lanc.getSubcategoria().equals(Subcategoria)) {
        LancCat.add(lanc);
    }}
    return LancCat;
    }

    public ArrayList<Lancamento> RankingDespesas(){
    ArrayList<Lancamento> RankingLanc= new ArrayList<>(Extrato);
    Comparator<Lancamento> comparaDecrescente = Comparator.comparing(Lancamento::getValor).reversed();
    RankingLanc.sort(comparaDecrescente);
    return RankingLanc;
    }

    public Double ProjecaoSaldo(LocalDate DtAtual, LocalDate DtFutur){

        double projecao = 0;

        for (Lancamento lanc : Extrato){

            if ((lanc.getData().isEqual(DtAtual) || lanc.getData().isAfter(DtAtual)) && 
                (lanc.getData().isEqual(DtFutur) || lanc.getData().isBefore(DtFutur))) {

                    if (lanc.getTipo().equals("Despesa")){
                        projecao -= lanc.getValor();
                    }else if (lanc.getTipo().equals("Receita")){
                        projecao += lanc.getValor();
                    }
                }
            }
        return projecao;
    }



    public void SugereEconomia (){

        Map<String, ArrayList<Double>> AgrupaCats = new HashMap<>();
        Map<String, Double> GuardaCalculo = new HashMap<>();

        for (Lancamento lanc : Extrato) {
            ArrayList<Double> listaValores= new ArrayList<>();
            if (lanc.getTipo().equals("Despesa")){
                if (AgrupaCats.containsKey(lanc.getCategoria())){
                    AgrupaCats.get(lanc.getCategoria()).add(lanc.getValor());
                }else{
                    listaValores.add(lanc.getValor());
                    AgrupaCats.put(lanc.getCategoria(), listaValores);
                }
            }
        }                   
        for (String MapKey : AgrupaCats.keySet()){
            ArrayList<Double> valores = AgrupaCats.get(MapKey);
            double soma = 0;

            for (double v : valores){
                soma += v;
            }
            double media = soma/valores.size();
            GuardaCalculo.put(MapKey, media);            
        }

        double somaMedias = 0;
        for (double media : GuardaCalculo.values()) {
            somaMedias += media;
        }
        double mediaGeral = GuardaCalculo.isEmpty() ? 0 : somaMedias / GuardaCalculo.size();

        for (String categoria : GuardaCalculo.keySet()) {
            double mediaCategoria = GuardaCalculo.get(categoria);
            if (mediaCategoria > mediaGeral) {
                System.out.println("Seu gasto na categoria " + categoria + " foi acima da média: " +
                                    "Média Geral = (" + mediaGeral + "); Média da Categoria = (" + mediaCategoria + ").\n" +
                                    "Considere reduzir os gastos nesta área.");
            }
        }

    }


}
