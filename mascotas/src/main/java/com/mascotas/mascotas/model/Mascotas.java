package com.mascotas.mascotas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "ProductosMascotas")
public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "No puede dejar TipoProducto vacio")
    @NotBlank(message = "No puede dejar TipoProducto vacio")
    @Column(name = "TipoProducto")
    private String TipoProducto;

    @Size(min = 6, max = 50, message = "El destinatario debe tener entre 3 y 50 caracteres")
    @NotNull(message = "El destinatario no puede ser nulo")
    @NotBlank(message = "No puede dejar TipoProducto vacio")
    @Column(name = "destinatario")
    private String destinatario;

    @NotNull(message = "La dirección de destino no puede ser nula")
    @NotBlank(message = "No puede dejar TipoProducto vacio")
    @Column(name = "direccionDestino")
    private String direcccionDestino;

    @NotNull(message = "La fechaEnvio no puede ser nulo")
    @Column(name = "fechaEnvio")
    private LocalDateTime fechaEnvio;

    @NotNull(message = "La ubicacionActual no puede ser nulo")
    @NotBlank(message = "No puede dejar TipoProducto vacio")
    @Column(name = "ubicacionActual")
    private String ubicacionActual;

    //Getter
    public Long getId(){
        return id;  
    }

    public String getTipoProducto(){
        return TipoProducto;
    }

    public String getDestinatario(){
        return destinatario;
    }

    public String getDirecccionDestino(){
        return direcccionDestino;
    }
    
    public LocalDateTime getFechaEnvio(){
        return fechaEnvio;
    }

    public String getUbicacionActual(){
        return ubicacionActual;
    }

     //Setters

    public void setId(Long id){
        this.id = id;
    }
    
    public void setTipoProducto(String TipoProducto){
        this.TipoProducto = TipoProducto;
    }

    public void setDestinatario(String destinatario){
        this.destinatario = destinatario;
    }

    public void setDirecccionDestino(String direccionDestino){
        this.direcccionDestino = direccionDestino;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio){
        this.fechaEnvio = fechaEnvio;
    }

    public void setUbicacionActual(String ubicacionActual){
        this.ubicacionActual = ubicacionActual;
    }

}
