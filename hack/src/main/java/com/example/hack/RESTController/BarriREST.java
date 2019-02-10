package com.example.hack.RESTController;

import com.example.hack.Domini.Barri;
import com.example.hack.Persistencia.BarriDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/barris")
public class BarriREST {

    @Autowired
    private BarriDAO barriDAO;

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Barri> getAllBarris() {
        return barriDAO.getAllBarris();
    }

    @GetMapping(value = "get/kilos_actuals/{year}/{id_barri}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getPercentatgeKilosActualsBarri(@PathVariable int id_barri, @PathVariable int year) {
        return barriDAO.getPercentatgeKilosActualsBarri(year, id_barri);
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Barri getById(@PathVariable int id) {
        return barriDAO.getBarriById(id);
    }
}
