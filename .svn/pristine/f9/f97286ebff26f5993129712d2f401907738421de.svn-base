package controlador;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import presentacion.consultaLugaresFacade;

@ManagedBean
@RequestScoped
public class ReportePCommand {
	
	private String parametro;
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public void exportarPDFF2() throws  Exception {

			System.out.println(parametro);
		   File jasper = new File(
		     FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporteP.jasper"));
		   
		   JasperPrint jasperPrint;
		   
		   consultaLugaresFacade lugares = new  consultaLugaresFacade();
		   Map<String, Object> parametros = new HashMap<String, Object>();
		   
			 
		   
		   if(this.parametro.length()==0){
			   parametros.put("propietarioo", "Todos los lugares registrados");
			   System.out.println("Entro con el textbox vacio");
			  jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros,
					   new JRBeanCollectionDataSource(lugares.consultarTodosLugares()));
		   }
		   else{
			   parametros.put("propietarioo", this.parametro);
			   jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros,
					     new JRBeanCollectionDataSource(lugares.consultarLugarPropietario(this.parametro)));
			  	   
		   }
		   
		   FacesContext.getCurrentInstance().responseComplete();
		   HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
		     .getResponse();
		   response.addHeader("Content-disposition", "attachment; filename=ReporteP.pdf");
		   ServletOutputStream stream = response.getOutputStream();
		   JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		   stream.flush();
		   stream.close();
		   FacesContext.getCurrentInstance().responseComplete();
		   
		 } 
	

}
