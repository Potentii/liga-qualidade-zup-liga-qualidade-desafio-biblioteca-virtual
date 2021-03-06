package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosDevolucao;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.Biblioteca;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.Exemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.PedidoEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.factory.BibliotecaFactory;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.factory.ExemplarFactory;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.factory.PedidoEmprestimoFactory;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.validators.*;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosLivro;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solucao {

	/**
	 * Você precisa implementar o código para executar o fluxo
	 * o completo de empréstimo e devoluções a partir dos dados
	 * que chegam como argumento. 
	 * 
	 * Caso você queira pode adicionar coisas nas classes que já existem,
	 * mas não pode alterar nada.
	 */
	
	/**
	 * 
	 * @param livros dados necessários dos livros
	 * @param exemplares tipos de exemplares para cada livro
	 * @param usuarios tipos de usuarios
	 * @param emprestimos informações de pedidos de empréstimos
	 * @param devolucoes informações de devoluções, caso exista. 
	 * @param dataExpiracao aqui é a data que deve ser utilizada para verificar expiração
	 * @return
	 */
	public static Set<EmprestimoConcedido> executa(
			Set<DadosLivro> livros,
			Set<DadosExemplar> exemplares,
			Set<DadosUsuario> usuarios, 
			Set<DadosEmprestimo> emprestimos,
			Set<DadosDevolucao> devolucoes, 
			LocalDate dataExpiracao) {		
		
		// *Preparando as entidades:
		final Set<Exemplar> exemplaresCadastrados = exemplares
				.parallelStream()
				.map(dadosExemplar -> ExemplarFactory.buildExemplar(livros, dadosExemplar))
				.collect(Collectors.toSet());
		
		final Biblioteca biblioteca = BibliotecaFactory.buildBiblioteca(exemplaresCadastrados, usuarios, dataExpiracao);
		
		
		// *Processando os emprestimos:
		return emprestimos
				.stream()
				
				// *Contruindo o pedido de emprestimo:
				.map(dadosEmprestimo -> PedidoEmprestimoFactory.buildPedidoEmprestimo(dadosEmprestimo, biblioteca))
				
				// *Preparando o contexto de validação pra esse emprestimo:
				.map(pedidoEmprestimo -> new ContextoEmprestimoValidacao(biblioteca, pedidoEmprestimo))
				
				
				// *Realizando as validações necessárias:
				.filter(new ExemplarExiste()::isValid)
				.filter(new PeriodoMaximoEmprestimo()::isValid)
				.filter(new QuantidadeDeEmprestimosDoUsuario()::isValid)
				.filter(new InformacaoDePeriodoDeEmprestimo()::isValid)
				.filter(new CirculacaoExemplarPermitidaParaUsuario()::isValid)
		
				
				// *Aqui significa que o emprestimo passou por todas as validações:
				.map(contexto -> {
					// *Pegando o pedido dentro do contexto:
					final PedidoEmprestimo pedidoEmprestimo = contexto.getPedidoEmprestimo();

					// *Adicionando o emprestimo na lista de emprestimos do usuario:
					pedidoEmprestimo.getUsuario().addEprestimoRealizado(pedidoEmprestimo);
					
					return pedidoEmprestimo;
				})
				
				
				// *Mapeando o retorno no type experado:
				.map(emprestimo -> 
						new EmprestimoConcedido(
								emprestimo.getUsuario().getId(),
								emprestimo.getExemplar().getId(),
								LocalDate.now().plusDays(emprestimo.getPeriodo())
						)
				)
				.collect(Collectors.toSet());
	}
	
	

	private static void registrarEmprestimo(Set<EmprestimoConcedido> emprestimosConcedidos, DadosUsuario usuario, DadosExemplar exemplar, LocalDate dataDevolucaoEstimada, Map<Integer, Integer> countEmprestimosPadrao) {
		EmprestimoConcedido emprestimoConcedido = new EmprestimoConcedido(usuario.idUsuario, exemplar.idExemplar, dataDevolucaoEstimada);
		emprestimosConcedidos.add(emprestimoConcedido);
		if (usuario.padrao == TipoUsuario.PADRAO) {
			countEmprestimosPadrao.putIfAbsent(usuario.idUsuario, 0);
			countEmprestimosPadrao.put(usuario.idUsuario, countEmprestimosPadrao.get(usuario.idUsuario) + 1);
		}
	}

	private static boolean livroEmprestavelEDevolvidoAntesDaDataConsiderada(LocalDate dataExpiracao, DadosUsuario usuario, DadosExemplar exemplar, LocalDate dataDevolucao, Map<Integer, Integer> countEmprestimosPadrao) {
		if (usuario.padrao == TipoUsuario.PADRAO) {
			return ValidadorUsuario.validarEmprestimoDeUsuarioPadrao(dataExpiracao, usuario, exemplar, dataDevolucao, countEmprestimosPadrao);
		} else { //Pesquisador
			return ValidadorUsuario.validarEmprestimoDePesquisador(dataExpiracao, dataDevolucao);
		}
	}



}
