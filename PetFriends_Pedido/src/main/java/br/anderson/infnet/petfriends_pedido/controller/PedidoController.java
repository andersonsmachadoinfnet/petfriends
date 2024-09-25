package br.anderson.infnet.petfriends_pedido.controller;

import br.anderson.infnet.petfriends_pedido.model.domain.Pedido;
import br.anderson.infnet.petfriends_pedido.service.PedidoService;
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
public class PedidoController {
    @Autowired
    private PedidoService _rps;

    @GetMapping(value = "")
    @Operation(summary = "Lista todos os pedidos cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))}
            )
    })
    public Iterable<Pedido> getPedidos() {
        return _rps.buscarTodos();
    }

    @Operation(summary = "Obtem dados do pedido requerido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado na base",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))}
            )
    })
    @GetMapping(value = "/{id}")
    public Optional<Pedido> getPedidoPorId(Integer id) {
        return _rps.buscarPorId(id);
    }

    @PostMapping("")
    @Operation(summary = "Cadastra um novo pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))}
            )
    })
    Pedido novoPedido(@RequestBody Pedido pedido) {
        return _rps.salvar(pedido);
    }
}