package com.instalacioncamaras.dto;

/**
 * DTO (Data Transfer Object) que representa los datos de un Cliente.
 * Se utiliza para transferir información entre capas sin exponer la entidad directamente.
 */
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String correo;
    private String telefono;

    /**
     * Constructor vacío. Necesario para frameworks que utilizan reflexión.
     */
    public ClienteDTO() {
    }

    /**
     * Constructor que inicializa todos los campos del DTO.
     * @param id Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param correo Correo electrónico del cliente.
     * @param telefono Número de teléfono del cliente.
     */
    public ClienteDTO(Long id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Métodos getter y setter para cada atributo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
