package br.com.GiraBem.controller;

import br.com.GiraBem.DTO.PontoColetaResponseDTO;
import br.com.GiraBem.model.CidadeModel;
import br.com.GiraBem.model.PontoColetaModel;
import br.com.GiraBem.service.PontoColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pontos-coleta")
public class PontoColetaController {
    @Autowired
    private PontoColetaService pontoColetaService;

    //CRUD e Busca Padrão

    @PostMapping
    public ResponseEntity<PontoColetaModel> salvar(@RequestBody PontoColetaModel pontoColeta){
        PontoColetaModel salvo = pontoColetaService.salvarPonto(pontoColeta);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping
    public List<PontoColetaModel> listarTodos(){
        return pontoColetaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoColetaModel> buscarPorId(@PathVariable Long id){
        Optional<PontoColetaModel> ponto = pontoColetaService.buscarPontoPorId(id);
        return ponto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoColetaModel> atualizar(@PathVariable Long id, @RequestBody PontoColetaModel ponto){
        Optional<PontoColetaModel> atualizado = pontoColetaService.atualizar(id, ponto);
        return atualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (pontoColetaService.deletarPonto(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Busca e Endpoints personalizada

    @GetMapping("/filtrar-semDTO/{tipoDoacaoId}/{cidadeId}") //Para testes. Não irá para o usuário
    public List<PontoColetaModel> filtrarPorTipoECidade(@RequestParam Long tipoDoacaoId, @RequestParam Long cidadeId){
        return pontoColetaService.filtrarPorTipoECidade(tipoDoacaoId, cidadeId);
    }

    @GetMapping("/filtrar") //Já com informações filtradas por aqui!
    public List<PontoColetaResponseDTO> filtrarDTOporTipoECidade(@RequestParam Long tipoDoacaoId, @RequestParam Long cidadeId) {
        return pontoColetaService.filtrarDTOporTipoECidade(tipoDoacaoId, cidadeId);
    }

    @GetMapping("/cidades-disponiveis")
    public List<CidadeModel> listarCidadesPorTipo(@RequestParam Long tipoDoacaoId){
        return pontoColetaService.listarCidadesPorTipo(tipoDoacaoId);
    }

}
