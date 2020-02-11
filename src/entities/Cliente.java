package entities;
 
public class Cliente {
   
    private String nome;
    private int id;
    private int senha;
    private Compra compra;
   
   
   
    public Cliente(String nome, int senha, int id) {
        this.nome = nome;
        this.senha = senha;
        this.id = id;
        this.compra = new Compra(0); 
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getSenha() {
        return senha;
    }
    public Compra getCompra() {
        return compra;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
   
 
   
 
}