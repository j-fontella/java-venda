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
    public void carrinhoCompras() {
        total = 0;
        for (Produto produto : listaProdutos) {
            total += produto.getPreco();
            System.out.println(produto.getNome());
            System.out.println(produto.getPreco());
        }
        System.out.println("Total: R$: " + total);
    }
   
 
}