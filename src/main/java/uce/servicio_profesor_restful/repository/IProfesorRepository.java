package uce.servicio_profesor_restful.repository;

import uce.servicio_profesor_restful.model.Profesor;

public interface IProfesorRepository {

    void insertarProfesor(Profesor profesor);
    Profesor buscarProfesor(Integer id);
    void actualizarProfesor(Profesor profesor);
    void borrarProfesor(Integer id);

    Profesor buscarProfesorPorCedula(String cedula);

}

