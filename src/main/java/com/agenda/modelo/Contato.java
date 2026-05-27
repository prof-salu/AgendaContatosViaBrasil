package com.agenda.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//JAVABEAN --> atributos privados, gets e sets, construtor vazio, toString
@Entity //Define que a classe sera uma tabela no banco de dados
@Table(name = "contatos")
public class Contato {
    @Id //O campo id será uma chave primaria (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define a criação automatica de id's
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList();

    public Contato() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void adicionarEndereco(Endereco endereco){
        enderecos.add(endereco);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", enderecos=" + enderecos +
                '}';
    }
}
