package org.edu.fabs.io.IOBytes.IOData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExemploIOData {

    /*
Crie um arquivo “roupa.bin” e armazene:
1. Nome do produto, tamanho (P/M/G/U),quantidade e preço.
2. Leia este arquivo e imprima no console.
*/
    public static void incluirProduto() throws IOException {

        // chama arquivo
        File f = new File("/home/ribon/Documents/workspace/dio/java/formacao/peca-de-roupa.bin");
        // imprime console
        PrintStream ps = new PrintStream(System.out);
        ps.flush();
        // persistir tipos primitivos e String no documento
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

        // abrir o fluxo atraves do teclado
        Scanner scanner = new Scanner(System.in);

        ps.print("nome da peça: "); // pede para imprimir
        String nome = scanner.nextLine(); // captura o nome para a variavel
        dos.writeUTF(nome); // escrever persistir o nome capturado no doc

        ps.print("tamanho da peça (P/M/G/U): "); // pede para imprimir
        char tamanho = (char) System.in.read();  // capturar o inteiro e transformar em CHAR
        dos.writeChars(String.valueOf(tamanho)); // escrever, persistir o char capturado no doc

        ps.print("quantidade: "); // pede para imprimir
        int quantidade = scanner.nextInt(); // captura o int para a variavel
        dos.writeInt(quantidade); // escrever, persistir o int capturado no doc

        ps.print("preco unitario: "); // pede para imprimir
        double preco = scanner.nextDouble(); // captura o double para a variavel
        dos.writeDouble(preco); // escrever, persistir o double capturado no doc

        ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n",
                f.getName(), f.length(), f.getAbsolutePath());

        lerProduto(f.getPath());

        dos.close();
        scanner.close();
        ps.close();
    }

    public static void lerProduto(String caminhoArquivo) throws IOException {
        File f = new File(caminhoArquivo);

        // abrir o arquivo
/*        InputStream is = new FileInputStream(f.getPath());
        DataInputStream dis = new DataInputStream(is);*/
        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));

        // colocar na ordem e com o tipo correspondente
        // ler usando os metodos
        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quantidade = dis.readInt();
        double preco = dis.readDouble();

        // ler linha por linha
        // LEITURA do ARQUIVO .BIN pelo console
        System.out.printf("\nNome..................: %s\n", nome);
        System.out.printf("Quantidade............: %d\n", quantidade);
        System.out.printf("Tamanho...............: %s\n", tamanho);
        System.out.printf("Preço.................: %f\n", preco);
        System.out.println("total do valor das peças: " + quantidade * preco);

        dis.close();
    }


    public static void main(String[] args) throws IOException {
        incluirProduto();
    }

}
