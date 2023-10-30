package org.edu.fabs.io.IOCharacter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercicio1IOCharacter {

    //Abra o teclado para escrever 3 filmes que você recomendaria e exiba esses filmes no console.
    public static void receberTecladoImprimirConsole() throws IOException {

        // FLUXO DE ENTRADA
        /*
        // fluxo bytes -> recebendo do teclado
        InputStream is = System.in;
        // fluxo character -> convertendo para caractere
        InputStreamReader isr = new InputStreamReader(is);
        // armazenando em um buffer
        BufferedReader br = new BufferedReader(isr);*/

        System.out.println("recomende 3 filmes");
        // padrao decorator
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        // FLUXO DE SAIDA
        /*
        OutputStream os = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);*/

        // padrao decorator
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // laco
        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (!(line.isEmpty()));

        // descarregar o buffer
        bw.flush();
        // fechar o fluxo
        br.close();
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        receberTecladoImprimirConsole();
    }

}
