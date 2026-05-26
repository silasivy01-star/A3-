package view;

import controller.ColaboradorController;
import controller.ProjetoController;
import controller.TarefaController;
import java.util.Scanner;
import model.Colaborador;
import model.Projeto;
import model.StatusTarefa;
import model.Tarefa;

public class MenuView {

    private Scanner scanner = new Scanner(System.in);

    private ProjetoController projetoController = new ProjetoController();
    private ColaboradorController colaboradorController = new ColaboradorController();
    private TarefaController tarefaController = new TarefaController();

    public void iniciarSistema() {

        int opcao;

        do {
            System.out.println("\n===== WORK HUB =====");
            System.out.println("1 - Cadastrar Projeto");
            System.out.println("2 - Cadastrar Colaborador");
            System.out.println("3 - Criar Tarefa");
            System.out.println("4 - Listar Projetos");
            System.out.println("5 - Listar Colaboradores");
            System.out.println("6 - Atualizar Status da Tarefa");
            System.out.println("7 - Relatório de Projetos");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProjeto();
                    break;

                case 2:
                    cadastrarColaborador();
                    break;

                case 3:
                    criarTarefa();
                    break;

                case 4:
                    listarProjetos();
                    break;

                case 5:
                    listarColaboradores();
                    break;

                case 6:
                    atualizarStatus();
                    break;

                case 7:
                    gerarRelatorio();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    // ================= PROJETO =================

    private void cadastrarProjeto() {

        System.out.print("Nome do projeto: ");
        String nome = scanner.nextLine();

        System.out.print("Prazo do projeto: ");
        String prazo = scanner.nextLine();

        Projeto projeto = new Projeto(nome, prazo);

        projetoController.cadastrarProjeto(projeto);

        System.out.println("Projeto cadastrado com sucesso!");
    }

    private void listarProjetos() {

        for (Projeto projeto : projetoController.listarProjetos()) {

            System.out.println(projeto);

            for (Tarefa tarefa : projeto.getTarefas()) {
                System.out.println("   -> " + tarefa);
            }
        }
    }

    // ================= COLABORADOR =================

    private void cadastrarColaborador() {

        System.out.print("Nome do colaborador: ");
        String nome = scanner.nextLine();

        System.out.print("Função: ");
        String funcao = scanner.nextLine();

        Colaborador colaborador = new Colaborador(nome, funcao);

        colaboradorController.cadastrarColaborador(colaborador);

        System.out.println("Colaborador cadastrado com sucesso!");
    }

    private void listarColaboradores() {

        for (Colaborador colaborador : colaboradorController.listarColaboradores()) {
            System.out.println(colaborador);
        }
    }

    // ================= TAREFA =================

    private void criarTarefa() {

        System.out.print("Nome do projeto: ");
        String nomeProjeto = scanner.nextLine();

        Projeto projeto = projetoController.buscarProjeto(nomeProjeto);

        if (projeto == null) {
            System.out.println("Projeto não encontrado.");
            return;
        }

        System.out.print("Título da tarefa: ");
        String titulo = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Prazo da tarefa: ");
        String prazo = scanner.nextLine();

        System.out.print("Responsável: ");
        String nomeResponsavel = scanner.nextLine();

        Colaborador responsavel = colaboradorController.buscarPorNome(nomeResponsavel);

        if (responsavel == null) {
            System.out.println("Colaborador não encontrado.");
            return;
        }

        Tarefa tarefa = new Tarefa(titulo, descricao, prazo, responsavel);

        projeto.adicionarTarefa(tarefa);

        System.out.println("Tarefa criada com sucesso!");
    }

    private void atualizarStatus() {

        System.out.print("Nome do projeto: ");
        String nomeProjeto = scanner.nextLine();

        Projeto projeto = projetoController.buscarProjeto(nomeProjeto);

        if (projeto == null) {
            System.out.println("Projeto não encontrado.");
            return;
        }

        System.out.print("Título da tarefa: ");
        String titulo = scanner.nextLine();

        for (Tarefa tarefa : projeto.getTarefas()) {

            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {

                System.out.println("1 - PENDENTE");
                System.out.println("2 - EM ANDAMENTO");
                System.out.println("3 - CONCLUÍDA");

                int escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        tarefaController.atualizarStatus(tarefa, StatusTarefa.PENDENTE);
                        break;

                    case 2:
                        tarefaController.atualizarStatus(tarefa, StatusTarefa.EM_ANDAMENTO);
                        break;

                    case 3:
                        tarefaController.atualizarStatus(tarefa, StatusTarefa.CONCLUIDA);
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        return;
                }

                System.out.println("Status atualizado com sucesso!");
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }

    // ================= RELATÓRIOS =================

    private void gerarRelatorio() {

        System.out.println("\n===== RELATÓRIO =====");

        for (Projeto projeto : projetoController.listarProjetos()) {

            System.out.println(projeto);

            int pendentes = 0;
            int andamento = 0;
            int concluidas = 0;

            for (Tarefa tarefa : projeto.getTarefas()) {

                switch (tarefa.getStatus()) {
                    case PENDENTE:
                        pendentes++;
                        break;

                    case EM_ANDAMENTO:
                        andamento++;
                        break;

                    case CONCLUIDA:
                        concluidas++;
                        break;
                }
            }

            System.out.println("Pendentes: " + pendentes);
            System.out.println("Em andamento: " + andamento);
            System.out.println("Concluídas: " + concluidas);
            System.out.println("-----------------------------");
        }
    }
}
