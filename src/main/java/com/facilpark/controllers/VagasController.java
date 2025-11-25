package com.facilpark.controllers;

import com.facilpark.models.Vaga;
import com.facilpark.service.EstacionamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@CrossOrigin("*")
public class VagasController {

    private final EstacionamentoService service;

    public VagasController(EstacionamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vaga> listarVagas() {
        return service.vagas();
    }
}
