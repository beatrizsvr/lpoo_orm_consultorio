package br.edu.ifsul.cstsi.lpoo_orm_consultorio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Paciente")
@Table (name = "pacientes")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String nomePaciente;
    private int senha;
    private String usuario;

    @OneToMany (mappedBy = "paciente")
    private List<Consulta> consultaPacienteList;
}
