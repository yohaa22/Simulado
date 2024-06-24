import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programa {
    public static void main(String[] args) {
        try {
            List<Pessoa> pessoas = CSVReader.lerPessoas("Pessoas.csv");
            List<Endereco> enderecos = CSVReader.lerEnderecos("Enderecos.csv");

            // Criando um mapa de pessoaId para Pessoa
            Map<Integer, Pessoa> pessoaMap = new HashMap<>();
            for (Pessoa p : pessoas) {
                pessoaMap.put(p.getId(), p);
            }

            // Criando e escrevendo o novo arquivo CSV
            BufferedWriter bw = new BufferedWriter(new FileWriter("PessoasComEnderecos.csv"));
            bw.write("ID;Nome;Rua;Cidade");
            bw.newLine();
            for (Endereco e : enderecos) {
                Pessoa p = pessoaMap.get(e.getPessoaId());
                if (p != null) {
                    String linhaCsv = p.toCsv() + ";" + e.toCsv();
                    bw.write(linhaCsv);
                    bw.newLine();
                }
            }
            bw.close();

            System.out.println("Arquivo PessoasComEnderecos.csv gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

