package com.lucionei.landingpage.model;

import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Lucionei
 */
public class Contato implements Parseable{

    private Long id;
    private String nome;
    private String email;

    public Contato() {
    }

    public Contato(Long id) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("{\"id\":\"%s\",\"nome\":\"%s\",\"email\":\"%s\"}", id, nome, email);
    }

    @Override
    public void parse(Map<String, String> dados) {
        id = dados.get("id") == null || dados.get("id").isEmpty() ? null : Long.parseLong(dados.get("id"));
        nome = dados.get("nome");
        email = dados.get("email");
    }
    
    

}
