package model;

public class Colaborador {

    private String nome;
    private String funcao;

    public Colaborador(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Função: " + funcao;
    }
}
