package util;

public class No<TIPO>{

    private TIPO elemento;
    private No proximo;
    private No anterior;

    public No() {
        this.elemento = null;
        this.proximo = null;
        this.anterior = null;
    }

    public No(TIPO elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public TIPO getElemento() {
        return elemento;
    }

    public void setElemento(TIPO elemento) {
        this.elemento = elemento;
    }

    public No<TIPO> getProximo() {
        return proximo;
    }

    public void setProximo(No<TIPO> proximo) {
        this.proximo = proximo;
    }

    public No<TIPO> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<TIPO> anterior) {
        this.anterior = anterior;
    }

}
