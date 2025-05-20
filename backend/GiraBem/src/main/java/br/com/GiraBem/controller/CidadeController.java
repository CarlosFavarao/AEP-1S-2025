package br.com.GiraBem.controller;

import br.com.GiraBem.model.CidadeModel;
import br.com.GiraBem.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<CidadeModel> salvar(@RequestBody CidadeModel cidade){
        CidadeModel salvo = cidadeService.salvar(cidade);
        return ResponseEntity.status(201).body(salvo);
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
    public ResponseEntity<CidadeModel> atualizar(@PathVariable Long id, @RequestBody CidadeModel dados) {
        return cidadeService.atualizar(id, dados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCidade(@PathVariable Long id){
        if (cidadeService.deletar(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
