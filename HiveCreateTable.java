package hadoop.hive.Git;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveCreateTable {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws SQLException {

		// Register driver and create driver instance
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println(" Error------");
			e.printStackTrace();
		}
		System.out.println("Done! 1");
		// get connection

		Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/dataBaseName", "the_user", "");

		// create statement
		Statement stmt = con.createStatement();


		 stmt.execute("CREATE TABLE IF NOT EXISTS "
		 +" employee2 ( eid int, name String, "
		  +" salary String, destignation String)" +" ROW FORMAT DELIMITED"
		  +" FIELDS TERMINATED BY '\t'" +" LINES TERMINATED BY '\n'"
		  +" STORED AS TEXTFILE");
		

		System.out.println(" Table employee created.");

		con.close();
	}
}