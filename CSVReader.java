import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Pessoa> lerPessoas(String arquivo) throws IOException {
        List<Pessoa> pessoas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(";");
            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            pessoas.add(new Pessoa(id, nome));
        }
        br.close();
        return pessoas;
    }

    public static List<Endereco> lerEnderecos(String arquivo) throws IOException {
        List<Endereco> enderecos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(";");
            String rua = dados[0];
            String cidade = dados[1];
            int pessoaId = Integer.parseInt(dados[2]);
            enderecos.add(new Endereco(rua, cidade, pessoaId));
        }
        br.close();
        return enderecos;
    }
}
