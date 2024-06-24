public class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // Método toCsv para converter em formato CSV com ID e Nome
    public String toCsv() {
        return id + ";" + nome;
    }
}