package com.facilpark.strategy;
import com.facilpark.models.Veiculo;
public class CalculoValorPorEntradaStrategy implements CalculoValorStrategy{
 public double calcular(Veiculo v){
  return switch(v.tipo){
   case "carro" -> 10;
   case "moto" -> 5;
   default -> 15;
  };
 }
}
