package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.factory;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities.*;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BibliotecaFactory {
    
    public static Biblioteca buildBiblioteca(Set<Exemplar> exemplares, Set<DadosUsuario> dadosUsuarios, LocalDate dataExpiracaoGeral){
        
        final Set<Usuario> usuarios = dadosUsuarios
                .parallelStream()
                .map(dadosUsuario -> new Usuario(dadosUsuario.idUsuario, dadosUsuario.padrao))
                .collect(Collectors.toSet());
        
        final Estoque estoque = new Estoque(exemplares);
        final CatalogoUsuarios catalogoUsuarios = new CatalogoUsuarios(usuarios);
        
        return new Biblioteca(estoque, catalogoUsuarios, exemplares, dataExpiracaoGeral);
    }
    
}
