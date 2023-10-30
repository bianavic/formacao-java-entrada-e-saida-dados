package org.edu.fabs.io.IOBytes.IOObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class ExemploIOObject {

    public static void serelializacao() throws IOException {
        Gato gato = new Gato("Gonzales", "amarelo", 7, true, true);

        // referenciar arquivo
        File f = new File("gato");

        // criar arquivo com o objeto serializado
        /*OutputStream os = new FileOutputStream(f.getName());
        ObjectOutputStream oos = new ObjectOutputStream(os);*/

        // decorator
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getName()));

        // usar metodo object para poder serializar o objeto gato e salvar dentro do arquivo
        oos.writeObject(gato);

        PrintStream ps = new PrintStream(System.out);
        ps.printf("arquivo \"%s\" criado com sucesso! tamanho %d bytes", f.getName(), f.length());

        oos.close();
        ps.close();
    }

    public static void desserializacao(String arquivo) throws IOException, ClassNotFoundException {
        File f = new File(arquivo);

/*        InputStream is = new FileInputStream(arquivo);
        ObjectInputStream oos = new ObjectInputStream(is);*/

        // decorator
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        Gato objetoGato = (Gato) ois.readObject();

        // OBS: nao precisa seguir a ordem
        System.out.printf("\nNome..................: %s\n", objetoGato.getNome());
        System.out.printf("Idade............: %d\n", objetoGato.getIdade());
        System.out.printf("Cor...............: %s\n", objetoGato.getCor());
        System.out.printf("Castrado...............: %s\n", objetoGato.isCastrado());
        System.out.printf("Ronrona...............: %s\n", objetoGato.isRonrona());
        System.out.println(objetoGato);

        ois.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serelializacao();
        desserializacao("/home/ribon/Documents/workspace/dio/java/formacao/formacao-java-entrada-e-saida-dados/gato");

    }

}
