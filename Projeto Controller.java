package controller;

import java.util.ArrayList;
import model.Projeto;

public class ProjetoController {

    private ArrayList<Projeto> projetos = new ArrayList<>();

    public void cadastrarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    public ArrayList<Projeto> listarProjetos() {
        return projetos;
    }

    public Projeto buscarProjeto(String nome) {

        for (Projeto projeto : projetos) {
            if (projeto.getNome().equalsIgnoreCase(nome)) {
                return projeto;
            }
        }

        return null;
    }
}
