package br.com.becajava.DeliveryMySQL.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nome;
    private String cpf;
    private String email;
    private String telefone;



    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private Set<Enderecos> enderecos = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Enderecos> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Enderecos> enderecos) {
        this.enderecos = enderecos;

        for(Enderecos b : enderecos) {
            b.setClientes(this);
        }
    }
}
