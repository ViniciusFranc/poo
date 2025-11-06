public class Main{

    public static void main(String args[]){
    Pessoa pai = new Pai("abc", "01 janeiro 25","02 janeiro 25","dx,rs,br",null,null);
    Pessoa mae = new Mae("cds","01 fevereiro 20", "00 janeiro 23", "brasilia, brasilia,br",null,null);
    Pessoa filho = new Pai("trs", "12-12-12","13-13-13", "olinda-japao,paulo",pai,mae);
    
    pai.Exibir(pai);
    mae.Exibir(mae);
    filho.Exibir(filho);
    }
}