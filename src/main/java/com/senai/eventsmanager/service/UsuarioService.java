package com.senai.eventsmanager.service;

import com.senai.eventsmanager.dto.UsuarioCreateDTO;
import com.senai.eventsmanager.entity.Usuario;
import com.senai.eventsmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioCreateDTO findById(UUID id) {
        //retorna a entidade usuario
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        //metodo para converter um usuario entity em usuarioCreateDTO
        UsuarioCreateDTO usuarioCreateDTO = convertToDTO(usuario);
        return usuarioCreateDTO;
    }
    //metodo para salvar um usuario
    public UsuarioCreateDTO save(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = convertToEntity(usuarioCreateDTO);
        usuario = usuarioRepository.save(usuario);
        return convertToDTO(usuario);
    }

    //metodo para atualizar um usuario
    public UsuarioCreateDTO update(UUID id, UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = convertToEntity(usuarioCreateDTO);
        usuario.setId(id);
        usuario = usuarioRepository.save(usuario);
        return convertToDTO(usuario);
    }

    //metodo para deletar um usuario
    public void deleteById(UUID id) {
        usuarioRepository.deleteById(id);
    }

    //metodo para listar todos os usuarios
    public List<UsuarioCreateDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        //criar lista de usuarioCreateDTO
        List<UsuarioCreateDTO> usuarioCreateDTOs = new ArrayList<>();
        //para cada usuario na lista de usuarios, converter para DTO e add
        for (Usuario usuario : usuarios) {
            usuarioCreateDTOs.add(convertToDTO(usuario));
        }
        return usuarioCreateDTOs;
    }

    public UsuarioCreateDTO convertToDTO(Usuario usuario){
        UsuarioCreateDTO usuarioCreateDTO = new UsuarioCreateDTO();
        //pegar os dados de usuario e passar para o usuarioCreateDTO
        usuarioCreateDTO.setNome(usuario.getNome());
        usuarioCreateDTO.setEmail(usuario.getEmail());
        usuarioCreateDTO.setSenha(usuario.getSenha());
        usuarioCreateDTO.setCpf(usuario.getCpf());
        usuarioCreateDTO.setTelefone(usuario.getTelefone());
        usuarioCreateDTO.setTipo(usuario.getTipo());
        usuarioCreateDTO.setDataNascimento(usuario.getDataNascimento());
        return usuarioCreateDTO;
    }
    public Usuario convertToEntity(UsuarioCreateDTO usuarioCreateDTO){
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioCreateDTO.getNome());
        usuario.setEmail(usuarioCreateDTO.getEmail());
        usuario.setSenha(usuarioCreateDTO.getSenha());
        usuario.setCpf(usuarioCreateDTO.getCpf());
        usuario.setTelefone(usuarioCreateDTO.getTelefone());
        usuario.setTipo(usuarioCreateDTO.getTipo());
        usuario.setDataNascimento(usuarioCreateDTO.getDataNascimento());
        return usuario;

    }
}
