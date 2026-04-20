package com.senai.backend.controle_frequencia.controllers;

import com.senai.backend.controle_frequencia.ControleFrequenciaApplication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.controle_frequencia.models.Usuario;
import com.senai.backend.controle_frequencia.services.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final ControleFrequenciaApplication controleFrequenciaApplication;
    @Autowired
    private UsuarioService usuarioService;

    UsuarioController(ControleFrequenciaApplication controleFrequenciaApplication) {
        this.controleFrequenciaApplication = controleFrequenciaApplication;
    }

    @GetMapping("/contar-usuario")
    public Long contarUsuarios(){
        return usuarioService.contarUsuario();

    }
    
    @GetMapping("/buscar-usuario/{id}")
    public Usuario buscUsuario(@PathVariable Integer id){
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping("/listar-usuarios")
    public List<Usuario> listarUsuario(){
        return usuarioService.listUsuarios();
    }

    @DeleteMapping("/deletar-usario/{id}")
    public String deletarUsuario(@PathVariable Integer id){
        if (usuarioService.deletarUsuario(id)) {
            return "Usuario deletado com sucesso";
        }
        return "Falha ao deletar usario";
    }

    @PutMapping("/salvar-usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PutMapping("/atualizar-usuario")
    public String atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        if (usuarioService.atualizaUsuario(id, usuario)!= null) {
            return "Usuario atualizado com sucesso";
        }
        return "Falha ao atualizar o usuario";
    }
    

    }









