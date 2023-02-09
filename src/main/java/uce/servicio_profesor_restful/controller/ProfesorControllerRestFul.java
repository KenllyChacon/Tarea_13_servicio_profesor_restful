package uce.servicio_profesor_restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uce.servicio_profesor_restful.model.Profesor;
import uce.servicio_profesor_restful.service.IProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorControllerRestFul {

    @Autowired
    private IProfesorService iProfesorService;

    @PostMapping
    public void insertarProfesor(@RequestBody Profesor profesor) {
        this.iProfesorService.insertarProfesor(profesor);
    }

    @GetMapping("/{id}")
    public Profesor buscarProfesor(@PathVariable("id")  Integer id) {
        return this.iProfesorService.buscarProfesor(id);
    }

    @GetMapping("/cedula/{cedula}")
    Profesor buscarProfesorPorCedula(@PathVariable("cedula") String cedula){
        return this.iProfesorService.buscarProfesorPorCedula(cedula);
    }

    @PutMapping("/{id}")
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