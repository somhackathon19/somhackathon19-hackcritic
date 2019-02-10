package com.example.hack.RESTController;

import com.example.hack.Domini.Barri;
import com.example.hack.Domini.Historial;
import com.example.hack.Persistencia.BarriDAO;
import com.example.hack.Persistencia.HistorialDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/historial")
public class HistorialREST {

    @Autowired
    private HistorialDAO historialDAO;

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Historial> getAllHisotrial() {
        return historialDAO.getAllHistorial();
    }
//Aqui et donen una llista del hostorial dels anys
    @GetMapping(value = "get/year/{any}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Historial> getHistorialPerAny(@PathVariable int any) {
        return historialDAO.getByYear(any);
    }
// Aqui et dona una llista de de id de l'historial
    @GetMapping(value = "get/barri/{id_barri}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Historial> getById(@PathVariable int id_barri) {
        return historialDAO.getByBarri(id_barri);
    }
//Aqui et dona un any del historial
    @GetMapping(value = "get/{id_barri}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Historial getById(@PathVariable int id_barri, @PathVariable int year) {
        return historialDAO.getByIds(year, id_barri);
    }
}
