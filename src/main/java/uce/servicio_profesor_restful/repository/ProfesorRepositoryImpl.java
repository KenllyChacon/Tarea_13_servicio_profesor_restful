package uce.servicio_profesor_restful.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import uce.servicio_profesor_restful.model.Profesor;

import java.util.List;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insertarProfesor(Profesor profesor) {
        this.entityManager.persist(profesor);
    }

    @Override
    public Profesor buscarProfesor(Integer id) {
        return this.entityManager.find(Profesor.class, id);
    }

    @Override
    public void actualizarProfesor(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

    @Override
    public void borrarProfesor(Integer id) {
        Profesor profesorBorrar = this.buscarProfesor(id);
        this.entityManager.remove(profesorBorrar);
    }

    @Override
    public Profesor buscarProfesorPorCedula(String cedula) {
        TypedQuery<Profesor> miTypeQuery = (TypedQuery<Profesor>) this.entityManager.createQuery("select g from Profesor g where g.cedula =: cedula");
        miTypeQuery.setParameter("cedula", cedula);
        return miTypeQuery.getSingleResult();
    }

    @Override
    public List<Profesor> buscarTodos() {
        //Buscar Todos
        TypedQuery<Profesor> miTypeQuery = this.entityManager.createQuery("select e from Profesor e",Profesor.class);
        return miTypeQuery.getResultList();
    }

}
