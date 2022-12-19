package questao01;

public class Cliente {

    private int idCliente;
    private String nomeCliente;
    private String emailCliente;

    public Cliente() {
        this.idCliente = 0;
        this.nomeCliente = null;
        this.emailCliente = null;
    }

    public Cliente(int idCliente, String nomeCliente, String emailCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    
}
