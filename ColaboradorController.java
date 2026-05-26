package controller;

import java.util.ArrayList;
import model.Colaborador;

public class ColaboradorController {

    private ArrayList<Colaborador> colaboradores = new ArrayList<>();

    public void cadastrarColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }

    public ArrayList<Colaborador> listarColaboradores() {
        return colaboradores;
    }

    public Colaborador buscarPorNome(String nome) {

        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getNome().equalsIgnoreCase(nome)) {
                return colaborador;
            }
        }

        return null;
    }
}
