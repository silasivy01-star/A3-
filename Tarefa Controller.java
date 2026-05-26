package controller;

import model.StatusTarefa;
import model.Tarefa;

public class TarefaController {

    public void atualizarStatus(Tarefa tarefa, StatusTarefa status) {
        tarefa.setStatus(status);
    }
}
