package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.validators;

public class PeriodoMaximoEmprestimo implements Validator<ContextoEmprestimoValidacao> {
    
    private static final int PERIODO_MAXIMO_EMPRESTIMO = 60;
    
    @Override
    public boolean isValid(ContextoEmprestimoValidacao contextoEmprestimoValidacao) {        
        return contextoEmprestimoValidacao.getPedidoEmprestimo().getPeriodo() <= PERIODO_MAXIMO_EMPRESTIMO;
    }
    
}
