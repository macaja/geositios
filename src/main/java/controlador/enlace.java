package controlador;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Negocio.gestion.FechaPassword;
import Negocio.gestion.Persona;
import datos.ValidarRepository;
import presentacion.*;

@WebServlet("/enlace")
public class enlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public enlace() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("error1", null);
		request.setAttribute("error2", null);
		javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Calendar fecha = Calendar.getInstance();
		int aņo = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		FechaPassword fecha_login = new FechaPassword(aņo, mes, dia);
		String cambio_password;
		String email, pass;
		String accion = request.getParameter("ok");
		String c = (String) session.getAttribute("email");
		String t = (String) session.getAttribute("tipo");
		if (accion.equalsIgnoreCase("Entrar")) {
			email = request.getParameter("correo");
			pass = request.getParameter("password");
			Persona persona;
			LogInFacade logInFacade = new LogInFacade();
			persona = logInFacade.validar(email, pass);
			if (persona != null && session.getAttribute("persona") == null) {
				session.setAttribute("persona", persona);
				if (persona.getTipo().equalsIgnoreCase("propietario")) {
					session.setAttribute("tipo", persona.getTipo());
					ValidarRepository vr = new ValidarRepository();
					FechaPassword fecha_bd = vr.consultarFechaPassword(persona.getTipo(), email);
					FechaPassword r = new FechaPassword();
					int restadias = r.convertir(fecha_bd, fecha_login);
					if (restadias >= 90) {
						session.setAttribute("email", email);
						RequestDispatcher rd = request.getRequestDispatcher("cambioPassword.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("propietario", "propietario");
						RequestDispatcher rd = request.getRequestDispatcher("propietario.jsp");
						rd.forward(request, response);
					}
				}
				if (persona.getTipo().equalsIgnoreCase("usuario")) {
					session.setAttribute("tipo", persona.getTipo());
					ValidarRepository vr = new ValidarRepository();
					FechaPassword fecha_bd = vr.consultarFechaPassword(persona.getTipo(), email);
					FechaPassword r = new FechaPassword();
					int restadias = r.convertir(fecha_bd, fecha_login);
					if (restadias >= 90) {
						session.setAttribute("email", email);
						RequestDispatcher rd = request.getRequestDispatcher("cambioPassword.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("usuario", "usuario");
						RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
						rd.forward(request, response);
					}
				}

			} else {
				request.setAttribute("error1", "error1");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?msg=Usuario y/o " +
				"contraseņa incorrectos");
				rd.forward(request, response);
			}
		}
		if (accion.equalsIgnoreCase("Cambiar")) {
			cambio_password = request.getParameter("clave1");
			String correo = c;
			String tipo = t;
			ValidarRepository vr = new ValidarRepository();
			String passactual = vr.consultarContraseņa(tipo, correo);
			if (tipo.equalsIgnoreCase("usuario")) {
				if (!passactual.equalsIgnoreCase(cambio_password)) {
					vr.cambiarContraseņa(t, correo, cambio_password, fecha_login);
					request.setAttribute("usuario", "usuario");
					RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("cambioPassword.jsp");
					rd.forward(request, response);
				}
			}
			if (tipo.equalsIgnoreCase("propietario")) {
				if (!passactual.equalsIgnoreCase(cambio_password)) {
					vr.cambiarContraseņa(t, correo, cambio_password, fecha_login);
					request.setAttribute("usuario", "usuario");
					RequestDispatcher rd = request.getRequestDispatcher("propietario.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("cambioPassword.jsp");
					rd.forward(request, response);
				}
			}
		}

		if (accion.equalsIgnoreCase("Crear")) {
			String emaill = request.getParameter("correo");
			String nombre = request.getParameter("nombre");
			String password = request.getParameter("clave1");
			String tipo = request.getParameter("tipo");

			RegistroFacade registro = new RegistroFacade();
			Persona persona = registro.registrar(emaill, password, nombre, tipo);

			if (persona != null && session.getAttribute("persona") == null) {

				if (tipo.equalsIgnoreCase("propietario")) {
					request.setAttribute("propietario", "propietario");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("usuario", "usuario");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("error2", "error2");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?msg=El e-mail ya esta en uso");
				rd.forward(request, response);
			}

		}

		if (accion.equalsIgnoreCase("salir")) {
			session.invalidate();
			request.setAttribute("error1", null);
			request.setAttribute("error2", null);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}
