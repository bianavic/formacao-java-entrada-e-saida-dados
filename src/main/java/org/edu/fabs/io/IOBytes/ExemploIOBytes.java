package org.edu.fabs.io.IOBytes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ExemploIOBytes {

    //Faça uma cópia do arquivo “recomendacoes-copy.txt”.
    public static void copiarArquivo() throws IOException {

        File f = new File("/home/ribon/Documents/workspace/dio/java/formacao/formacao-java-entrada-e-saida-dados/recomendacoes-copy.txt");
        String nomeArquivo = f.getName();

        /*
        InputStream is = new FileInputStream(nomeArquivo);
        BufferedInputStream bis = new BufferedInputStream(is);
        */

        // decorator
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nomeArquivo));

        // preparar arquivo de saida
        // criacao do fluxo de entrada
        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf("-")).concat("-copy2.txt");
        File fCopy = new File(nomeArquivoCopy);

        /*
        OutputStream os = new FileOutputStream(nomeArquivoCopy);
        BufferedOutputStream bos = new BufferedOutputStream(os);
         */

        // decorator
        // criar o documento
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nomeArquivoCopy));

        // pq trabalhamos com bytes, nao temos readLine()
        int line = 0;
        while ((line = bis.read()) != -1) {
            bos.write((char) line); // pegar o numero, o valor da linha e transformar num char
            bos.flush();
        }

        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo %s copiado com sucesso e está no diretório %s com %d bytes ",
                fCopy.getName(), fCopy.getPath(), fCopy.length());
    }
    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }

}
