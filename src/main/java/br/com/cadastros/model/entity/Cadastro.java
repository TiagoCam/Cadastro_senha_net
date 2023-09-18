package br.com.cadastros.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "{campo.nomeGerente.obrigatorio}")
    @Column(nullable = false, length = 150)
    private String nomeGerente;

    @NotEmpty(message = "{campo.nomeColaborador.obrigatorio}")
    @Column(nullable = false, length = 150)
    private String nomeColaborador;

    @Column(unique = true, length = 15)
    @NotEmpty(message = "{campo.senha.invalida}")
    private String senha;


}
