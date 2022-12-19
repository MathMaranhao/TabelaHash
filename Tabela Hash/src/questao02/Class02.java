package questao02;

import java.io.IOException;
import java.util.List;
import questao01.Cliente;
import tabelaHash.TabelaHash;
import util.ManipuladorArquivos;

public class Class02 {

    public void questao02(String caminhoDadosCliente, String caminhoArquivoCripitografado) throws IOException {

        System.out.println("\n| Questao 02");
        System.out.println("\n| Lista Cripitografada");

        TabelaHash tabelaHash = new TabelaHash();

        tabelaHash = encripitarDados(caminhoDadosCliente);

        tabelaHash.imprimirTabela();

        System.out.println("\n| Dados Descripitografados\n");

        descripitografarArquivo(caminhoArquivoCripitografado);

    }

    public TabelaHash encripitarDados(String caminhoDadosCliente) throws IOException {

        ManipuladorArquivos manipulaArquivos = new ManipuladorArquivos();

        List<String> dadosArquivo = ManipuladorArquivos.lerArquivo(caminhoDadosCliente);

        TabelaHash tabelaHash = new TabelaHash(dadosArquivo.size());

        for (int i = 0; i < dadosArquivo.size(); i++) {
            Cliente cliente = new Cliente();

            String elementoInteiro = dadosArquivo.get(i);

            String[] elementoSeparado = elementoInteiro.split(";");

            String nomeEncripitado = encripitar(elementoSeparado[1]);
            String emailEncripitado = encripitar(elementoSeparado[2]);

            cliente.setIdCliente(Integer.parseInt(elementoSeparado[0]));
            cliente.setNomeCliente(nomeEncripitado);
            cliente.setEmailCliente(emailEncripitado);

            tabelaHash.adicionarTabelaHash(cliente);
        }

        return tabelaHash;

    }

    public void descripitografarArquivo(String caminhoArquivoCripitografado) throws IOException {

        ManipuladorArquivos manipulaArquivos = new ManipuladorArquivos();

        List<String> dadosArquivo = manipulaArquivos.lerArquivo(caminhoArquivoCripitografado);

        for (int i = 0; i < dadosArquivo.size(); i++) {
            String palavra;
            palavra = descripitografar(dadosArquivo.get(i));

            System.out.println(" - " + palavra);
        }

    }

    public String encripitar(String palavra) {

        char[] letras = palavra.toCharArray();
        int[] letraAsc = new int[palavra.length()];

        char[] palavraCharEncripitada = new char[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            letraAsc[i] = (int) (letras[i]) + 4;

            palavraCharEncripitada[i] = (char) (letraAsc[i]);
        }

        String palavraEncripitada = new String(palavraCharEncripitada);

        return palavraEncripitada;
    }

    public String descripitografar(String palavra) {

        char[] letras = palavra.toCharArray();
        int[] letraAsc = new int[palavra.length()];

        char[] palavraCharEncripitada = new char[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            letraAsc[i] = (int) (letras[i]) - 4;

            palavraCharEncripitada[i] = (char) (letraAsc[i]);
        }

        String palavraEncripitada = new String(palavraCharEncripitada);

        return palavraEncripitada;
    }

}
