package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities;

import java.time.LocalDate;
import java.util.Set;

public class Biblioteca {
    
    private final Estoque estoque;
    private final CatalogoUsuarios catalogoUsuarios;
    private final Set<Exemplar> todosExemplares;
    private final LocalDate dataExpiracaoGeral;


    public Biblioteca(Estoque estoque, CatalogoUsuarios catalogoUsuarios, Set<Exemplar> todosExemplares, LocalDate dataExpiracaoGeral) {
        this.estoque = estoque;
        this.catalogoUsuarios = catalogoUsuarios;
        this.todosExemplares = todosExemplares;
        this.dataExpiracaoGeral = dataExpiracaoGeral;
    }


    public Estoque getEstoque() {
        return estoque;
    }

    public CatalogoUsuarios getCatalogoUsuarios() {
        return catalogoUsuarios;
    }

    public Set<Exemplar> getTodosExemplares() {
        return todosExemplares;
    }

    public LocalDate getDataExpiracaoGeral() {
        return dataExpiracaoGeral;
    }
}
