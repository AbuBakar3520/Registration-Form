package com.webcam.java;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.mysql.cj.jdbc.Blob;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@WebServlet("/WebcamApplication")
public class WebcamApplication extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	run();
		req.getRequestDispatcher("Registeration.jsp").include(req, response);
	}
	boolean isRunning = false;
	private Webcam webcam;
	private JFrame window;

	public void run() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {
		webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		WebcamPanel panel = new WebcamPanel(webcam);	
		panel.setFPSDisplayed(true);
		panel.setImageSizeDisplayed(true);
		JButton captureButton = new JButton("Capture");
		captureButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!isRunning) {
						isRunning = true;
						capturePhoto();				
					} else {
						isRunning = false;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		this.window = new JFrame();
		window.setLayout(new BorderLayout());
		window.add(panel, BorderLayout.CENTER);
		window.add(captureButton, BorderLayout.SOUTH);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.pack();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int windowWidth = window.getWidth();
		int windowHeight = window.getHeight();
		int x = (screenWidth - windowWidth) / 2;
		int y = (screenHeight - windowHeight) / 2;
		window.setLocation(x, y);
		window.setVisible(true);
		
		
		int delay = (int) TimeUnit.SECONDS.toMillis(15); // 15 seconds delay
		Timer timer = new Timer(delay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!webcam.isOpen()) {
					return;
				}
				webcam.close();
				window.dispose();
				System.out.println("Webcam closed automatically.");
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

	private void insertingDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abu", "root", "root");

			String q = "INSERT INTO registerform (pic) VALUES (?)";
			PreparedStatement statement = con.prepareStatement(q);
			File photoFile = new File("C:\\Users\\admin\\Downloads\\Imagefolder\\mypic.jpg");
			FileInputStream fis = new FileInputStream(photoFile);
			statement.setBinaryStream(1, fis, fis.available());
			statement.executeUpdate();
			System.out.println("Photo inserted successfully.");
			statement.close();
			fis.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		  }
	 }
	
	private void capturePhoto() throws InterruptedException {
        try {
            BufferedImage image = webcam.getImage();
            String filePath = "C:\\Users\\admin\\Downloads\\Imagefolder\\mypic.jpg";
            ImageIO.write(image, "JPG", new File(filePath));
            insertingDatabase();
            System.out.println("Photo captured and saved successfully!");
            Thread.sleep(1000);
            webcam.close();
            window.dispose();
            isRunning=false;
        } catch (IOException e) {
            System.out.println("Error capturing photo: " + e.getMessage());
        }
    }
}