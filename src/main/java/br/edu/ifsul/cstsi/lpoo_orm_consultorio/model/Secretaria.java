package br.edu.ifsul.cstsi.lpoo_orm_consultorio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Secretaria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int rg;

    @OneToMany(mappedBy = "secretaria") // mapeado pelo
    private List<Consulta> consultaList;

}
