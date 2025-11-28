package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnection;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/principal/*"}) /*It intercepts all requests from the principal folder*/
public class FilterAutentication extends HttpFilter implements Filter {
       
	private static Connection conn;
  
    public FilterAutentication() {
        super();
    }

    /**
     * It finishes the processes when the server is stopped
     */
	public void destroy() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * It filters all requests; Here is where everything happens
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException{
		try {
			
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(); // I stopped here
		
		String loggeduser = (String) session.getAttribute("usr");
		String urlforautentication = req.getServletPath();
		
		if (loggeduser == null && !urlforautentication.equalsIgnoreCase("/principal/servLogin")) {
			RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp?url="+urlforautentication);
			request.setAttribute("msg", "Please try to log in first!");
			redirect.forward(request, response);
			return;
		}else {
			chain.doFilter(request, response);

		}
		
		} catch (Exception e) {
			RequestDispatcher redirect = request.getRequestDispatcher("error.jsp");
			request.setAttribute("msg", e.getMessage());
			redirect.forward(request, response);
		}
		
	}
/**
 * It starts the processes when the server starts running
 * It starts the database's connection
 */
	public void init(FilterConfig fConfig) throws ServletException {
		conn = SingleConnection.getConnection();
	}

}
