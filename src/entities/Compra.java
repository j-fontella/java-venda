package entities;
 
import java.util.ArrayList;
 
public class Compra {
   
    private double total;
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
   
    public Compra(double total) {
    	this.total = total;
    }
    
    public double getTotal() {
        return total;
    }
   
    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
    }
    public String carrinhoCompras() {
        total = 0;
        String msgCarrinho = "-----Sacola-----\n";
        for (Produto produto : listaProdutos) {
            total += produto.getPreco();
            msgCarrinho += "Produto: " + produto.getNome();
            msgCarrinho += "\n";
            msgCarrinho += "Preço: " + produto.getPreco();
            msgCarrinho += "\n";
            
        }
        msgCarrinho += "----------------\nTotal: " + total;
        return msgCarrinho;
    }
   
 
}