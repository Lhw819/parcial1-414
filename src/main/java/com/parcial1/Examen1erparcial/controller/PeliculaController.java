package com.parcial1.Examen1erparcial.controller;

import com.parcial1.Examen1erparcial.dto.PeliculaDTO;
import com.parcial1.Examen1erparcial.service.PeliculaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las peliculas")
    public List<PeliculaDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener peliculas por id")
    public PeliculaDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Crear nueva pelicula")
    public PeliculaDTO add(@RequestBody PeliculaDTO pelicula) {
        return service.add(pelicula);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una pelicula")
    public PeliculaDTO update(@PathVariable Long id, @RequestBody PeliculaDTO pelicula) {
        return service.update(id, pelicula);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una pelicula")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}