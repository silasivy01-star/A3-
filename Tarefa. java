package model;

public class Tarefa {

    private String titulo;
    private String descricao;
    private String prazo;
    private StatusTarefa status;
    private Colaborador responsavel;

    public Tarefa(String titulo, String descricao, String prazo, Colaborador responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.responsavel = responsavel;
        this.status = StatusTarefa.PENDENTE;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Colaborador getResponsavel() {
        return responsavel;
    }

    @Override
    public String toString() {
        return "Tarefa: " + titulo +
                " | Descrição: " + descricao +
                " | Prazo: " + prazo +
                " | Status: " + status +
                " | Responsável: " + responsavel.getNome();
    }
}
