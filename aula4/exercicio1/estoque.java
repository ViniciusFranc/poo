

public class estoque{
    private produto[] produtos = new produto[10];

    public void adcProduto(produto p){
        for (int i =0;i<produtos.length;i++){
            if (produtos[i].getNome().equals(p.getNome())){
                System.out.println("produto ja cadastrado");
            }else{
                produtos[i]= p;
            }}}
    
    public String buscarPorNome(String nome){
        for (int i = 0; i<produtos.length;i++){
            if (produtos[i].getNome().equals(nome)){
                return "Nome: "+produtos[i].getNome()+" - "+"preço: "+produtos[i].getPreco()+" - "+"quantidade: "+produtos[i].getQuantidade();
            }
        }
        return null;
    }

    public double valorTotalEstoque(){
        double soma = 0;
        for (int i = 0; i <produtos.length; i++) {
            soma = soma + produtos[i].valorTotal();
        }
        return soma;
    }

    public boolean movimentar(String nome, int qtd, boolean entrada){
        for (int i = 0; i <produtos.length; i++) {
            if (produtos[i].getNome().equals(nome)){
                int qtdAtual = produtos[i].getQuantidade();
                if (entrada){
                    produtos[i].setQuantidade(qtdAtual+qtd);

                }
            }
        }
        return entrada;
    }
}
