package br.edu.ifsul.cstsi.lpoo_orm_consultorio.pacientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired // equivale a colocar abaixo new - ClienteRepository
    private PacienteRepository rep;

    public List<Paciente> getPacientes(){
        return rep.findAll();
    }

    public Paciente insert(Paciente paciente){
        Assert.isNull(paciente.getId(), "Não foi possível inserir o registro");
                return rep.save(paciente);
    }

    public Paciente getPacientebyId(long id) {
        Optional<Paciente> optional1 = rep.findById(id);
        if(optional1.isPresent()){
            return optional1.get();
        }
        return null;
    }

    public Paciente update(Paciente paciente){
        Assert.isNull((paciente.getNomePaciente()), "Não foi possível inserir o registro");
        return rep.save(paciente);
        //não tem que inserir na funçao as condições para a senha e nome de usuario?
    }
}
