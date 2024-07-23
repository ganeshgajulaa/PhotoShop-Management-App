package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/customerForm")
public class CustomerRegn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerRegn() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/photoshop";
		String dbUsername = "root";
		String dbPassword = "4908";

		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");

		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		String mobileNum = (request.getParameter("mobileNum"));
		String alternateNum = (request.getParameter("alternateNum"));

		String address = request.getParameter("address");

		String gender = request.getParameter("gender");
		String maritalStatus = request.getParameter("maritalStatus");

		String dob = request.getParameter("dob");
//		2024-05-29

		String anniversaryDate = request.getParameter("anniversaryDate");

		String spouseName = request.getParameter("spouseName");
		String spouseDob = request.getParameter("spouseDob");

		String fatherName = request.getParameter("fatherName");
		String fatherDob = request.getParameter("fatherDob");

		String motherName = request.getParameter("motherName");
		String motherDob = request.getParameter("motherDob");

		String reference = request.getParameter("reference");

		// add member
		int memberCount = Integer.parseInt(request.getParameter("memberCount"));
		
		JSONArray members = new JSONArray();
		
		//set members
		for (int i = 1; i <= memberCount; i++) {
			String name = request.getParameter("memberName" + i);
			String relation = request.getParameter("memberRelation" + i);
			String memberDob = request.getParameter("memberDob" + i);

			JSONObject member = new JSONObject();
			member.put("name", name);
			member.put("relation", relation);
			member.put("memberDob", memberDob);

			members.put(member);
		}

		// get members
//		String membersJson = rs.getString("members");
//
//		JSONArray membersArray = new JSONArray(membersJson);
//
//		for (int i = 0; i < membersArray.length(); i++) {
//			JSONObject member = membersArray.getJSONObject(i);
//			System.out.println("Member: " + member.getString("name") + ", Relation: " + member.getString("relation") + ", DOB: " + member.getString("dob"));
//		 }

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);

			String query = "insert into cust_table values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, firstName);
			ps.setString(2, middleName);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setString(5, mobileNum);
			ps.setString(6, alternateNum);
			ps.setString(7, address);
			ps.setString(8, gender);
			ps.setString(9, maritalStatus);
			ps.setString(10, dob);
			ps.setString(11, anniversaryDate);
			ps.setString(12, spouseName);
			ps.setString(13, spouseDob);
			ps.setString(14, fatherName);
			ps.setString(15, fatherDob);
			ps.setString(16, motherName);
			ps.setString(17, motherDob);

			ps.setString(18, members.toString());

			ps.setString(19, reference);

			int count = ps.executeUpdate();

			if (count > 0) {
//				request.setAttribute("customerRegnStatus", "success");
				System.out.print("customerRegnStatus -- success");

				// mail

				// data retrieval
			} else {
//				request.setAttribute("customerRegnStatus", "failed");
				System.out.print("customerRegnStatus -- failed");

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
