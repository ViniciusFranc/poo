public class produto{
    private String nome;
    private double preco;
    private int quantidade;

    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int getQuantidade(){
        return quantidade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPreco(double p){
        if (p >=0){
            this.preco = p;
        }else{
            System.out.println("valores negativos para preço não são aceitos");
        }
    }
    public void setQuantidade(int q){
        if (q>=0){
            this.quantidade=q;
        }else{
            System.out.println("valores negativos para quantidade não são aceitos");
        }
    }

    public double valorTotal(){
        return preco*quantidade;
    }

    public void adicionar(int qtd){
        if (qtd>=0){
            this.quantidade=quantidade+qtd;
        }else{
            System.out.println("valores negativos para quantidade não são aceitos");
        }  
    }

    public void remover(int qtd){
        if (quantidade<qtd){
            this.quantidade=quantidade-qtd;
        }else{
            System.out.println("não pode remover mais do que tem no estoque");
        }  
    }
}