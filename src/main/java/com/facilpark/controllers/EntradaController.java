package com.facilpark.controllers;
import org.springframework.web.bind.annotation.*;
import com.facilpark.dto.*;
import com.facilpark.service.*;
import com.facilpark.models.*;

@RestController
@RequestMapping("/entrada")
@CrossOrigin("*")
public class EntradaController{
 private final EstacionamentoService service;
 public EntradaController(EstacionamentoService s){ this.service=s; }

 @PostMapping
 public Veiculo registrar(@RequestBody EntradaRequest r){
  return service.entrada(r.tipo,r.placa);
 }
}
