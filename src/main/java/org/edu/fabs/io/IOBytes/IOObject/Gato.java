package org.edu.fabs.io.IOBytes.IOObject;

import java.io.Serializable;

public class Gato implements Serializable {
// implementar interface Serializable

    //
    private static final long serialVersionUID = 2L; //abributo que serealiza a classe

    private String nome;
    private String cor;
    private int idade;
    private boolean castrado;

    //transiente aqui serve para deixar esse atributo "invisível" para serealização,
    // ou seja, como o atributo foi adicionado apos uma serializacao, nao sera necessario passar gerar outro serialVersionUID para
    private transient boolean ronrona;

    public Gato() {}

    public Gato(String nome, String cor, int idade, boolean castrado, boolean ronrona) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
        this.castrado = castrado;
        this.ronrona = ronrona;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public boolean isRonrona() {
        return ronrona;
    }

    public void setRonrona(boolean ronrona) {
        this.ronrona = ronrona;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", idade=" + idade +
                ", castrado=" + castrado +
                ", ronrona=" + ronrona +
                '}';
    }

}
