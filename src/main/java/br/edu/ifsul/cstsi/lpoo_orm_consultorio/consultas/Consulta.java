package br.edu.ifsul.cstsi.lpoo_orm_consultorio.consultas;

import br.edu.ifsul.cstsi.lpoo_orm_consultorio.secretarias.Secretaria;
import br.edu.ifsul.cstsi.lpoo_orm_consultorio.agendas.Agenda;
import br.edu.ifsul.cstsi.lpoo_orm_consultorio.pacientes.Paciente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Consulta")
@Table(name = "consultas")
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public LocalDate data;
    public String nomeDentista;

    @OneToOne
    private Agenda agenda;

    @ManyToOne //mapeamento
    @JoinColumn
    private Paciente paciente;

    @ManyToOne
    private Secretaria secretaria;
}
