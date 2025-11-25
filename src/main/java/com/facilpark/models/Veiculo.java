package com.facilpark.models;
import java.time.LocalDateTime;
public abstract class Veiculo{
 public String tipo;
 public String placa;
 public LocalDateTime entrada;
 public Veiculo(String tipo,String placa){
  this.tipo=tipo; this.placa=placa; this.entrada=LocalDateTime.now();
 }
}