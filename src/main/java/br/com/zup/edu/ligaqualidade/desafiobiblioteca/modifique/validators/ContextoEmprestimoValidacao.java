package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.validators;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.Biblioteca;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.PedidoEmprestimo;

public class ContextoEmprestimoValidacao {
    
    private final Biblioteca biblioteca;
    private final PedidoEmprestimo pedidoEmprestimo;


    public ContextoEmprestimoValidacao(Biblioteca biblioteca, PedidoEmprestimo pedidoEmprestimo) {
        this.biblioteca = biblioteca;
        this.pedidoEmprestimo = pedidoEmprestimo;
    }


    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public PedidoEmprestimo getPedidoEmprestimo() {
        return pedidoEmprestimo;
    }
}
