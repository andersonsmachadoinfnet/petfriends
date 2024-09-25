package br.anderson.infnet.petfriends_almoxarifado.controller;

import br.anderson.infnet.petfriends_almoxarifado.model.domain.Estoque;
import br.anderson.infnet.petfriends_almoxarifado.service.EstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class EstoqueController {
    @Autowired
    private EstoqueService _rps;

    @GetMapping(value = "")
    @Operation(summary = "Lista todos os estoques.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de estoque",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Estoque.class))}
            )
    })
    public Iterable<Estoque> getPedidos() {
        return _rps.buscarTodos();
    }

    @Operation(summary = "Obtem dados de um estoque.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estoque encontrado na base",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Estoque.class))}
            )
    })
    @GetMapping(value = "/{id}")
    public Optional<Estoque> getPorId(Integer id) {
        return _rps.buscarPorId(id);
    }

    @PostMapping("")
    @Operation(summary = "Cadastra um novo estoque")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estoque",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Estoque.class))}
            )
    })
    Estoque novoPedido(@RequestBody Estoque estoque) {
        return _rps.salvar(estoque);
    }
}
