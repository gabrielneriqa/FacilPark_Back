package com.facilpark.factory;
import com.facilpark.models.*;
public class VeiculoFactory{
 public static Veiculo criar(String tipo,String placa){
  return switch(tipo){
   case "carro" -> new Carro(placa);
   case "moto" -> new Moto(placa);
   default -> new Caminhao(placa);
  };
 }
}
