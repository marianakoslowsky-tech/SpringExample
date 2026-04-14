package com.senai.backend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.controle_frequencia.models.Pauta;
import com.senai.backend.controle_frequencia.repositories.Pautarepository;

@Service
public class PautaService {

    @Autowired
    private Pautarepository pautarepository;

    public Long contarPautas() {
        return pautarepository.count();

    }

    public Pauta buscarPauta(Integer id) {
        return pautarepository.findById(id).get();
    }

    public List<Pauta> listPautas() {
        return pautarepository.findAll();
    }

    public Boolean deletarPauta(Integer id) {
        if (pautarepository.existsById(id)) {
            pautarepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Pauta cadastrarPauta(Pauta pauta) {
        return pautarepository.save(pauta);
    }

public Pauta atualizarPauta(Integer id, Pauta pauta){
    Pauta pautaRecuperada = buscarPauta(id);
   if (pautaRecuperada != null) {
       pautaRecuperada.setId(id);
       if(pauta.getTurma()!=null){
        pautaRecuperada.setTurma(pauta.getTurma());

       }
       return pautarepository.save(pautaRecuperada);
    }
    return null;
}   
    
}