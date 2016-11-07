package Negocio.lugar;

import java.util.ArrayList;

import datos.LugarRepository;

public class BusquedaPorUbicacion extends BusquedaDeLugares {
	private ArrayList<Lugar> lugares = new ArrayList<Lugar>();
	private Coordenadas coordenadas;
	
	public BusquedaPorUbicacion(Coordenadas coordenadas) {
		// TODO Auto-generated constructor stub
		this.coordenadas=coordenadas;
	}

	@Override
	public ArrayList<Lugar> buscar() throws Exception {
		// TODO Auto-generated method stub
		LugarRepository lugarRepository = new LugarRepository();
		this.lugares=lugarRepository.consultarLugaresporCoordenadas(this.coordenadas);
		return this.lugares;
	}

}
