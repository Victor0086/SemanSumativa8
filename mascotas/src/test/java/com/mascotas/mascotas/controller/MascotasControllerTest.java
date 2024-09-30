package com.mascotas.mascotas.controller;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;
import com.mascotas.mascotas.model.Mascotas;
import com.mascotas.mascotas.service.MascotasService;


import com.mascotas.mascotas.Controller.MascotasController;
import com.mascotas.mascotas.service.MascotasServiceImpl;

@WebMvcTest(MascotasController.class)
public class MascotasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MascotasServiceImpl mascotasServicioMock;

    @Test
    public void obtenerTodosTest() throws Exception {

        // Creación de Tipo
        Mascotas mascotas1 = new Mascotas();
        mascotas1.setTipoProducto("Master Cat 10kg");
        mascotas1.setId(1L);

        Mascotas mascotas2 = new Mascotas();
        mascotas2.setTipoProducto("Master Dog 20kg");
        mascotas2.setId(2L);

        List<Mascotas> mascotas = Arrays.asList(mascotas1, mascotas2);
        when(mascotasServicioMock.getAllMascotas()).thenReturn(mascotas);

        mockMvc.perform(MockMvcRequestBuilders.get("/mascotas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].TipoProducto", Matchers.is("Master Cat 10kg")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].TipoProducto", Matchers.is("Master Dog 20kg")));
    }

         @MockBean
        private MascotasService mascotasService;
        @Test
        public void testGetMascotaByIdHateoasLinks() throws Exception {
       
        Mascotas mockMascota = new Mascotas();
        mockMascota.setId(1L);
        mockMascota.setTipoProducto("Mock Producto");

        
        when(mascotasService.getMascotasById(1L)).thenReturn(Optional.of(mockMascota));

        // Realiza la prueba HATEOAS.
        mockMvc.perform(MockMvcRequestBuilders.get("/mascotas/{id}", 1L))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$._links.self.href").exists())
               .andExpect(jsonPath("$._links.all-mascotas.href").exists());
    }
}

