package hadoop.hive.Git;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class SQLCreateTable {
   
   public static void main(String[] args) throws SQLException {
   
	   
	   /* Connexion à la base de données */
	   String url = "jdbc:mysql://localhost:3306/yourDB";
	   String user = "user";
	   String password = "";
	   Connection connexion = null;
	   
	   
	   try {
	       connexion = DriverManager.getConnection( url, user, password );
	       

	   } catch ( SQLException e ) {
		   System.out.println("Cannot connect to database");
		   
	   } 
	   
      
      Statement stmt = connexion.createStatement();
    
      
      stmt.execute("CREATE TABLE IF NOT EXISTS "
    	         +" employee2 ( eid int, name String, "
    	         +" salary String, destignation String)"
    	         +" ROW FORMAT DELIMITED"
    	         +" FIELDS TERMINATED BY '\t'"
    	         +" LINES TERMINATED BY '\n'"
    	         +" STORED AS TEXTFILE");
         
      System.out.println(" Table employee created.");
      

      if ( connexion != null )
          try {
              
              connexion.close();
          } catch ( SQLException ignore ) {
              
       	   System.out.println("Cannot close the connection");
          }
      
      
   }
}