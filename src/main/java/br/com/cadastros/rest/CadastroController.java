package br.com.cadastros.rest;

import br.com.cadastros.model.entity.Cadastro;
import br.com.cadastros.model.repository.CadastroRepository;
import br.com.cadastros.rest.exception.CadastroCadastradoException;
import br.com.cadastros.service.CadastroService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cadastros")
@CrossOrigin("http://localhost:4200")
public class CadastroController {

    private final CadastroRepository repository;
    private final CadastroService service;


    @Autowired
    public CadastroController(CadastroRepository repository, CadastroService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Cadastro> obterTodos() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cadastro salvar(@RequestBody @Valid Cadastro cadastro) {
        try {
            return service.salvar(cadastro);
        } catch (CadastroCadastradoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{id}")
    public Cadastro acharPorId(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repository.findById(id).
                map(cadastro -> {
                    repository.delete(cadastro);
                    return Void.TYPE;
                }).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Cadastro cadastroAtualizado) {
        repository.findById(id).
                map(cadastro -> {
                    cadastro.setNomeGerente(cadastroAtualizado.getNomeGerente());
                    cadastro.setNomeColaborador(cadastroAtualizado.getNomeColaborador());
                    cadastro.setSenha(cadastroAtualizado.getSenha());
                    return repository.save(cadastro);
                }).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrado"));
    }
}
