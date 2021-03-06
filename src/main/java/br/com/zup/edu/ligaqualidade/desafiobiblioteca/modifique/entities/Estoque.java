package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities;

import java.util.*;

public class Estoque {
    
    private final Map<Integer, Exemplar> exemplaresPorId = new HashMap<>();


    public Estoque(Set<Exemplar> exemplares) {
        exemplares
                .parallelStream()
                .forEach(exemplar -> this.exemplaresPorId.put(exemplar.getId(), exemplar));
    }


    public Optional<Exemplar> buscarExemplarPorId(int id){
        return exemplaresPorId.containsKey(id)
                ? Optional.of(exemplaresPorId.get(id))
                : Optional.empty();
    }

    public Optional<Exemplar> buscarExemplarPorIdLivro(int idLivro){
        return exemplaresPorId
                .values()
                .stream()
                .filter(exemplar -> exemplar.getLivro().getId() == idLivro)
                .findAny();
    }
}
