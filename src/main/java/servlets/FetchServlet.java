package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet("/fetchData")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	public CustomerRegn() {
//		super();
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside fetch servlet");
		
		String mobileNum = null;
		String name = "no user found";
		int id= 0;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			JSONObject jsonObject = new JSONObject(sb.toString());
			mobileNum = jsonObject.getString("mobileNum");

		} catch (Exception e) {
			response.setContentType("text/html");
			response.getWriter().println("exception occured - " + e.getMessage());
			response.getWriter().println("also check console");
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String url = "jdbc:mysql://localhost:3306/photoshop";
		String dbUsername = "root";
		String dbPassword = "4908";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);

			String query = "select cust_id,cust_fName,cust_mName,cust_lName from cust_table where cust_mobile = ?";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, mobileNum);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt("cust_id");
				String fName = rs.getString("cust_fName");
				String mName = rs.getString("cust_mName");
				String lName = rs.getString("cust_lName");
				name = fName + " " + mName + " " + lName;
			}
			JSONObject data = new JSONObject();
			
			data.put("name", name);
			data.put("id", id);
			
			response.setContentType("application/json");
			response.getWriter().write(data.toString());

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
