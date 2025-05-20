package br.com.GiraBem.controller;

import br.com.GiraBem.model.TipoDoacaoModel;
import br.com.GiraBem.service.TipoDoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipos-doacao")
public class TipoDoacaoController {
    @Autowired
    private TipoDoacaoService tipoDoacaoService;

    @PostMapping
    public ResponseEntity<TipoDoacaoModel> salvar(@RequestBody TipoDoacaoModel tipoDoacao){
        TipoDoacaoModel salvo = tipoDoacaoService.salvarTipoDoacao(tipoDoacao);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping
    public List<TipoDoacaoModel> listarTipos(){
        return tipoDoacaoService.listarTiposDoacao();
    }

    @GetMapping("/{id}") //provavelmente não será utilizado
    public Optional<TipoDoacaoModel> buscarTipoId(Long id){
        return tipoDoacaoService.buscarTiposDoacaoPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDoacaoModel> atualizar(@PathVariable Long id, @RequestBody TipoDoacaoModel tipoDoacao){
        return tipoDoacaoService.atualizarTipoDoacao(id, tipoDoacao).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (tipoDoacaoService.deletar(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
