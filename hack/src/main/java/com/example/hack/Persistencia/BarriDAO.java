package com.example.hack.Persistencia;

import com.example.hack.Domini.Barri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BarriDAO {

    @Autowired
    private HistorialDAO historialDAO;

    private JdbcTemplate jdbcTemplate;

    private String UPDATE = "UPDATE barri SET kilograms = ? where id_barri = ?";
    private String GET_ALL = "SELECT * FROM barri";
    private String SELECT_BY_ID = "SELECT * FROM barri WHERE id_barri = ?";
    private String SELECT_CURRENT_KG = "SELECT kilograms FROM barri WHERE id_barri = ?";

    public BarriDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Barri> mapper = ((resultSet, i) -> new Barri(
            resultSet.getInt("id_barri"),
            resultSet.getString("nom"),
            resultSet.getInt("num_habitats"),
            resultSet.getFloat("kilograms")));


    public int update(int newKgToSet, int idBarri) {
        return jdbcTemplate.update(UPDATE, newKgToSet, idBarri);
    }

    public List<Barri> getAllBarris() {
        return jdbcTemplate.query(GET_ALL, mapper);
    }

    public Barri getBarriById(int id_barri) {
        List<Barri> fetched = jdbcTemplate.query(SELECT_BY_ID, new Object[]{id_barri}, mapper);
        return !fetched.isEmpty() ? fetched.get(0) : null;
    }

    public float getCurrentKg(int id_barri) {
        return getBarriById(id_barri).getCurrentKg();
    }

    public double getPercentatgeKilosActualsBarri(int year, int id_barri) {
        return Math.round((getCurrentKg(id_barri) / historialDAO.getByIds(year, id_barri).getKilograms()) * 100);
    }
}
