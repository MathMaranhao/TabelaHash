package questao01;

import java.io.IOException;
import java.util.List;
import javax.print.attribute.Size2DSyntax;
import tabelaHash.TabelaHash;
import util.ManipuladorArquivos;

public class Class01 {

    public void questa01(String caminhoDadosCliente, String caminhoDadosBusca) throws IOException {

        System.out.println("| Questao 01");

        TabelaHash tabelaHash = new TabelaHash();

        tabelaHash = carregaTabelaHash(caminhoDadosCliente); // Carregar os dados do arquivo 

        double[] vetorNumerosParaBusca;

        vetorNumerosParaBusca = carregarVetorNumerosParaBusca(caminhoDadosBusca); // Carregar os dados do arquivo

        System.out.println("\n| Tamanho Tabela Hash: " + tabelaHash.getTamanhoTabelaHash());
        System.out.println("| Quantidade de Elementos na Tabela Hash: " + tabelaHash.getQtdItensHash());

        System.out.println("| Dados da Busca: ");
        buscaElementosVetorNaTabela(tabelaHash, vetorNumerosParaBusca);

    }

    public TabelaHash carregaTabelaHash(String caminhoDadosCliente) throws IOException {
        ManipuladorArquivos manipulaArquivos = new ManipuladorArquivos();

        List<String> dadosArquivo = ManipuladorArquivos.lerArquivo(caminhoDadosCliente);

        TabelaHash tabelaHash = new TabelaHash(dadosArquivo.size());

        for (int i = 0; i < dadosArquivo.size(); i++) {
            Cliente cliente = new Cliente();

            String elementoInteiro = dadosArquivo.get(i);

            String[] elementoSeparado = elementoInteiro.split(";");

            cliente.setIdCliente(Integer.parseInt(elementoSeparado[0]));
            cliente.setNomeCliente(elementoSeparado[1]);
            cliente.setEmailCliente(elementoSeparado[2]);

            tabelaHash.adicionarTabelaHash(cliente);
        }

        return tabelaHash;
    }

    public double[] carregarVetorNumerosParaBusca(String caminhoDadosBusca) throws IOException {
        ManipuladorArquivos manipulaArquivos = new ManipuladorArquivos();

        List<String> dadosArquivo = ManipuladorArquivos.lerArquivo(caminhoDadosBusca);

        double[] vetorNumeros = new double[dadosArquivo.size()];

        for (int i = 0; i < dadosArquivo.size(); i++) {
            vetorNumeros[i] = Double.parseDouble(dadosArquivo.get(i));
        }

        return vetorNumeros;
    }

    public void buscaElementosVetorNaTabela(TabelaHash tabelaHash, double[] vetorNumeros) {
        for (int i = 0; i < vetorNumeros.length; i++) {
            tabelaHash.buscarTabelaHash((int) (vetorNumeros[i]));
        }
    }

}
