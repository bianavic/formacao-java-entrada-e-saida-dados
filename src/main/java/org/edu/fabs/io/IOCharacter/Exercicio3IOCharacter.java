package org.edu.fabs.io.IOCharacter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio3IOCharacter {

    //Faça uma cópia do arquivo “recomendacoes.txt” e agora adicione 3 recomendações de livros. - sem apagar o conteudo
    public static void copiarArquivo() throws IOException {

        // classe file para melhor controle sobre o arquivo
        File f = new File("/home/ribon/Documents/workspace/dio/java/formacao/formacao-java-entrada-e-saida-dados/recomendacoes.txt");
        String nomeDoArquivoOriginal = f.getName();

        // abrir o arquivo
        /*Reader r = new FileReader(nomeArquivo);
        BufferedReader br = new BufferedReader(r);*/

        // padrao decorator
        // iniciando fluxo
        BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivoOriginal));
        // pegando cada linha do arquivo
        String line = br.readLine();

        // criar NOME do arquivo de copia
        // substring -> pq quero apenas um trecho da string: recomendacoes.txt -> do indice 0 (apos a barra) até antes do ponto txt
        String nomeDoArquivoCopy = nomeDoArquivoOriginal.substring(0, nomeDoArquivoOriginal.indexOf("."))
                .concat("-copy.txt");
        File fcopy = new File(nomeDoArquivoCopy);

        // CRIAR arquivo de copia
//        BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivoCopy));
        // ou
        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName()));

        // fazer a COPIA
        do {
            // linha do documento antigo
            bw.write(line);
            bw.newLine();
            line = br.readLine();
            bw.flush();
        } while (!(line == null));
        br.close();
        bw.close();
        System.out.printf("arquivo \"%s\" copiado com sucesso! com o tamanho '%d' bytes\n", f.getName(), f.length());
        System.out.printf("arquivo \"%s\" criado com sucesso! com o tamanho '%d' bytes", fcopy.getName(), fcopy.length());
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }

}
