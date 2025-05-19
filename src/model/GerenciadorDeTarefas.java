package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorDeTarefas {

    private List<Tarefa> tarefas;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    // adicionar uma nova tarefa
    public void adicionarTarefa(String titulo, String descricao, String prioridade, LocalDate data, boolean concluida) {
        Tarefa tarefa = new Tarefa(titulo, descricao, prioridade, data, concluida);
        tarefas.add(tarefa);
    }

    // listar todas as tarefas 
    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }
    
    // Filtro por dia
    public List<Tarefa> listarTarefasPorDia(LocalDate dia) {
        return tarefas.stream()
                .filter(t -> t.getData().isEqual(dia))
                .collect(Collectors.toList());
    }

    // Filtro para período de 7 dias
    public List<Tarefa> listarTarefasPorSemana(LocalDate dataInicio) {
        LocalDate dataFim = dataInicio.plusDays(6); // 7 dias incluindo o inicial
        return tarefas.stream()
                .filter(t -> !t.getData().isBefore(dataInicio) && !t.getData().isAfter(dataFim))
                .collect(Collectors.toList());
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
    public boolean atualizarTarefa(int id, String titulo, String descricao, String prioridade, LocalDate data, boolean concluida) {
        Tarefa tarefa = buscarTarefaPorId(id);
        if (tarefa != null) {
            tarefa.setTitulo(titulo);
            tarefa.setDescricao(descricao);
            tarefa.setPrioridade(prioridade);
            tarefa.setData(data);
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

