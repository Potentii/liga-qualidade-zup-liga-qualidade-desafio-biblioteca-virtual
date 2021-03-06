package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.factory;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.*;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosLivro;

import java.util.Set;

public abstract class ExemplarFactory {
    
    public static Exemplar buildExemplar(Set<DadosLivro> dadosLivros, DadosExemplar dadosExemplar){

        final int idLivro = dadosExemplar.idLivro;
        
        final DadosLivro dadosLivroEncontrado = dadosLivros
                .parallelStream()
                .filter(dadosLivro -> idLivro == dadosLivro.id)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Nao foi encontrado livro com id: " + idLivro));
        
        final Livro livro = new Livro(dadosLivroEncontrado.id);
        
        return new Exemplar(dadosExemplar.idExemplar, livro, dadosExemplar.tipo);
        
    }
    
}
