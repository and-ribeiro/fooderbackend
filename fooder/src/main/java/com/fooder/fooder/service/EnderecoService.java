package com.fooder.fooder.service;

import com.fooder.fooder.model.Endereco;
import com.fooder.fooder.model.Usuario;
import com.fooder.fooder.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco){return enderecoRepository.save(endereco);}
    public List<Endereco> buscarTodosOsEndereco(){return enderecoRepository.findAll();}
    public Optional<Endereco> buscarEnderecoPorId(Integer id){return enderecoRepository.findById(id);}
    public Endereco atualizarEndereco(Endereco endereco){return enderecoRepository.save(endereco);}
    public void excluirEndereco(Integer id){enderecoRepository.deleteById(id);}


}
