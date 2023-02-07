package uce.servicio_profesor_restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.servicio_profesor_restful.model.Profesor;
import uce.servicio_profesor_restful.repository.IProfesorRepository;

@Service
public class ProfesorServiceImpl implements IProfesorService{

    @Autowired
    private IProfesorRepository profesorRepository;


    @Override
    public void insertarProfesor(Profesor profesor) {
        this.profesorRepository.insertarProfesor(profesor);
    }

    @Override
    public Profesor buscarProfesor(Integer id) {
        return this.profesorRepository.buscarProfesor(id);
    }

    @Override
    public void actualizarProfesor(Profesor profesor) {
        this.profesorRepository.actualizarProfesor(profesor);
    }

    @Override
    public void borrarProfesor(Integer id) {
        this.profesorRepository.borrarProfesor(id);
    }

    @Override
    public Profesor buscarProfesorPorCedula(String cedula) {
        return this.profesorRepository.buscarProfesorPorCedula(cedula);
    }
}


