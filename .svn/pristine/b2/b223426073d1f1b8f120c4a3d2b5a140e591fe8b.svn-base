  package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Negocio.lugar.Coordenadas;
import Negocio.lugar.Lugar;

public class LugarRepository {
	public ArrayList<Lugar> consultarLugaresporId(String id) throws Exception{
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where lug_id = '"+id+"'";
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
		    while (rs.next())
		    {
		      int ide = rs.getInt("lug_id");
		      String nombre= rs.getString("lug_nombre");
		      String latitud = rs.getString("lug_latitud");
		      String longitud = rs.getString("lug_longitud");
		      int telefono = rs.getInt("lug_telefono");
		      String descripcion = rs.getString("lug_descripcion");
		      String categorias = rs.getString("cat_nombre");	
		      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
		      Lugar lugar = new Lugar(ide,nombre, coordenadas,telefono,descripcion,categorias);
		      lugares.add(lugar);
		      
		    }
			}catch (Exception e) {
		    	e.printStackTrace();
		    }finally {
			      try {
				        if (rs != null) {
				          rs.close();
				        }
				        if (st != null) {
				          st.close();
				        }
				        if (con != null) {
				          con.close();
				        }
				      } catch (Exception mysqlEx) {
				    	  mysqlEx.printStackTrace();
				      }
		    }	    
		    return lugares;
	 }
	
	public ArrayList<Lugar> consultarLugaresporNombre(String nombre) throws Exception{
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String paramQuery = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where lug_nombre = ?";
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement sentencia = null;
		try {
			con = new ConexionMysql().ObtenerConexion();
			sentencia = con.prepareStatement(paramQuery);
			sentencia.setString(1, nombre);
			rs = sentencia.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("lug_id");
				String latitud = rs.getString("lug_latitud");
				String longitud = rs.getString("lug_longitud");
				int telefono = rs.getInt("lug_telefono");
				String descripcion = rs.getString("lug_descripcion");
				String categorias = rs.getString("cat_nombre");
				Coordenadas coordenadas = new Coordenadas(latitud, longitud);
				Lugar lugar = new Lugar(id, nombre, coordenadas, telefono, descripcion, categorias);
				lugares.add(lugar);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception mysqlEx) {
				mysqlEx.printStackTrace();
			}
		}
		return lugares;
 }
	
	public ArrayList<Lugar> consultarLugaresporCoordenadas(Coordenadas coordenadas) throws Exception{
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String latitud=coordenadas.getLatitud();
		String longitud=coordenadas.getLongitud();
		String query = "select lug_id,lug_nombre,lug_longitud,lug_latitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where lug_latitud = '"+latitud+"' and lug_longitud='"+longitud+"'";
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
		    while (rs.next())
		    {
		      int id=rs.getInt("lug_id");
		      String nombre = rs.getString("lug_nombre");
		      int telefono = rs.getInt("lug_telefono");
		      String descripcion = rs.getString("lug_descripcion");
		      String categorias = rs.getString("cat_nombre");	      
		      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
		      lugares.add(lugar);
		      
		    }
			}catch (Exception e) {
		    	e.printStackTrace();
		    }finally {
			      try {
				        if (rs != null) {
				          rs.close();
				        }
				        if (st != null) {
				          st.close();
				        }
				        if (con != null) {
				          con.close();
				        }
				      } catch (Exception mysqlEx) {
				    	  mysqlEx.printStackTrace();
				      }
		    }	    
		    return lugares;
	 }
	public ArrayList<Lugar> consultarLugaresporCategoria(String categoria) throws Exception{
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where cat_nombre = '"+categoria+"'";
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
		    while (rs.next())
		    {
		      int id = rs.getInt("lug_id");
		      String nombre = rs.getString("lug_nombre");
		      String latitud = rs.getString("lug_latitud");
		      String longitud = rs.getString("lug_longitud");
		      int telefono = rs.getInt("lug_telefono");
		      String descripcion = rs.getString("lug_descripcion");
		      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
		      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categoria);
		      lugares.add(lugar);
		    }
			}catch (Exception e) {
		    	e.printStackTrace();
		    }finally {
			      try {
				        if (rs != null) {
				          rs.close();
				        }
				        if (st != null) {
				          st.close();
				        }
				        if (con != null) {
				          con.close();
				        }
				      } catch (Exception mysqlEx) {
				    	  mysqlEx.printStackTrace();
				      }
		    }	    
		    return lugares;
	 }
	public ArrayList<Lugar> consultarTodosLosLugares() throws Exception {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias";
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
	    while (rs.next())
	    {
	      int id=rs.getInt("lug_id");
	      String nombre = rs.getString("lug_nombre");
	      String latitud = rs.getString("lug_latitud");
	      String longitud = rs.getString("lug_longitud");
	      int telefono = rs.getInt("lug_telefono");
	      String descripcion = rs.getString("lug_descripcion");
	      String categorias = rs.getString("cat_nombre");
	      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
	      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
	      lugares.add(lugar);
	      
	    }
		}catch (Exception e) {
	    	e.printStackTrace();
	    }finally {
		      try {
			        if (rs != null) {
			          rs.close();
			        }
			        if (st != null) {
			          st.close();
			        }
			        if (con != null) {
			          con.close();
			        }
			      } catch (Exception mysqlEx) {
			    	  mysqlEx.printStackTrace();
			      }
	    }	    
	    return lugares;
	 }
	public ArrayList<Lugar> consultarLugaresPropietario(String email) throws Exception {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_latitud,lug_longitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join categorias where pro_email='"+email+"'";
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
	    while (rs.next())
	    {
	      int id=rs.getInt("lug_id");
	      String nombre = rs.getString("lug_nombre");
	      String latitud = rs.getString("lug_latitud");
	      String longitud = rs.getString("lug_longitud");
	      int telefono = rs.getInt("lug_telefono");
	      String descripcion = rs.getString("lug_descripcion");
	      String categorias = rs.getString("cat_nombre");
	      System.out.println("categoria :"+categorias);
	      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
	      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
	      lugares.add(lugar);
	    }
		}catch (Exception e) {
	    	e.printStackTrace();
	    }finally {
		      try {
			        if (rs != null) {
			          rs.close();
			        }
			        if (st != null) {
			          st.close();
			        }
			        if (con != null) {
			          con.close();
			        }
			      } catch (Exception mysqlEx) {
			    	  mysqlEx.printStackTrace();
			      }
	    }	    
	    return lugares;
	 }
	public ArrayList<Lugar> consultarLugaresFavoritos(String email) throws Exception {
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		String query = "select lug_id,lug_nombre,lug_longitud,lug_latitud,lug_telefono,lug_descripcion,cat_nombre from lugar natural join favoritos natural join categorias where usu_email='"+email+"'";
		Statement st = null;
	    ResultSet rs = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	st = con.createStatement();
	    	rs = st.executeQuery(query);
	    while (rs.next())
	    {
	      int id= rs.getInt("lug_id");
	      String nombre = rs.getString("lug_nombre");
	      String latitud = rs.getString("lug_latitud");
	      String longitud = rs.getString("lug_longitud");
	      int telefono = rs.getInt("lug_telefono");
	      String descripcion = rs.getString("lug_descripcion");
	      String categorias = rs.getString("cat_nombre");	
	      Coordenadas coordenadas = new Coordenadas(latitud,longitud);
	      Lugar lugar = new Lugar(id,nombre, coordenadas,telefono,descripcion,categorias);
	      lugares.add(lugar);
	    }
		}catch (Exception e) {
	    	e.printStackTrace();
	    }finally {
		      try {
			        if (rs != null) {
			          rs.close();
			        }
			        if (st != null) {
			          st.close();
			        }
			        if (con != null) {
			          con.close();
			        }
			      } catch (Exception mysqlEx) {
			    	  mysqlEx.printStackTrace();
			      }
	    }	    
	    return lugares;
	 }
	
	public void registrarLugar(Lugar lugar) throws Exception{
		String nombre = lugar.getNombre();
		int telefono = lugar.getTelefono();
		Coordenadas coordenadas = lugar.getCoordenadas();
		String latitud = coordenadas.getLatitud();
		String longitud = coordenadas.getLongitud();
		String email = lugar.getPropietario();
		int categoria = lugar.getCategoria();
		String descripcion = lugar.getDescripcion();
		String paramQuery= "insert into lugar (`lug_nombre`, `lug_telefono`, `lug_latitud`, `lug_longitud`, `pro_email`, `cat_id`, `lug_descripcion`) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement sentencia =null;
	    Statement stmt = null;
	    Connection con = null;
	    try {
	    	con = new ConexionMysql().ObtenerConexion();
	    	sentencia=con.prepareStatement(paramQuery);
	    	sentencia.setString(1, nombre);
	    	sentencia.setInt(2, telefono);
	    	sentencia.setString(3, latitud);
	    	sentencia.setString(4, longitud);
	    	sentencia.setString(5, email);
	    	sentencia.setInt(6, categoria);
	    	sentencia.setString(7, descripcion);
	    	sentencia.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    finally {
	      try {
	        if (stmt != null) {
	          stmt.close();
	        }
	        if(sentencia!=null){
	        	sentencia.close();
	        }
	        if (con != null) {
	          con.close();
	        }
	      } catch (Exception mysqlEx) {
	        mysqlEx.printStackTrace();
	      }
	    }
				
	}
	public void eliminarLugar(Lugar lugar){
		int id = lugar.getId();
		Coordenadas coordenadas = lugar.getCoordenadas();
		String latitud = coordenadas.getLatitud();
		String longitud = coordenadas.getLongitud();
		String query = "delete from lugar where lug_id='" + id + "'and lug_latitud='" + latitud + "'and lug_longitud='"
				+ longitud + "'";
		Statement stmt = null;
		Connection con = null;
		try {
			con = new ConexionMysql().ObtenerConexion();
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception mysqlEx) {
				mysqlEx.printStackTrace();
			}

		}
	}

	public void ActualizarDatos(Lugar lugar) throws Exception {
		int id = lugar.getId();
		String nombre = lugar.getNombre();
		int telefono = lugar.getTelefono();
		Coordenadas coordenadas = lugar.getCoordenadas();
		String latitud = coordenadas.getLatitud();
		String longitud = coordenadas.getLongitud();
		String email = lugar.getPropietario();
		int categoria = lugar.getCategoria();
		String descripcion = lugar.getDescripcion();
		String paramQuery = "update lugar set lug_nombre=?, lug_telefono=?,lug_latitud=?, lug_longitud=?,cat_id=?,lug_descripcion=?, pro_email=? where lug_id=?";
		Statement stmt = null;
		Connection con = null;
		PreparedStatement sentencia = null;
		try {
			con = new ConexionMysql().ObtenerConexion();
			sentencia = con.prepareStatement(paramQuery);
			sentencia.setString(1, nombre);
			sentencia.setInt(2, telefono);
			sentencia.setString(3, latitud);
			sentencia.setString(4, longitud);
			sentencia.setInt(5, categoria);
			sentencia.setString(6, descripcion);
			sentencia.setString(7, email);
			sentencia.setInt(8, id);
			sentencia.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (sentencia != null) {
					sentencia.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception mysqlEx) {
				mysqlEx.printStackTrace();
			}
		}
	}

	public void RegistroFavorito(String email, Lugar lugar) {
		int id = lugar.getId();
		String query = "insert into `bdsoftware2`.`favoritos` (`usu_email`, `lug_id`) values ('" + email + "', '" + id+ "')";
		Statement stmt = null;
		Connection con = null;
		try {
			con = new ConexionMysql().ObtenerConexion();
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception mysqlEx) {
				mysqlEx.printStackTrace();
			}
		}
	}

	public void quitarFavorito(String email, Lugar lugar) {
		int id = lugar.getId();
		String query = "delete from favoritos where usu_email='" + email + "' and lug_id='" + id + "'";
		Statement stmt = null;
		Connection con = null;
		try {
			con = new ConexionMysql().ObtenerConexion();
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception mysqlEx) {
				mysqlEx.printStackTrace();
			}

		}
	}
}
