package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.validators;

import static br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario.PESQUISADOR;

public class InformacaoDePeriodoDeEmprestimo implements Validator<ContextoEmprestimoValidacao> {

    /**
     * Valida se o usuario que não é pesquisador informou o periodo
     */
    @Override
    public boolean isValid(ContextoEmprestimoValidacao contextoEmprestimoValidacao) {
        return PESQUISADOR.equals(contextoEmprestimoValidacao.getPedidoEmprestimo().getUsuario().getTipoUsuario()) 
                || contextoEmprestimoValidacao.getPedidoEmprestimo().informouPeriodo();
    }
    
}
