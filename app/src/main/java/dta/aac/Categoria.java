package dta.aac;

import java.util.ArrayList;

public class Categoria {
    private String nome;
    private ArrayList<Acao> acoes;

    public Categoria() {
    }

    public Categoria(String nome, ArrayList<Acao> acoes) {
        this.nome = nome;
        this.acoes = acoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Acao> getAcoes() {
        return acoes;
    }

    public String getNome() {
        return nome;
    }

    public void setAcoes(ArrayList<Acao> acoes) {
        this.acoes = acoes;
    }


}
