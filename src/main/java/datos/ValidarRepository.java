package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import Negocio.gestion.FechaPassword;
import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import Negocio.gestion.Usuario;

public class ValidarRepository {

	public Persona consultarPersona(String emaill, String clavee) {
		Persona persona = null;
		String email = emaill;
		String clave = clavee;
		String paramQuery = "select usu_nombre, usu_gps, usu_coordenas from usuarios where usu_email=? and usu_password=?";
		PreparedStatement sentencia = null;
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = new ConexionMysql().ObtenerConexion();
			sentencia = con.prepareStatement(paramQuery);
			sentencia.setString(1, email);
			sentencia.setString(2, clave);
			rs = sentencia.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("usu_nombre");
				String gps = rs.getString("usu_gps");
				String coordenadas = rs.getString("usu_coordenas");
				persona = new Usuario(email, nombre, gps, coordenadas);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (sentencia != null) {
					sentencia.close();
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
		if (persona == null) {
			String paramQuery2 = "select * from propietario where pro_email=? and pro_password=?";
			sentencia = null;
			st = null;
			rs = null;
			con = null;
			try {
				con = new ConexionMysql().ObtenerConexion();
				sentencia = con.prepareStatement(paramQuery2);
				sentencia.setString(1, email);
				sentencia.setString(2, clave);
				rs = sentencia.executeQuery();
				while (rs.next()) {
					String emailll = rs.getString("pro_email");
					String pass = rs.getString("pro_password");
					String nombre = rs.getString("pro_nombre");
					int telefono = rs.getInt("pro_telefono");
					persona = new Propietario(emailll, pass, nombre, telefono);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (sentencia != null) {
						sentencia.close();
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
		}
		return persona;
	}

	public ArrayList<Usuario> consultarUsuariosPorFecha(FechaPassword fecha) {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		int año = fecha.getAño();
		int mes = fecha.getMes();
		int dia = fecha.getDia();
		String query = "select usu_email,usu_nombre from usuarios where usu_year_password >= '" + año
				+ "' and usu_month_password >='" + mes + "' and usu_day_password >='" + dia + "'";
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = new ConexionMysql().ObtenerConexion();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				String nombre = rs.getString("usu_nombre");
				String email = rs.getString("usu_email");
				Usuario usuario = new Usuario(nombre, email);
				usuarios.add(usuario);
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
		return usuarios;
	}

	public int registrar(Persona persona) {
		String email = persona.getEmail();
		String pass = persona.getClave();
		String nombre = persona.getNombre();
		String tipo = persona.getTipo();
		Calendar fecha = Calendar.getInstance();
		int año = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		PreparedStatement sentencia = null;
		int rs = 0;
		int r = 0;
		if (tipo.equalsIgnoreCase("propietario")) {
			String queryParam = "insert into propietario (`pro_email`, `pro_password`, `pro_nombre`,`pro_year_password`,`pro_month_password`,`pro_day_password`) VALUES (?,?,?,?,?,?)";
			Statement stmt = null;
			Connection con = null;
			try {
				con = new ConexionMysql().ObtenerConexion();
				sentencia = con.prepareStatement(queryParam);
				sentencia.setString(1, email);
				sentencia.setString(2, pass);
				sentencia.setString(3, nombre);
				sentencia.setInt(4, año);
				sentencia.setInt(5, mes);
				sentencia.setInt(6, dia);
				rs = sentencia.executeUpdate();
				if (rs == 1) {
					r = 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
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

		} else {
			String queryParam = "insert into usuarios (`usu_email`, `usu_password`, `usu_nombre`,`usu_gps``,`usu_year_password`,`usu_month_password`,`usu_day_password`) values (?, ?, ?, ?,?,?,?)";
			Statement stmt = null;
			Connection con = null;
			try {
				con = new ConexionMysql().ObtenerConexion();
				sentencia = con.prepareStatement(queryParam);
				sentencia.setString(1, email);
				sentencia.setString(2, pass);
				sentencia.setString(3, nombre);
				sentencia.setString(4, "No");
				sentencia.setInt(5, año);
				sentencia.setInt(6, mes);
				sentencia.setInt(7, dia);
				rs = sentencia.executeUpdate();
				if (rs == 1) {
					r = 2;
				}
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
		return r;

	}

	public void cambiarContraseña(String tipo, String email, String contraseña, FechaPassword fecha) {
		int año = fecha.getAño();
		int mes = fecha.getMes();
		int dia = fecha.getDia();
		if (tipo.equalsIgnoreCase("usuario")) {
			String query = "update usuarios set usu_password='" + contraseña + "', usu_year_password='" + año
					+ "',usu_month_password='" + mes + "', usu_day_password='" + dia + "' where usu_email='" + email
					+ "'";
			Statement stmt = null;
			Connection con = null;
			int rs;
			try {
				con = new ConexionMysql().ObtenerConexion();
				stmt = con.createStatement();
				rs = stmt.executeUpdate(query);
				System.out.println("rs: " + rs);
				System.out.println("al crear: " + rs);
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
		} else {
			String query = "update propietario set pro_password='" + contraseña + "', pro_year_password='" + año
					+ "',pro_month_password='" + mes + "', pro_day_password='" + dia + "' where pro_email='" + email
					+ "'";
			System.out.println(query);
			Statement stmt = null;
			Connection con = null;
			int rs;
			try {
				con = new ConexionMysql().ObtenerConexion();
				stmt = con.createStatement();
				rs = stmt.executeUpdate(query);
				System.out.println("rs: " + rs);
				System.out.println("al crear: " + rs);
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

	public String consultarContraseña(String tipo, String emaill) {
		String email = emaill;
		String password = null;
		if (tipo.equalsIgnoreCase("usuario")) {
			String query = "select usu_password from usuarios where usu_email='" + email + "'";
			;
			Statement st = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				con = new ConexionMysql().ObtenerConexion();
				st = con.createStatement();
				rs = st.executeQuery(query);
				while (rs.next()) {
					password = rs.getString("usu_password");
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
		}
		if (tipo.equalsIgnoreCase("propietario")) {
			String query = "select pro_password from propietario where pro_email='" + email + "'";
			Statement st = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				con = new ConexionMysql().ObtenerConexion();
				st = con.createStatement();
				rs = st.executeQuery(query);
				while (rs.next()) {
					password = rs.getString("pro_password");
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

		}
		return password;
	}

	public FechaPassword consultarFechaPassword(String tipo, String email) {
		int año = 0;
		int mes = 0;
		int dia = 0;
		FechaPassword fecha = null;
		if (tipo.equalsIgnoreCase("usuario")) {
			String query = "select usu_year_password, usu_month_password, usu_day_password from usuarios where usu_email='"
					+ email + "'";
			;
			System.out.println(query);
			Statement st = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				con = new ConexionMysql().ObtenerConexion();
				st = con.createStatement();
				rs = st.executeQuery(query);
				while (rs.next()) {
					año = rs.getInt("usu_year_password");
					mes = rs.getInt("usu_month_password");
					dia = rs.getInt("usu_day_password");
					fecha = new FechaPassword(año, mes, dia);
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
		}
		if (tipo.equalsIgnoreCase("propietario")) {
			String query = "select pro_year_password, pro_month_password, pro_day_password from propietario where pro_email='"
					+ email + "'";
			;
			Statement st = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				con = new ConexionMysql().ObtenerConexion();
				st = con.createStatement();
				rs = st.executeQuery(query);
				while (rs.next()) {
					año = rs.getInt("pro_year_password");
					mes = rs.getInt("pro_month_password");
					dia = rs.getInt("pro_day_password");
					fecha = new FechaPassword(año, mes, dia);
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
		}
		return fecha;
	}

	public String consultarEmail(String emaill) {

		String email = emaill;
		String nombre = null;
		String paramQuery = "select usu_nombre, usu_email from usuarios where usu_email=?";
		PreparedStatement sentencia = null;
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = new ConexionMysql().ObtenerConexion();
			sentencia = con.prepareStatement(paramQuery);
			sentencia.setString(1, email);
			rs = sentencia.executeQuery();
			while (rs.next()) {
				nombre = rs.getString("usu_nombre");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (sentencia != null) {
					sentencia.close();
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
		if (nombre == null) {
			String paramQuery2 = "select * from propietario where pro_email=?";
			sentencia = null;
			st = null;
			rs = null;
			con = null;
			try {
				con = new ConexionMysql().ObtenerConexion();
				sentencia = con.prepareStatement(paramQuery2);
				sentencia.setString(1, email);
				rs = sentencia.executeQuery();
				while (rs.next()) {
					System.out.println("ver2");
					nombre = rs.getString("pro_nombre");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (sentencia != null) {
						sentencia.close();
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

		}
		return nombre;
	}

}
