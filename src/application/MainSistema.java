package application;
 
import java.util.ArrayList;
import java.util.Scanner;
 
import entities.Cliente;
import entities.Produto;
 
public class MainSistema {
 
    public static void main(String[] args) {
       
        Scanner scn = new Scanner(System.in);
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        System.out.println("Quantos clientes vão ser registrados");
        int totalScan = scn.nextInt();
       
        String nome;
        int senha;
        for (int i = 0; i < totalScan; i++) {  
            System.out.println("Digite o nome do cliente " + (i + 1));
            nome = scn.next();
            System.out.println("Digite uma senha para o cliente: " + nome);
            senha = scn.nextInt();
            listaClientes.add(new Cliente(nome, senha, (i+1)));
            System.out.println("Cliente gerado:");
            System.out.println("Nome: " + nome + " id:" + (i + 1) + " senha:" + senha);
        }
       
        System.out.println("Digite quantos produtos serão registrados");
        totalScan = scn.nextInt();
        double preco;
        for (int i = 0; i < totalScan; i++) {
            System.out.println("Digite o nome do produto " + (i + 1));
            nome = scn.next();
            System.out.println("Digite o preço do produto " + nome);
            preco = scn.nextDouble();
            listaProdutos.add(new Produto(nome, preco));   
        }
       
        int navegador = -1;
        int logado = 0;
        int id, pass, encontrado = 0;
        Cliente clienteLogado = null;
        String produtoComprado = "";
        while(navegador != 0) {
            if(logado == 0) {
                System.out.println("Digite seu id");
                id = scn.nextInt();
                for (Cliente cliente : listaClientes) {
                    if (id == cliente.getId()) {
                        clienteLogado = cliente;
                    }
                    
                }
                if(clienteLogado == null) {
                	System.out.println("ID não encontrado");
                    continue;
                }
                System.out.println("Digite sua senha ");
                pass = scn.nextInt();
                if(pass == clienteLogado.getSenha()) {
                    System.out.println("Login efetuado com sucesso");
                    System.out.println("Seja bem-vindo, " + clienteLogado.getNome());
                    logado = 1;
                    
                }
                else {
                    System.out.println("Senha incorreta, efetue o login novamente!");
                    clienteLogado = null;
                    continue;
                }
               
            
        }
        if(logado == 1) {
            System.out.println("Digite 1 para ver produtos disponiveis, 2 para comprar um produto, 3 para ver sua sacola de compras ou 0 para desconectar");
            navegador = scn.nextInt();
            switch(navegador) {
                case 0:
                    clienteLogado = null;
                    logado = 0;
                    System.out.println("Obrigado por usar nosso sistema");
                    navegador = 0;
                    break;
                case 1:
                    for (Produto produto : listaProdutos) {
                        System.out.println(produto.getNome());
                        System.out.println("R$: " + produto.getPreco());
                        navegador = -1;
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do produto que deseja adicionar a sua sacola de compras");
                    produtoComprado = scn.next();
                    for (Produto produto : listaProdutos) {
                        if(produtoComprado.equals(produto.getNome())) {
                            clienteLogado.getCompra().adicionarProduto(produto);
                            System.out.println("Produto adicionado com sucesso!");
                            encontrado = 1;
                        }
                    }
                    if(encontrado == 0) {
                        System.out.println("Produto não encontrado!");
                    }
                    navegador = -1;
                    break;
                case 3:
                    clienteLogado.getCompra().carrinhoCompras();
            }
        }
 
    }
 
 }
}
