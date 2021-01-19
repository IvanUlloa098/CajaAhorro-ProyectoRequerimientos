package ec.edu.ups.jpa;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.CarteraCreditosDAO;
import ec.edu.ups.dao.CreditoDAO;
import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.dao.SocioDAO;
import ec.edu.ups.dao.SolicitudCreditoDAO;
import ec.edu.ups.dao.TablaAmortizacionDAO;
import ec.edu.ups.dao.TipoMovimientoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.dao.DiarioCajaDAO;
import ec.edu.ups.dao.MovimientoDAO;
import ec.edu.ups.dao.PagoCuotasDAO;
import ec.edu.ups.dao.PlanCuentasDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public CajaDAO getCajaDAO() {
		// TODO Auto-generated method stub
		return new JPACajaDAO();
	}

	@Override
	public RolDAO getRolDAO() {
		// TODO Auto-generated method stub
		return new JPARolDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}
	
	@Override
	public DiarioCajaDAO getDiarioCajaDAO() {
		// TODO Auto-generated method stub
		return new JPADiarioCajaDAO();
	}
	
	@Override
	public CuentaAhorrosDAO getCuentaAhorrosDAO() {
		// TODO Auto-generated method stub
		return new JPACuentaAhorrosDAO();
	}
	
	@Override
	public PlanCuentasDAO getPlanCuentasDAO() {
		// TODO Auto-generated method stub
		return new JPAPlanCuentasDAO();
	}
	
	@Override
	public SocioDAO getSocioDAO() {
		// TODO Auto-generated method stub
		return new JPASocioDAO();
	}
	
	@Override
	public MovimientoDAO getMovimientoDAO() {
		// TODO Auto-generated method stub
		return new JPAMovimientoDAO();
	}
	
	@Override
	public TipoMovimientoDAO getTipoMovimientoDAO() {
		// TODO Auto-generated method stub
		return new JPATipoMovimientoDAO();
	}
	
	@Override
	public CreditoDAO getCreditoDAO() {
		// TODO Auto-generated method stub
		return new JPACreditoDAO();
	}
	
	@Override
	public CarteraCreditosDAO getCarteraCreditosDAO() {
		// TODO Auto-generated method stub
		return new JPACarteraCreditosDAO();
	}
	
	@Override
	public PagoCuotasDAO getPagoCuotasDAO() {
		// TODO Auto-generated method stub
		return new JPAPagoCuotasDAO();
	}
	
	@Override
	public SolicitudCreditoDAO getSolicitudCreditoDAO() {
		// TODO Auto-generated method stub
		return new JPASolicitudCreditoDAO();
	}
	
	@Override
	public TablaAmortizacionDAO getTablaAmortizacionDAO() {
		// TODO Auto-generated method stub
		return new JPATablaAmortizacionDAO();
	}

}
