package com.example.hack.Persistencia;

import com.example.hack.Domini.Barri;
import com.example.hack.Domini.Ciutat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CiutatDAO {


    private JdbcTemplate jdbcTemplate;

    private String SELECT_NUM_HABITANTS = "SELECT num_habitants FROM ciutat";
    private String GET_ALL = "SELECT * FROM ciutat";
    private String SELECT_BY_ID = "SELECT * FROM ciutat WHERE id_ciutat = ?";

    public CiutatDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Ciutat> mapper = ((resultSet, i) -> new Ciutat(
            resultSet.getInt("id_ciutat"),
            resultSet.getString("nom"),
            resultSet.getInt("num_habitats")));


    public int update(int newKgToSet, int idCiutat) {
        return jdbcTemplate.update(SELECT_NUM_HABITANTS, newKgToSet, idCiutat);
    }

    public List<Ciutat> getAllCiutat() {
        return jdbcTemplate.query(GET_ALL, mapper);
    }

    public Ciutat getCiutatById(int id) {
        List<Ciutat> fetched = jdbcTemplate.query(SELECT_BY_ID, new Object[]{id}, mapper);
        return !fetched.isEmpty() ? fetched.get(0) : null;
    }
}

