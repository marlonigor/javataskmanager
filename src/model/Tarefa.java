
package model;


public class Tarefa {
    private final int id;
    private static int contadorId = 1;
    private String titulo;
    private String descricao;
    private String prioridade;
    private boolean concluida;
    
    //Método Construtor 
    public Tarefa (String titulo, String descricao, String prioridade, boolean concluida){
        this.id = contadorId++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String getPrioridade(){
        return prioridade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return "Tarefa{" + 
                "id=" + id + 
                ", titulo=" + titulo + '\'' +
                ", descricao=" + descricao + '\'' +
                ", prioridade=" + prioridade + '\'' +
                ", concluida=" + concluida + '}';
    }
    
    
    
    
}
