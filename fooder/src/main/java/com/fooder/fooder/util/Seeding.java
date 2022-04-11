package com.fooder.fooder.util;

import com.fooder.fooder.model.Endereco;
import com.fooder.fooder.model.Usuario;
import com.fooder.fooder.repository.EnderecoRepository;
import com.fooder.fooder.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Seeding implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;
    private EnderecoRepository enderecoRepository;

    @Autowired
    public Seeding(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void run(ApplicationArguments args){
        Usuario usuario1 = new Usuario("Anderson Ribeiro", "andersonsiilvar@gmail.com", "591213709");
        usuarioRepository.save(usuario1);
        Endereco endereco1 = new Endereco("Rua Tamandaré", "997", "Liberdade", "São Paulo", "São Paulo", usuario1);
        Endereco endereco2 = new Endereco("Rua João", "123", "Pedrita", "Itaituba", "Pará", usuario1);
        enderecoRepository.save(endereco1);
        enderecoRepository.save(endereco2);
    }
}
