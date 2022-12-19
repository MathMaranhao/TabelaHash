package util;

public class ListaDuplamenteEncadeada<TIPO> {

    private No<TIPO> inicio;
    private No<TIPO> fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public No<TIPO> getInicio() {
        return inicio;
    }

    public boolean listaVazia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void imprimirLista() {

        if (listaVazia()) {
            System.out.println("Lista Vazia");
        } else {
            No noAux = new No();
            noAux = this.inicio;

            while (noAux != null) {
                System.out.println(noAux.getElemento());
                noAux = noAux.getProximo();
            }
        }
    }

    public void inserirInicio(TIPO elemento) {

        No novoNo = new No(elemento);
        novoNo.setProximo(this.inicio);

        if (this.inicio != null) {
            this.inicio.setAnterior(novoNo);
        }
        this.inicio = novoNo;

        if (this.tamanho == 0) {
            this.fim = this.inicio;
        }

        this.tamanho++;

    }

    public void removerInicio() {

        if (listaVazia()) {
            System.out.println("Lista Vazia");
        } else {

            this.inicio = this.inicio.getProximo();

            if (this.inicio != null) {
                this.inicio.setAnterior(null);
            } else {
                this.fim = null;
            }

            this.tamanho--;
        }
    }

    public void inserirFinal(TIPO elemento) {

        No novoNo = new No(elemento);
        novoNo.setAnterior(this.fim);

        if (this.fim != null) {
            this.fim.setProximo(novoNo);
        }

        this.fim = novoNo;

        if (this.tamanho == 0) {
            this.inicio = this.fim;
        }

        this.tamanho++;
    }

    public void removerFinal() {

        if (listaVazia()) {
            System.out.println("Lista Vazia");
        } else {
            this.fim = this.fim.getAnterior();

            if (this.fim != null) {
                this.fim.setProximo(null);
            } else {
                this.inicio = null;
            }

            this.tamanho--;
        }
    }

    public boolean inserirPorPsicao(int indice, TIPO elemento) {

        if (indice == 0) {
            inserirInicio(elemento);
            return true;
        }
        if (indice == this.tamanho) {
            inserirFinal(elemento);
            return true;
        } else {
            No noAtual = new No();
            noAtual = this.inicio;

            for (int i = 0; i < indice - 1; i++) {
                noAtual = noAtual.getProximo();
            }

            No novoNo = new No(elemento);

            novoNo.setAnterior(noAtual);
            novoNo.setProximo(noAtual.getProximo());
            noAtual.getProximo().setAnterior(novoNo);
            noAtual.setProximo(novoNo);
        }
        this.tamanho++;
        return true;
    }

    public boolean removerPorPosicao(int indice) {

        if (listaVazia()) {
            System.out.println("Lista Vazia");
            return false;
        } else {

            if (indice == 0) {
                removerInicio();
                return true;
            }
            if (indice == this.tamanho - 1) {
                removerFinal();
                return true;
            } else {

                No noAtual = new No();
                noAtual = this.inicio;

                for (int i = 0; i < indice; i++) { //chega no indice que deseja excluir
                    noAtual = noAtual.getProximo();
                }

                if (noAtual.getAnterior() != null) {
                    noAtual.getAnterior().setProximo(noAtual.getProximo());
                }
                if (noAtual.getProximo() != null) {
                    noAtual.getProximo().setAnterior(noAtual.getAnterior());
                }

                this.tamanho--;

                return true;
            }

        }
    }

    public No retornaNoPosicao(int posicao) {

        if (listaVazia()) {
            System.out.println("Lista Vazia");
            return null;
        }
        if (posicao < 0 || posicao > (tamanho - 1)) {
            System.out.println("Posição invalida");
            return null;
        } else {

            No noAtual = this.inicio;

            for (int i = 0; i < posicao; i++) {
                noAtual = noAtual.getProximo();
            }

            return noAtual;
        }
    }

    public boolean trocaElementos(int posicao1, int posicao2) {

        if (listaVazia()) {
            System.out.println("Lista Vazia");
            return false;
        }
        if (posicao1 < 0 || posicao1 > (this.tamanho - 1) || posicao2 < 0 || posicao2 > (this.tamanho - 1)) {
            System.out.println("Posição invalida");
            return false;
        } else {

            No noPosicao1, noPosicao2;

            noPosicao1 = retornaNoPosicao(posicao1);
            noPosicao2 = retornaNoPosicao(posicao2);

            removerPorPosicao(posicao1);
            inserirPorPsicao(posicao1, (TIPO) noPosicao2.getElemento());

            removerPorPosicao(posicao2);
            inserirPorPsicao(posicao2, (TIPO) noPosicao1.getElemento());
        }
        return true;
    }

}
