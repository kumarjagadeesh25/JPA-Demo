package com.zonray.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class CreateTable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		OracleDriver driver = new OracleDriver();
		try {
			DriverManager.registerDriver(driver);
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "jpa", "jpa");
			Statement statement = connection.createStatement();
			System.out.print("Table Name: ");
			String tableName=scanner.next();
			String query="create table "+tableName+"(no number,name varchar2(20))";
			statement.executeUpdate(query);
			
			System.out.println("table has created....");
			
			statement.close();
			connection.close();
			scanner.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

}
