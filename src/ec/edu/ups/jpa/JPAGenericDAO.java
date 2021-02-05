package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import javax.persistence.Query;

import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.creditos.TablaAmortizacion;
import ec.edu.ups.dao.GenericDAO;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.PlanCuentas;
import ec.edu.ups.socios.Socio;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	private Class<T> persistentClass;
    protected EntityManager em;

    public JPAGenericDAO(Class<T> persistentClass) {
    this.persistentClass = persistentClass;
    this.em = Persistence.createEntityManagerFactory("CajaAhorro-ProyectoRequerimientos").createEntityManager();
    }

	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		try {
		    em.persist(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		    e.printStackTrace();
		}
	}
	@Override
    public T read(ID id) {
	return em.find(persistentClass, id);
    }

    @Override
    public void update(T entity) {
	em.getTransaction().begin();
	try {
	    em.merge(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
    }

    // entity debe estar en estado de "Managed"
    @Override
    public void delete(T entity) {
	em.getTransaction().begin();
	try {
	    em.remove(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
    }
    @Override
    public void deleteByID(ID id) {
	T entity = this.read(id);
	if (entity != null)
	    this.delete(entity);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<T> findAll() {
	em.getTransaction().begin();
	List<T> lista = null;
	try {
	    javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(persistentClass));
	    lista = em.createQuery(cq).getResultList();
	    em.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return lista;

    }
    @Override
	public T buscarR(String nombre) {
		String jpql1 = "Select r FROM Rol r WHERE r.rol= '"+nombre+ "'";
		Query query = em.createQuery(jpql1);
		Rol roles = (Rol)query.getSingleResult();
		return (T) roles ;		
	}
    
    @Override
	public T Login(String username, String password) {
		String jpql1 = "Select u FROM Usuario u WHERE u.username='" + username +"'"+" AND  u.password='"+password+"'";
		Query query = em.createQuery(jpql1);
		Usuario user = (Usuario) query.getSingleResult();
		return (T) user ;		
	}
    
    @Override
    public T buscarPlanes(String nombre) {
		String jpql1 = "Select pc FROM PlanCuentas pc WHERE pc.tipo= '"+nombre+ "'";
		Query query = em.createQuery(jpql1);
		PlanCuentas planes = (PlanCuentas)query.getSingleResult();
		return (T) planes ;		
	}
    
    @Override
    public T buscarSocio(String cedula) {
    	String jpql1 = "Select s FROM Socio s WHERE s.cedula='" + cedula +"'" ;
    	Query query = em.createQuery(jpql1);
		Socio socio = (Socio) query.getSingleResult();
		return (T) socio ;
    	
    }
    
    @Override
    public T buscarSolicitud(int id) {
    	String jpql1 = "Select soli FROM SolicitudCredito soli WHERE soli.id=" + id ;
    	Query query = em.createQuery(jpql1);
    	SolicitudCredito solicitud = (SolicitudCredito) query.getSingleResult();
    	return (T) solicitud;
    }
    
    

    @Override
    public T buscarCuenta(String numeroC) {
    	String jpql1 = "Select cta FROM CuentaAhorros cta WHERE cta.numero='" + numeroC+"'" ;
    	Query query = em.createQuery(jpql1);
    	CuentaAhorros cuenta = (CuentaAhorros) query.getSingleResult();
    	return (T) cuenta;
    }
    
    //CAMBIO REALIZADO
    @Override
    public T Creditos(String numeroC) {
    	String jpql1 = "Select credt FROM Credito credt WHERE credt.cuentaA.numero='" + numeroC+"' AND credt.estado='A'" ;
    	Query query = em.createQuery(jpql1);
    	Credito credit = (Credito) query.getSingleResult();
    	return (T) credit;
    }
    
    @Override
    public T Tabla(int nume, int idC) {
    	String jpql1 = "Select tabla FROM TablaAmortizacion tabla WHERE tabla.numCuota=" +nume + " AND  tabla.credito.id=" +idC ;
    	Query query = em.createQuery(jpql1);
    	TablaAmortizacion tablaA = (TablaAmortizacion) query.getSingleResult();
    	return (T) tablaA;
    }
    
    @Override
	public List<TablaAmortizacion> listaT (int idCred){
		String jpql1 = "Select tabla FROM TablaAmortizacion tabla WHERE tabla.credito.id=" +idCred ;
    	List<TablaAmortizacion> amortizaciones = em.createQuery(jpql1).getResultList();
		return amortizaciones;	
	}
    
    


}
