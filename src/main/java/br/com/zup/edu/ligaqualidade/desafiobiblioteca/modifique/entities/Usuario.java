package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    private final int id;
    private final TipoUsuario tipoUsuario;
    private final List<EmprestimoRealizado> emprestimosRealizados = new ArrayList<>();


    public Usuario(int id, TipoUsuario tipoUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }
    
    
    public EmprestimoRealizado addEprestimoRealizado(PedidoEmprestimo pedidoEmprestimo){
        final EmprestimoRealizado emprestimoRealizado = new EmprestimoRealizado(this, pedidoEmprestimo);
        emprestimosRealizados.add(emprestimoRealizado);
        return emprestimoRealizado;
    }


    public int getId() {
        return id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public List<EmprestimoRealizado> getEmprestimosRealizados() {
        return emprestimosRealizados;
    }
}
