package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.factory;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.Biblioteca;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.Exemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.PedidoEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.Usuario;

public abstract class PedidoEmprestimoFactory {
    
    public static PedidoEmprestimo buildPedidoEmprestimo(DadosEmprestimo dadosEmprestimo, Biblioteca biblioteca){
        // *Buscando o usuario que fez o emprestimo:
        final Usuario usuario = biblioteca
                .getCatalogoUsuarios()
                .buscarUsuarioPorId(dadosEmprestimo.idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario nao encontrado com id: " + dadosEmprestimo.idUsuario));
        
        // *Buscando o exemplar do emprestimo:
        final Exemplar exemplar = biblioteca
                .getEstoque()
                .buscarExemplarPorIdLivro(dadosEmprestimo.idLivro)
                .orElse(null);

        return new PedidoEmprestimo(dadosEmprestimo.idPedido, usuario, exemplar, dadosEmprestimo.tempo);
    }
    
}
