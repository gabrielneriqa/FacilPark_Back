package com.facilpark.controllers;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.facilpark.dto.*;
import com.facilpark.service.*;

@RestController
@RequestMapping("/saida")
@CrossOrigin("*")
public class SaidaController{
 private final EstacionamentoService service;
 public SaidaController(EstacionamentoService s){ this.service=s; }

 @PostMapping
 public Map<String,Double> registrar(@RequestBody SaidaRequest r){
  return Map.of("valor", service.saida(r.placa));
 }
}
