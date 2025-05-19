package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {

    private List<Tarefa> tarefas;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    // adicionar uma nova tarefa
    public void adicionarTarefa(String titulo, String descricao, String prioridade, boolean concluida) {
        Tarefa tarefa = new Tarefa(titulo, descricao, prioridade, concluida);
        tarefas.add(tarefa);
    }

    // listar todas as tarefas 
    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }

    // buscar tarefa por id
    public Tarefa buscarTarefaPorId(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null; // se não encontrar
    }

    // atualizar uma tarefa existente
    public boolean atualizarTarefa(int id, String titulo, String descricao, String prioridade, boolean concluida) {
        Tarefa tarefa = buscarTarefaPorId(id);
        if (tarefa != null) {
            tarefa.setTitulo(titulo);
            tarefa.setDescricao(descricao);
            tarefa.setPrioridade(prioridade);
            tarefa.setConcluida(concluida);

            return true;
        }
        return false; // se não for encontrada
    }

    // remover uma tarefa
    public boolean removerTarefa(int id) {
        Tarefa tarefa = buscarTarefaPorId(id);
        if (tarefa != null) {
            tarefas.remove(tarefa);
            return true;
        }
        return false; // se não for encontrada
    }   
}

