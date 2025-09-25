public class Vestido {
    private double preco;
    private int id;
    private String nome;
    private String tamanho;
    private String foto;
    public Vestido(int id, String nome, String tamanho, double preco, String foto) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.foto = foto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
