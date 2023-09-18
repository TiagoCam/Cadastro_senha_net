package br.com.cadastros.service;

import br.com.cadastros.model.entity.Cadastro;
import br.com.cadastros.model.repository.CadastroRepository;
import br.com.cadastros.rest.exception.CadastroCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;

    public Cadastro salvar(Cadastro cadastro) {
        return repository.save(cadastro);
    }

}
