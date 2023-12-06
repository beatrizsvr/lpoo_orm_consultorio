package br.edu.ifsul.cstsi.lpoo_orm_consultorio.pacientes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> { //classe de modelo, tipo do id

}
