package com.example.hack.RESTController;

import com.example.hack.Domini.Ciutat;
import com.example.hack.Persistencia.CiutatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ciutats")
public class CiutatREST {

    @Autowired
    private CiutatDAO ciutatDAO;

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ciutat> getAllCiutat() {
        return ciutatDAO.getAllCiutat();
    }
//Aqui
    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ciutat getById(@PathVariable int id) {
        System.out.println(id);
        return ciutatDAO.getCiutatById(id);
    }
}

