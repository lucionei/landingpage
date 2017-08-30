package com.lucionei.chamadostecnicos.dao;

import com.lucionei.chamadostecnicos.model.Contato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucionei
 */
public class ContatoDao extends GenericDao{
    
    public Contato insert(Contato contato) throws Exception {
        String insert = "insert into contatos(id_contato, nome, email) values(?,?,?)";
        String sqlSequencia = "select nextval('seq_contatos')";

        List<Object> parametros = new ArrayList<>();
        parametros.add(contato.getNome());
        parametros.add(contato.getEmail());

        Long id = super.insertGenerico(insert, sqlSequencia, parametros);
        
        return null;

    }
    
    public Contato findById(Long id) throws Exception {
        String sql = "select * from contatos where id_contato = ?";
        List<Object> parametros = new ArrayList<>();
        parametros.add(id);
        return (Contato) super.findById(sql, parametros, new Parse<Contato>() {
            @Override
            public Contato mapping(ResultSet resultSet) throws SQLException {
                return parse(resultSet);
            }
        });
    }
    
    public List<Contato> findAll() throws Exception {
        String sql = "select * from contatos order by id_contato";
        List<Object> parametros = new ArrayList<>();
        return super.findAll(sql, parametros, new Parse<Contato>() {
            @Override
            public Contato mapping(ResultSet resultSet) throws SQLException {
                return parse(resultSet);
            }
        });
    }
    
    private Contato parse(ResultSet resultSet) throws SQLException {
        Contato contato = new Contato();
        if (resultSet != null) {
            contato.setId(resultSet.getLong("id_contato"));
            contato.setNome(resultSet.getString("nome"));
            contato.setEmail(resultSet.getString("email"));
        }
        return contato;
    }
    
}
