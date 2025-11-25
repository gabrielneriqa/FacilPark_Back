package com.facilpark.models;
import java.util.*;
public class Estacionamento{
 private List<Vaga> vagas=new ArrayList<>();
 private Map<String,Veiculo> veiculos=new HashMap<>();
 public Estacionamento(){
  for(int i=0;i<20;i++) vagas.add(new Vaga());
 }
 public void registrarEntrada(Veiculo v){
  veiculos.put(v.placa,v);
  for(Vaga g:vagas){ if(!g.ocupada){ g.ocupada=true; g.placa=v.placa; break;}}
 }
 public Veiculo buscar(String placa){ return veiculos.get(placa);}
 public void liberar(String placa){
  for(Vaga g:vagas){ if(placa.equals(g.placa)){ g.ocupada=false; g.placa=null; }}
 }
 public List<Vaga> getVagas(){ return vagas;}
}
