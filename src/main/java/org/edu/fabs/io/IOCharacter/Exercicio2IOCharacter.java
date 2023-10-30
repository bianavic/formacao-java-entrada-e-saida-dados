package org.edu.fabs.io.IOCharacter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercicio2IOCharacter {

    //Abra o teclado para escrever 3 filmes que você recomendaria e armazene em “recomendacoes.txt”.
    public static void lerTecladoEscreverDocumento() throws IOException {

        // imprimir frase no console
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("digite 3 recomendacoes de filmes");
        pw.flush();

        // abrir teclado
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        // utilizaremos metodos da classe File para melhorar a manipulacao do arquivo
        File f = new File("recomendacoes.txt");

        // criar documento com buffered atraves da classe FileWriter -> sera criado e salvo na pasta raiz
        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName())); // estou pegando apenas o nome do arquivo

        // escrever dentro do documento
        do {
            bw.write(line);
            bw.newLine();
            bw.flush(); // descarregar
            line = scan.nextLine();
        } while ((!line.equalsIgnoreCase("fim")));

        pw.printf("arquivo \"%s\" foi criado com sucesso!", f.getName());
        // pw.flush(); opcional, pq qdo fecha - close() - ele ja descarrega

        pw.close();
        scan.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }

}
