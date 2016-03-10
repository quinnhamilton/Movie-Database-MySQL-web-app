package com.testSpring1.dbcontroller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class listMovies {
	
	@RequestMapping("/moviedatabase")
	public ModelAndView listData() {
		
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver"); //load the driver, make sure catch statement is "Exception" to cover all exceptions
		
			Connection c; //create connection string
			String connectionString = "jdbc:mysql://localhost:3306/moviedatabase";
			c = DriverManager.getConnection(connectionString, "root", "admin123"); //with root and password
			
			Statement s = c.createStatement(); //create statement
			
			ResultSet results = s.executeQuery("select * from movies"); //execute query
			
			ArrayList<String> movie_name = new ArrayList<>(); //store customerID info in Array List
			
			
			while (results.next()) { 
				
				movie_name.add(results.getString(1)); //start from column 1 in database
			}
			
			
			return new ModelAndView("moviedatabase", "mList", movie_name); //return ModelAndView
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return new ModelAndView("error", "errorMessage", e.getMessage());
		}
	}
	
	@RequestMapping("/listByGenre")
	public ModelAndView listByGenre(@RequestParam ("genre")String genre) {
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection c;
			String connectionString = "jdbc:mysql://localhost:3306/moviedatabase";
			c = DriverManager.getConnection(connectionString, "root", "admin123");
			
			Statement s = c.createStatement();
			
			ResultSet results = s.executeQuery("select * from movies where movie_category='" + genre +"'" );
			
			ArrayList<String> movie_category = new ArrayList<>();
			
			while (results.next()) {
				
				movie_category.add(results.getString(1));
			}
			
			return new ModelAndView("listByGenre", "mList", movie_category);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return new ModelAndView("error", "errorMessage", e.getMessage());
		}
	}

}

