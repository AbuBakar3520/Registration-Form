package com.RegisterationForm.controller.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.mysql.ConnectionUtil;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
@WebServlet("/RegisterForm")
public class RegisterationForm extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String pic = req.getParameter("pic");
		String date = req.getParameter("date");
		String applicantName = req.getParameter("applicantName");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String maritalStatus = req.getParameter("maritalStatus");
		String dob = req.getParameter("dob");
		String pan = req.getParameter("pan");
		String aadhar = req.getParameter("aadhar");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String qualification = req.getParameter("qualification");
		String SSC = req.getParameter("SSC");
		String SSC_Percentage = req.getParameter("SSC_Percentage");
		String SSC_Year = req.getParameter("SSC_Year");
		String HSC = req.getParameter("HSC");
		String HSC_Percentage = req.getParameter("HSC_Percentage");
		String HSC_Year = req.getParameter("HSC_Year");
		String Graduate = req.getParameter("Graduate");
		String Graduate_Percentage = req.getParameter("Graduate_Percentage");
		String Graduate_Year = req.getParameter("Graduate_Year");
		String Post_Graduate = req.getParameter("Post_Graduate");
		String Post_Graduate_Percentage = req.getParameter("Post_Graduate_Percentage");
		String Post_Graduate_Year = req.getParameter("Post_Graduate_Year");
		String sign = req.getParameter("sign");
		try {
			Connection con = ConnectionUtil.getConnection();
			String query = "UPDATE registerform SET Date = ?, name = ?, address = ?, gender = ?, maritalstatus = ?, dob = ?, pancard_detail = ?, aadhar_detail = ?, email_detail = ?, phone_detail = ?, qulification_detail = ?, ssc_detail = ?, ssc_percentage = ?, ssc_year = ?, hsc = ?, hsc_percentage = ?, hsc_year = ?, graduate = ?, graduate_percentage = ?, graduate_year = ?, post_graduate = ?, post_graduate_percentage = ?, post_graduate_year = ?, sign_detail = ? WHERE id= (SELECT * FROM (SELECT id FROM registerform ORDER BY id DESC LIMIT 1) AS temp)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, date);
			statement.setString(2, applicantName);
			statement.setString(3, address);
			statement.setString(4, gender);
			statement.setString(5, maritalStatus);
			statement.setString(6, dob);
			statement.setString(7, pan);
			statement.setString(8, aadhar);
			statement.setString(9, email);
			statement.setString(10, phone);
			statement.setString(11, qualification);
			statement.setString(12, SSC);
			statement.setString(13, SSC_Percentage);
			statement.setString(14, SSC_Year);
			statement.setString(15, HSC);
			statement.setString(16, HSC_Percentage);
			statement.setString(17, HSC_Year);
			statement.setString(18, Graduate);
			statement.setString(19, Graduate_Percentage);
			statement.setString(20, Graduate_Year);
			statement.setString(21, Post_Graduate);
			statement.setString(22, Post_Graduate_Percentage);
			statement.setString(23, Post_Graduate_Year);
			statement.setString(24, sign);
			int rowsAffected = statement.executeUpdate();
			generate_Pdf();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	public static void generate_Pdf() {
	    try {
	    	Paragraph spaceParagraph = new Paragraph();
	    	
	        String filename = "C:\\Users\\admin\\Downloads\\downloadpdf\\student.pdf";
	        Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream(filename));
	        document.open();
	        Connection con = ConnectionUtil.getConnection();
	        PreparedStatement statement = con.prepareStatement("SELECT id, pic, Date, name, address, gender, maritalstatus, dob, pancard_detail, aadhar_detail, email_detail, phone_detail, qulification_detail, ssc_detail, ssc_percentage, ssc_year, hsc, hsc_percentage, hsc_year, graduate, graduate_percentage, graduate_year, post_graduate, post_graduate_percentage, post_graduate_year, sign_detail FROM registerform ORDER BY id DESC LIMIT 1");
	        ResultSet rs = statement.executeQuery();
	        
	        Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
	        Paragraph heading = new Paragraph("Registeration Form", headingFont);
	        heading.setAlignment(Element.ALIGN_CENTER);
	        document.add(heading);

	        Font headingFont1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.RED);
	        Paragraph heading1 = new Paragraph("Techskills IT Solution", headingFont1);
	        heading1.setAlignment(Element.ALIGN_CENTER);
	        document.add(heading1);

	        Font headingFont11 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
	        Paragraph heading11 = new Paragraph("A-101, First Floor, Above A-20, Sakinaka Industrial Market,\nBeside Holiday Inn Hotel Ghatkopar-Andheri Link Road,\nSakinaka, Andheri(E), Mumbai-400072\n\n", headingFont11);
	        heading11.setAlignment(Element.ALIGN_CENTER);
	        document.add(heading11);
	        
	        spaceParagraph.setSpacingAfter(40f); // Set the spacing before the paragraph to create space
	        // Define table properties
	        PdfPTable table = new PdfPTable(2);
	        table.setWidthPercentage(100);
	        float[] columnWidths = {1f, 3f}; // Adjust column widths as needed
	        table.setWidths(columnWidths);
	        Paragraph paragraph = new Paragraph();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            byte[] imageData = rs.getBytes("pic");
	            String date = rs.getString("Date");
	            String name = rs.getString("name");
	            String address = rs.getString("address");
	            String gender = rs.getString("gender");
	            String maritalStatus = rs.getString("maritalstatus");
	            String dob = rs.getString("dob");
	            String pancard = rs.getString("pancard_detail");
	            String aadhar = rs.getString("aadhar_detail");
	            String email = rs.getString("email_detail");
	            String phone = rs.getString("phone_detail");
	            String qualification = rs.getString("qulification_detail");
	            String ssc = rs.getString("ssc_detail");
	            String sscPercentage = rs.getString("ssc_percentage");
	            String sscYear = rs.getString("ssc_year");
	            String hsc = rs.getString("hsc");
	            String hscPercentage = rs.getString("hsc_percentage");
	            String hscYear = rs.getString("hsc_year");
	            String graduate = rs.getString("graduate");
	            String graduatePercentage = rs.getString("graduate_percentage");
	            String graduateYear = rs.getString("graduate_year");
	            String postGraduate = rs.getString("post_graduate");
	            String postGraduatePercentage = rs.getString("post_graduate_percentage");
	            String postGraduateYear = rs.getString("post_graduate_year");
	            String sign = rs.getString("sign_detail");
	            
	            Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);  
	            Paragraph p2 = new Paragraph();
	            Font f = new Font();
	            f.setStyle(Font.BOLD);
	            f.setSize(8);
              
	            // Retrieve the ID value from the database
	            // Assuming the variable id1 holds the ID value

	            String formNo = "Form No: " + id;
	            p2.add(new Chunk(formNo, labelFont)); // Add the form number to the paragraph
	            document.add(p2); 
	            Font labelFont1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);  
	            Paragraph p21 = new Paragraph();
	            Font f1 = new Font();
	            f1.setStyle(Font.BOLD);
	            f1.setSize(8);
	             // Retrieve the ID value from the database
	            // Assuming the variable id1 holds the ID value
	            Paragraph blankParagraph = new Paragraph("\n");
		          document.add(blankParagraph);
		           
	            
	            String formNo1 = "Date: " + date;
	            p21.add(new Chunk(formNo1, labelFont1)); // Add the form number to the paragraph
	            document.add(p21);
	            
	            // Create an empty cell for spacing
	            PdfPCell emptyCell = new PdfPCell();
	            emptyCell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(emptyCell);

	         //    Create a PdfPCell for the image
	            Image image = Image.getInstance(imageData);
	            image.scaleToFit(170f, 170f);
	            PdfPCell imageCell = new PdfPCell(image);
	            imageCell.setBorder(Rectangle.NO_BORDER);
	            imageCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	            imageCell.setVerticalAlignment(Element.ALIGN_RIGHT);
	            table.addCell(imageCell);
	            
	         //  Paragraph blankParagraph = new Paragraph("\n");
	          // document.add(blankParagraph);
	           
	           //spaceParagraph.setSpacingBefore(20f);
           
	            table.addCell(new PdfPCell(new Phrase("Name:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(name, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Address:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(address, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Gender:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(gender, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Marital Status:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(maritalStatus, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Date of Birth:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(dob, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Pancard:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(pancard, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Aadhar:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(aadhar, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Email:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(email, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Phone:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(phone, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Qualification:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(qualification, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("SSC:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(ssc, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("SSC Percentage:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(sscPercentage, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("SSC Year:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(sscYear, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("HSC:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(hsc, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("HSC Percentage:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(hscPercentage, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("HSC Year:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(hscYear, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Graduate:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(graduate, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Graduate Percentage:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(graduatePercentage, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Graduate Year:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(graduateYear, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Post Graduate:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(postGraduate, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Post Graduate Percentage:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(postGraduatePercentage, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Post Graduate Year:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(postGraduateYear, labelFont1)));

	            table.addCell(new PdfPCell(new Phrase("Signature:", labelFont1)));
	            table.addCell(new PdfPCell(new Phrase(sign, labelFont1)));
	            
	            document.add(paragraph);
	        }
	        // Add the table to the PDF document
	        document.add(table);

	        document.close();
	        System.out.println("PDF created");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
	

