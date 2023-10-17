package com.webcam.java;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Getimage")
public class Getimage extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imageDataAndId = getImageData();
	    if (imageDataAndId != null) {
	       String[] data = imageDataAndId.split("\\|");
	        request.setAttribute("id", data[0]); // Set the ID attribute
	        request.setAttribute("images", data[1]); // Set the image data attribute
	    } else {
	        request.setAttribute("id", ""); // Set an empty string if no image found
	        request.setAttribute("images", ""); // Set an empty string if no image found
	    }
	    request.getRequestDispatcher("Registeration.jsp").forward(request, response);
	}
	           
	private String getImageData() {
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abu","root","root");
	        Statement statement = con.createStatement();
	        ResultSet rs = statement.executeQuery("SELECT * FROM registerform ORDER BY id DESC LIMIT 1");
	        if (rs.next()) {										
	            int id = rs.getInt("id");
	            byte[] barr = rs.getBytes("pic");
	            if (barr != null && barr.length > 0) {
	                String ss = Base64.getEncoder().encodeToString(barr);//most important line
	                return id + "|" + "data:image/jpg;base64," + ss; // Combine ID and image data
	            } else {
	                return null; // no image in found
	            }
	        } else {
	            return null; // No image found in found
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
