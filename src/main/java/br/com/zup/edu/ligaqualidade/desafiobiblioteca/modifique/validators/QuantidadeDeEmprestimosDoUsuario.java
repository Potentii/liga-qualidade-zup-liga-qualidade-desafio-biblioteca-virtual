package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.validators;

public class QuantidadeDeEmprestimosDoUsuario implements Validator<ContextoEmprestimoValidacao> {
    
    private static final int MAX_EMPRESTIMOS_POR_USUARIO = 5;
    
    @Override
    public boolean isValid(ContextoEmprestimoValidacao contextoEmprestimoValidacao) {
        return contextoEmprestimoValidacao.getPedidoEmprestimo().getUsuario().getEmprestimosRealizados().size() <= MAX_EMPRESTIMOS_POR_USUARIO;
    }
    
}
