package servlets;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/bookingForm")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	public CustomerRegn() {
//		super();
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/photoshop";
		String dbUsername = "root";
		String dbPassword = "4908";

		String mobileNum = (request.getParameter("mobileNum"));
		String name = request.getParameter("name");
		String customerId = request.getParameter("customerId");
		System.out.println(name + " -- "+ customerId);
		
		String themeName = request.getParameter("themeName");
		int themePrice = 999;
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);

			String query = "insert into cust_bookings values(0,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, customerId);
			ps.setString(2, name);
			ps.setString(3, mobileNum);
			ps.setString(4, date);
			ps.setString(5, time);
			ps.setString(6, themeName);
			ps.setInt(7, themePrice);

			int count = ps.executeUpdate();

			if (count > 0) {
				System.out.print("booking -- success");

			} else {
				System.out.print("booking -- failed");

			}

		} catch (Exception e) {
			response.setContentType("text/html");
			response.getWriter().println("exception occured - " + e.getMessage());
			response.getWriter().println("also check console");
			e.printStackTrace();
		}
//		finally {
//            try {
//                if (rs != null) rs.close();
//                if (ps != null) ps.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
	}

}
