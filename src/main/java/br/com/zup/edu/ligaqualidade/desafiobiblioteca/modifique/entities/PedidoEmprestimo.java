package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities;

public class PedidoEmprestimo {
    
    private final int id;
    private final Usuario usuario;
    private final Exemplar exemplar;
    private final int periodo;


    public PedidoEmprestimo(int id, Usuario usuario, Exemplar exemplar, int periodo) {
        this.id = id;
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.periodo = periodo;
    }

    
    public boolean informouPeriodo(){
        return periodo > 0;
    }
    
    public boolean temExemplar(){
        return exemplar != null;
    }
    

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public int getPeriodo() {
        return periodo;
    }
}
