package com.senai.eventsmanager.service;

import com.senai.eventsmanager.dto.UsuarioDTO;
import com.senai.eventsmanager.entity.Usuario;
import com.senai.eventsmanager.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO findById(Long id) {
        //retorna a entidade usuario
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        //metodo para converter um usuario entity em usuarioDTO
        UsuarioDTO usuarioDTO = toDTO(usuario);
        return usuarioDTO;
    }
    //metodo para salvar um usuario
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = toEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return toDTO(usuario);
    }

    //metodo para atualizar um usuario
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = toEntity(usuarioDTO);
        usuario.setId(id);
        usuario = usuarioRepository.save(usuario);
        return toDTO(usuario);
    }

    //metodo para deletar um usuario
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    //metodo para listar todos os usuarios
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        //criar lista de usuarioDTO
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        //para cada usuario na lista de usuarios, converter para DTO e add
        for (Usuario usuario : usuarios) {
            usuarioDTOs.add(toDTO(usuario));
        }
        return usuarioDTOs;
    }

    public UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO();
        BeanUtils.copyProperties(usuario, dto);
        return dto;
        
    }
    public Usuario toEntity(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario);
        return usuario;
    }
}
