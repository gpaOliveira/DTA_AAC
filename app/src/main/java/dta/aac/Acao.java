package dta.aac;

public class Acao {

    public Acao() {

    }

    public Acao(int codigoImagem, String nome) {
        this.codigoImagem = codigoImagem;
        this.nome = nome;
    }

    private int codigoImagem;
    private String nome;

    public int getCodigoImagem() {
        return codigoImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoImagem(int codigoImagem) {
        this.codigoImagem = codigoImagem;
    }


}
