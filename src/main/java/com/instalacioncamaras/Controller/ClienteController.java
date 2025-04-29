package com.instalacioncamaras.controller;

import com.instalacioncamaras.dto.ClienteDTO;
import com.instalacioncamaras.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar clientes.
 * Expone endpoints para operaciones CRUD sobre los clientes.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Obtiene la lista de todos los clientes.
     * @return Lista de clientes en formato DTO.
     */
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    /**
     * Obtiene un cliente por su ID.
     * @param id ID del cliente a buscar.
     * @return Cliente encontrado o error 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        Optional<ClienteDTO> cliente = clienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuevo cliente.
     * @param clienteDTO Datos del cliente a crear.
     * @return Cliente creado con código HTTP 201.
     */
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO nuevoCliente = clienteService.saveCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    /**
     * Actualiza un cliente existente.
     * @param id ID del cliente a actualizar.
     * @param clienteDTO Datos actualizados del cliente.
     * @return Cliente actualizado o error 404 si no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Optional<ClienteDTO> clienteExistente = clienteService.getClienteById(id);
        if (clienteExistente.isPresent()) {
            clienteDTO.setId(id);
            ClienteDTO clienteActualizado = clienteService.saveCliente(clienteDTO);
            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un cliente por su ID.
     * @param id ID del cliente a eliminar.
     * @return Respuesta vacía con código 204 si se eliminó o error 404 si no existe.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        Optional<ClienteDTO> clienteExistente = clienteService.getClienteById(id);
        if (clienteExistente.isPresent()) {
            clienteService.deleteCliente(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


