package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.validators;

public class ExemplarExiste implements Validator<ContextoEmprestimoValidacao> {

    /**
     * Valida se o exemplar ja foi cadastrado e existe pra ser emprestado
     */
    @Override
    public boolean isValid(ContextoEmprestimoValidacao contextoEmprestimoValidacao) {
        return contextoEmprestimoValidacao.getPedidoEmprestimo().temExemplar();
    }
    
}
