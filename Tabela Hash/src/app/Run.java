package app;

import java.io.IOException;
import questao01.Class01;
import questao02.Class02;

public class Run {

    public static void main(String[] args) throws IOException {

        //Questao 01
        Class01 class01 = new Class01();

        String caminhoDadosCliente, caminhoDadosConsulta;
        //caminhoDadosCliente = "src/entrada/questao01DadosClientes.txt"; // Para testes na IDE
        //caminhoDadosConsulta = "src/entrada/questao01DadosDeBusca.txt";

        caminhoDadosCliente = ".\\questao01DadosClientes.txt"; // Para testes na IDE
        caminhoDadosConsulta = ".\\questao01DadosDeBusca.txt"; // Para testes na IDE

        class01.questa01(caminhoDadosCliente, caminhoDadosConsulta);

        //Questao 02
        Class02 class02 = new Class02();

        String caminhoDadosClienteEncripitacao, caminhoDadosDesencripitacao;
        //caminhoDadosClienteEncripitacao = "src/entrada/questao02DadosClientesEncripitacao.txt"; // Para testes na IDE
        //caminhoDadosDesencripitacao = "src/entrada/questao02DadosClientesDesencripitacao.txt"; // Para testes na IDE

        caminhoDadosClienteEncripitacao = ".\\questao02DadosClientesEncripitacao.txt";
        caminhoDadosDesencripitacao = ".\\questao02DadosClientesDesencripitacao.txt";

        class02.questao02(caminhoDadosClienteEncripitacao, caminhoDadosDesencripitacao);

    }
}
