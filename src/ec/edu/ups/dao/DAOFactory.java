package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract CajaDAO getCajaDAO();
	public abstract RolDAO getRolDAO();
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract DiarioCajaDAO getDiarioCajaDAO();
	public abstract CuentaAhorrosDAO getCuentaAhorrosDAO();
	public abstract PlanCuentasDAO getPlanCuentasDAO();
	public abstract SocioDAO getSocioDAO();
	public abstract MovimientoDAO getMovimientoDAO();
	public abstract TipoMovimientoDAO getTipoMovimientoDAO();
	public abstract CreditoDAO getCreditoDAO();
	public abstract CarteraCreditosDAO getCarteraCreditosDAO();
	public abstract PagoCuotasDAO getPagoCuotasDAO();
	public abstract SolicitudCreditoDAO getSolicitudCreditoDAO();
	public abstract TablaAmortizacionDAO getTablaAmortizacionDAO();

}
