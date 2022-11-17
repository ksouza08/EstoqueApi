package com.estoqueapi.EstoqueApi.Servicos;

import com.estoqueapi.EstoqueApi.Entidades.Usuarios;
import com.estoqueapi.EstoqueApi.Repositorios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    private boolean usuarioExiste(Usuarios u) {
        return usuariosRepository.existsByEmail(u.getEmail());
    }

    public Usuarios cadastrar(Usuarios u) {
        return usuariosRepository.save(u);
    }

    public List<Usuarios> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios buscarUsuarioById(long idUsuario) {
        Usuarios u = usuariosRepository.findById(idUsuario).orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));
        return u;
    }
}
