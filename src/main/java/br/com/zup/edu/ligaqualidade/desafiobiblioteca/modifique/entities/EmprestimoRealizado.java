package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities;

public class EmprestimoRealizado {
    
    private final Usuario usuario;
    private final PedidoEmprestimo pedidoEmprestimo;

    
    public EmprestimoRealizado(Usuario usuario, PedidoEmprestimo pedidoEmprestimo) {
        this.usuario = usuario;
        this.pedidoEmprestimo = pedidoEmprestimo;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public PedidoEmprestimo getPedidoEmprestimo() {
        return pedidoEmprestimo;
    }
}
