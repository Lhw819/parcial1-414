package com.parcial1.Examen1erparcial.service;

import com.parcial1.Examen1erparcial.dto.PeliculaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PeliculaService {

    private List<PeliculaDTO> lista = new ArrayList<>();
    private AtomicLong id = new AtomicLong(1);

    public List<PeliculaDTO> getAll() {
        return lista;
    }

    public PeliculaDTO getById(Long idBuscado) {
        return lista.stream()
                .filter(p -> p.getId().equals(idBuscado))
                .findFirst()
                .orElse(null);
    }

    public PeliculaDTO add(PeliculaDTO p) {
        p.setId(id.getAndIncrement());
        lista.add(p);
        return p;
    }

    public PeliculaDTO update(Long idBuscado, PeliculaDTO nueva) {
        PeliculaDTO p = getById(idBuscado);
        if (p != null) {
            p.setTitulo(nueva.getTitulo());
            p.setDirector(nueva.getDirector());
            p.setDuracion(nueva.getDuracion());
            p.setGenero(nueva.getGenero());
            p.setClasificacion(nueva.getClasificacion());
        }
        return p;
    }

    public void delete(Long idBuscado) {
        lista.removeIf(p -> p.getId().equals(idBuscado));
    }
}