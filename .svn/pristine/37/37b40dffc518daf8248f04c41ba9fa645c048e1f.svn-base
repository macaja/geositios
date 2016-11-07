	package controlador;

	import java.io.File;
	import java.util.HashMap;
	import java.util.Map;

	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.RequestScoped;
	import javax.faces.context.FacesContext;
	import javax.servlet.ServletOutputStream;
	import javax.servlet.http.HttpServletResponse;

import Negocio.gestion.FechaPassword;
import Negocio.gestion.Propietario;
import datos.LugarRepository;
import datos.ValidarRepository;
	import net.sf.jasperreports.engine.JasperExportManager;
	import net.sf.jasperreports.engine.JasperFillManager;
	import net.sf.jasperreports.engine.JasperPrint;
	import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


	@ManagedBean
	@RequestScoped
	public class ReporteCommand {
		public void exportarPDFF1(FechaPassword fecha) throws  Exception {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("anio", fecha.getAño());
			parametros.put("mes",fecha.getMes());
			parametros.put("dia",fecha.getDia());
			File jasper = new File(
					FacesContext.getCurrentInstance().getExternalContext().getRealPath("/RFU.jasper"));
			ValidarRepository vr = new  ValidarRepository();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
					new JRBeanCollectionDataSource(vr.consultarUsuariosPorFecha(fecha)));
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=ejemplo.pdf");
			ServletOutputStream stream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
	}
		public void exportarPDFF2() throws  Exception {

			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("Ejemplo", "Ejemplo de Par");
			File jasper = new File(
					FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Coffee.jasper"));

			LugarRepository lr = new  LugarRepository();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros,
					new JRBeanCollectionDataSource(lr.consultarTodosLosLugares()));
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=ejemplo.pdf");
			ServletOutputStream stream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		


	}

		public void exportarPDFF3(Propietario propietario) throws  Exception {
			/*Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("anio", fecha.getAño());
			parametros.put("mes",fecha.getMes());
			parametros.put("dia",fecha.getDia());*/
			String email = propietario.getEmail();
			File jasper = new File(
					FacesContext.getCurrentInstance().getExternalContext().getRealPath("/gg.jasper"));
			LugarRepository lr = new  LugarRepository();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
					new JRBeanCollectionDataSource(lr.consultarLugaresPropietario(email)));
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=ejemplo.pdf");
			ServletOutputStream stream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
	}
	
	
	

}
