package com.zonray.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class InsertDataIntoTable {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		try {
			DriverManager.registerDriver(new OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "jpa", "jpa");
			Statement statement = connection.createStatement();
			
			ResultSet tableList = statement.executeQuery("select OBJECT_NAME from user_objects where OBJECT_TYPE='TABLE'");
			

			System.out.println("Schema: "+connection.getSchema());
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("TablesList :\n");
			while(tableList.next()) {
				for(int i=1;tableList.next();i++) {
					System.out.println(i+"."+tableList.getString(1));
				}
			}
			System.out.println("---------------------------------------------------------------------------------");
			tableList.close();
			System.out.println();
			
			System.out.print("table name: ");
			String tableName=scanner.next();

			ResultSet tableDetails = statement.executeQuery("select * from "+tableName+"");
			System.out.println("\n---------------------------------------------------------------------------------");
			int i=1;
			System.out.print("Columns:  ");
			while(i<=tableDetails.getMetaData().getColumnCount()) {
					System.out.print(tableDetails.getMetaData().getColumnName(i)+"\t");
					i++;
			}
			
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.println("Enter following Data...\n***************");
			
			System.out.print(tableDetails.getMetaData().getColumnName(1)+": ");
			String no=scanner.next();
			System.out.print(tableDetails.getMetaData().getColumnName(2)+": ");
			String name=scanner.next();
			
			System.out.println();
			String query="insert into "+tableName+" values("+no+",'"+name+"')";
			statement.executeUpdate(query);
			System.out.println("****************\n Data Inserted...");
			
			statement.close();
			connection.close();			
			scanner.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
