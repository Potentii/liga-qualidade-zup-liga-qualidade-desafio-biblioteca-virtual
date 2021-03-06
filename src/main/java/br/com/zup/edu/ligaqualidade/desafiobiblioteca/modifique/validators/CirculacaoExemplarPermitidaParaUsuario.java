package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.validators;

import static br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar.LIVRE;
import static br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario.PESQUISADOR;

public class CirculacaoExemplarPermitidaParaUsuario implements Validator<ContextoEmprestimoValidacao> {

    /**
     * Valida se o tipo de circulacao do exemplar é permitida para o usuario
     */
    @Override
    public boolean isValid(ContextoEmprestimoValidacao contextoEmprestimoValidacao) {
        return PESQUISADOR.equals(contextoEmprestimoValidacao.getPedidoEmprestimo().getUsuario().getTipoUsuario()) 
                || LIVRE.equals(contextoEmprestimoValidacao.getPedidoEmprestimo().getExemplar().getTipoExemplar());
    }
    
}
