package com.example.hack.Persistencia;

import com.example.hack.Domini.Historial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HistorialDAO {

    @Autowired
    private BarriDAO barriDAO;

    private JdbcTemplate jdbcTemplate;

    private String SELECT_NUM_HABITANTS = "SELECT num_habitants FROM historial";
    private String GET_ALL = "SELECT * FROM historial";
    private String SELECT_BY_YEAR = "SELECT * FROM historial WHERE year = ?";
    private String SELECT_BY_BARRI = "SELECT * FROM historial WHERE id_barri = ?";
    private String SELECT_BY_IDS = "SELECT * FROM historial WHERE id_barri = ? and year = ?";

    public HistorialDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Historial> mapper = ((resultSet, i) -> new Historial(
            barriDAO.getBarriById(resultSet.getInt("id_barri")),
            resultSet.getInt("year"),
            resultSet.getFloat("kilograms")));


    public int update(int newKgToSet, int idCiutat) {
        return jdbcTemplate.update(SELECT_NUM_HABITANTS, newKgToSet, idCiutat);
    }

    public List<Historial> getAllHistorial() {
        return jdbcTemplate.query(GET_ALL, mapper);
    }

    public List<Historial> getByYear(int id) {
        return jdbcTemplate.query(SELECT_BY_YEAR, new Object[]{id}, mapper);
//        return !fetched.isEmpty() ? fetched.get(0) : null;
    }

    public List<Historial> getByBarri(int id_barri) {
        return jdbcTemplate.query(SELECT_BY_YEAR, new Object[]{id_barri}, mapper);
//        return !fetched.isEmpty() ? fetched.get(0) : null;
    }

    public Historial getByIds(int year, int id_barri) {
        List<Historial> fetched = jdbcTemplate.query(SELECT_BY_IDS, new Object[]{id_barri, year}, mapper);
        return !fetched.isEmpty() ? fetched.get(0) : null;
    }
}



