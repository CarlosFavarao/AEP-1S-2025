package br.com.GiraBem.controller;

import br.com.GiraBem.model.CidadeModel;
import br.com.GiraBem.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @PostMapping
    public CidadeModel salvarCidade(@RequestBody CidadeModel cidade){
        return cidadeService.salvar(cidade);
    }

    @GetMapping //Provavelmente não será utilizado
    public List<CidadeModel> listarCidades(){
        return cidadeService.listarCidades();
    }

    @GetMapping("/{id}") //Provavelmente não será utilizado
    public Optional<CidadeModel> buscarCidadeId(@PathVariable Long id){
        return cidadeService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CidadeModel atualizarCidade(@RequestBody CidadeModel cidade){
        return cidadeService.atualizar(cidade);
    }

    @DeleteMapping("/{id}")
    public void deletarCidade(@PathVariable Long id){
        cidadeService.deletar(id);
    }

}
