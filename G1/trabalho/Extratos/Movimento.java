package Extratos;

import Main.Lancamento;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


public class Movimento implements Serializable{

    ArrayList<Lancamento> Extrato= new ArrayList<>();



    public void AdicionarLancamento(Lancamento l){
        if (l instanceof Lancamento){
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


}