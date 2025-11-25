package com.facilpark.service;
import org.springframework.stereotype.Service;
import com.facilpark.models.*;
import com.facilpark.factory.*;
import com.facilpark.strategy.*;

@Service
public class EstacionamentoService{
 private Estacionamento est=new Estacionamento();
 private CalculoValorStrategy estrategia=new CalculoValorPorEntradaStrategy();

 public Veiculo entrada(String tipo,String placa){
  Veiculo v=VeiculoFactory.criar(tipo,placa);
  est.registrarEntrada(v);
  return v;
 }
 public double saida(String placa){
  Veiculo v=est.buscar(placa);
  double val=estrategia.calcular(v);
  est.liberar(placa);
  return val;
 }
 public java.util.List<Vaga> vagas(){ return est.getVagas(); }
}
