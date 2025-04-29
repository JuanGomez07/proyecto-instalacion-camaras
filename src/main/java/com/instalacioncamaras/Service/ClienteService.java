package com.instalacioncamaras.service;

import com.instalacioncamaras.dto.ClienteDTO;
import com.instalacioncamaras.model.Cliente;
import com.instalacioncamaras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los clientes.
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Obtiene todos los clientes y los convierte a DTO.
     * @return Lista de ClienteDTO.
     */
    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un cliente por su ID.
     * @param id ID del cliente.
     * @return ClienteDTO si existe, de lo contrario un Optional vacío.
     */
    public Optional<ClienteDTO> getClienteById(Long id) {
        return clienteRepository.findById(id)
                .map(this::convertToDTO);
    }

    /**
     * Guarda un nuevo cliente o actualiza uno existente.
     * @param clienteDTO Datos del cliente a guardar.
     * @return ClienteDTO guardado.
     */
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
        Cliente cliente = convertToEntity(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return convertToDTO(clienteGuardado);
    }

    /**
     * Elimina un cliente por su ID.
     * @param id ID del cliente a eliminar.
     */
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    /**
     * Resetea la información de un cliente (deja campos en blanco).
     * @param id ID del cliente a resetear.
     */
    public void resetCliente(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNombre("");
            cliente.setCorreo("");
            cliente.setTelefono("");
            clienteRepository.save(cliente);
        }
    }

    /**
     * Convierte una entidad Cliente a un ClienteDTO.
     * @param cliente Entidad Cliente.
     * @return ClienteDTO correspondiente.
     */
    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setCorreo(cliente.getCorreo());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }

    /**
     * Convierte un ClienteDTO a una entidad Cliente.
     * @param dto Objeto ClienteDTO.
     * @return Entidad Cliente correspondiente.
     */
    private Cliente convertToEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }
}


