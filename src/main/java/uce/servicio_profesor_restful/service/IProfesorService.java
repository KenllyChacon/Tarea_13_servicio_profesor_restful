package uce.servicio_profesor_restful.service;

import uce.servicio_profesor_restful.model.Profesor;

import java.util.List;

public interface IProfesorService {

    void insertarProfesor(Profesor profesor);
    Profesor buscarProfesor(Integer id);
    void actualizarProfesor(Profesor profesor);
    void borrarProfesor(Integer id);

    Profesor buscarProfesorPorCedula(String cedula);
    List<Profesor> buscarTodos();

}
