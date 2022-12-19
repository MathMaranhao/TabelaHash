package tabelaHash;

import questao01.Cliente;
import util.ListaDuplamenteEncadeada;
import util.No;

public final class TabelaHash {

    public ListaDuplamenteEncadeada<Cliente> vetor[];
    private int tamanhoTabelaHash;
    private int qtdItensHash;

    public int getTamanhoTabelaHash() {
        return tamanhoTabelaHash;
    }

    public int getQtdItensHash() {
        return qtdItensHash;
    }

    public ListaDuplamenteEncadeada<Cliente> getVetor(int i) {
        return vetor[i];
    }

    public TabelaHash() {
    }

    public TabelaHash(int TamanhoArquivo) {

        this.tamanhoTabelaHash = encontraPrimoProximo(TamanhoArquivo);
        this.qtdItensHash = 0;

        vetor = new ListaDuplamenteEncadeada[this.tamanhoTabelaHash];
        inicializaTabelaHash(this.tamanhoTabelaHash);

    }

    public void inicializaTabelaHash(int tamanhoTabelaHash) {
        for (int i = 0; i < tamanhoTabelaHash; i++) {
            vetor[i] = new ListaDuplamenteEncadeada();
        }
    }

    public int hashing(int identificador) {

        double constante = 0.6180339887;
        double hashMultiplicacao = identificador * constante;
        hashMultiplicacao = hashMultiplicacao - (int) hashMultiplicacao;

        return (int) (this.tamanhoTabelaHash * hashMultiplicacao);

    }

    public void adicionarTabelaHash(Cliente cliente) {

        int posicao = hashing(cliente.getIdCliente());

        vetor[posicao].inserirFinal(cliente);

        this.qtdItensHash++;
    }

    public int buscarTabelaHash(int identificador) {

        int posicao = hashing(identificador);

        No no = new No();

        no = vetor[posicao].getInicio();

        if (no == null) {
            System.out.println("\n| O cliente de Id: " + identificador + " não está na tabela [!]");
            return 0;
        } else {
            Cliente cliente = new Cliente();

            cliente = (Cliente) no.getElemento();

            while (cliente.getIdCliente() != identificador && no != null) {
                no = no.getProximo();
                if (no == null) {
                    System.out.println("\n| O cliente de Id: " + identificador + " não está na tabela [!]");
                    return 0;
                }
                cliente = (Cliente) no.getElemento();
            }
            System.out.println("\n| Informação do Cliente: ");
            System.out.println("| Id: " + cliente.getIdCliente());
            System.out.println("| Nome: " + cliente.getNomeCliente());
            System.out.println("| Email: " + cliente.getEmailCliente());

            return 1;
        }
    }

    public int removerTabelaHash(int identificador) {
        int posicao = hashing(identificador);

        No no = new No();

        no = vetor[posicao].getInicio();

        if (no == null) {
            System.out.println("Elemento não está na tabela");
            return 0;
        } else {
            Cliente cliente = new Cliente();

            cliente = (Cliente) no.getElemento();

            int contador = 0;

            while (cliente.getIdCliente() != identificador && no != null) {
                no = no.getProximo();
                if (no == null) {
                    System.out.println("Elemento não está na tabela");
                    return 0;
                }
                cliente = (Cliente) no.getElemento();
                contador++;
            }

            vetor[posicao].removerPorPosicao(contador);
            this.qtdItensHash--;
            return 1;

        }

    }

    public void imprimirTabela() {

        for (int i = 0; i < this.tamanhoTabelaHash; i++) {
            //System.out.println("- " + i);

            No no = vetor[i].getInicio();
            Cliente cliente = new Cliente();

            if (no == null) {
                System.out.println("Lista Vazia");
            } else {
                while (no != null) {
                    cliente = (Cliente) no.getElemento();
                    System.out.println("\n| Informação do Cliente: ");
                    System.out.println("| Id: " + cliente.getIdCliente());
                    System.out.println("| Nome: " + cliente.getNomeCliente());
                    System.out.println("| Email: " + cliente.getEmailCliente());
                    no = no.getProximo();
                }
            }
        }
    }

    public int encontraPrimoProximo(int tamanhoLista) {

        boolean numPrimo = false;
        int numPrimoProximo = tamanhoLista;
        int qtdDivisores;

        while (numPrimo != true) {
            qtdDivisores = 0;

            for (int i = 1; i <= numPrimoProximo; i++) {
                if ((numPrimoProximo % i) == 0) {
                    qtdDivisores++;
                }
            }

            if (qtdDivisores != 2) {
                numPrimo = false;
                numPrimoProximo++;
            } else {
                numPrimo = true;
            }
        }

        return numPrimoProximo;
    }

}
