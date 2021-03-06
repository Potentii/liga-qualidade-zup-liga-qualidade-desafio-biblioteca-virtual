package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar;

public class Exemplar {
    
    private final int id;
    private final Livro livro;
    private final TipoExemplar tipoExemplar;


    public Exemplar(int id, Livro livro, TipoExemplar tipoExemplar) {
        this.id = id;
        this.livro = livro;
        this.tipoExemplar = tipoExemplar;
    }


    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public TipoExemplar getTipoExemplar() {
        return tipoExemplar;
    }
    
}
