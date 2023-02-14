package uce.servicio_profesor_restful.controller;

import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uce.servicio_profesor_restful.model.Profesor;
import uce.servicio_profesor_restful.service.IProfesorService;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorControllerRestFul {

    @Autowired
    private IProfesorService iProfesorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarProfesor(@RequestBody Profesor profesor) {
        this.iProfesorService.insertarProfesor(profesor);
    }

    @GetMapping()
    public List<Profesor> buscarTodos() {
        return this.iProfesorService.buscarTodos();
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Profesor buscarProfesor(@PathVariable("id")  Integer id) {
        return this.iProfesorService.buscarProfesor(id);
    }

    @GetMapping(path= "/cedula/{cedula}",produces = MediaType.APPLICATION_JSON_VALUE)
    Profesor buscarProfesorPorCedula(@PathVariable("cedula") String cedula){
        return this.iProfesorService.buscarProfesorPorCedula(cedula);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarProfesor(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        this.iProfesorService.actualizarProfesor(profesor);
    }

    @PutMapping()
    public void actualizarTodos(Profesor profesor) {
    }

    @DeleteMapping("/{id}")
    public void eliminarProfesor(@PathVariable("id") Integer id) {
        this.iProfesorService.borrarProfesor(id);
    }

}















