package Negocio.gestion;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class FechaPassword {
	public int año;
	public int mes;
	public int dia;
	public int total_dias;

	public FechaPassword() {

	}

	public FechaPassword(int año, int mes, int dia) {
		this.año = año;
		this.mes = mes;
		this.dia = dia;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getTotal_dias() {
		return total_dias;
	}

	public void setTotal_dias(int total_dias) {
		this.total_dias = total_dias;
	}

	public int convertir(FechaPassword f1, FechaPassword f2) {
		int diasf1 = ((f1.año - 1) * 360) + ((f1.mes - 1) * 30) + f1.dia;
		int diasf2 = ((f2.año - 1) * 360) + ((f2.mes - 1) * 30) + f2.dia;
		total_dias = diasf2 - diasf1;
		return total_dias;
	}

}
