package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CatalogoUsuarios {
    
    private final Map<Integer, Usuario> usuariosPorId = new HashMap<>();

    
    public CatalogoUsuarios(Set<Usuario> usuarios) {
        usuarios
                .parallelStream()
                .forEach(usuario -> this.usuariosPorId.put(usuario.getId(), usuario));
    }
    
    
    public Optional<Usuario> buscarUsuarioPorId(int id){
        return usuariosPorId.containsKey(id) 
                ? Optional.of(usuariosPorId.get(id)) 
                : Optional.empty();
    }
}
