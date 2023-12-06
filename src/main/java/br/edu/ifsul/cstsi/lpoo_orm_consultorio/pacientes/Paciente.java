package br.edu.ifsul.cstsi.lpoo_orm_consultorio.pacientes;

import br.edu.ifsul.cstsi.lpoo_orm_consultorio.consultas.Consulta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Paciente")
@Table (name = "pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String nomePaciente;
    private String senha;
    private String usuario;

    @OneToMany (mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Consulta> consultaPacienteList;

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nomePaciente='" + nomePaciente + '\'' +
                ", senha='" + senha + '\'' +
                ", usuario='" + usuario + '\'' +
                ", consultaPacienteList=" + consultaPacienteList +
                '}';
    }
}
