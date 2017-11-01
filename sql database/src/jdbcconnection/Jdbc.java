package jdbcconnection;

import java.sql.*;
import java.util.ArrayList;
//make sure to create class for comparable separate

public class Jdbc {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/emr";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "java";
   
   ArrayList<Patient>patient_names=new ArrayList<Patient>();
   
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
//enter names of columns for first table since you only can upload one table at a time but you do not have to name the table because it will find it, but dont put order by clause since you order afterwards in eclipse

      String sql = "SELECT max(patient_id) as //alias goes here, From patient_info";
      ResultSet rs = stmt.executeQuery(sql);
      
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name, modify data type based on column data for patient_id for example
         int patient_id  = rs.getInt("patient_id");
         String state = rs.getString("state");
         String first_name = rs.getString("first_name");
         String last_name = rs.getString("last_name");

         //Display values
         System.out.print("PATIENT_ID: " + patient_id);
         System.out.print(", STATE: " + state);
         System.out.print(", FIRST_NAME: " + first_name);
         System.out.println(", LAST_NAME: " + last_name);
      }
      
      //put collections.sort features here, create 2 sorting 2 columns
      
      
      
     //Step 6 clean up environment 
      rs.close();
      stmt.close();
      conn.close();
          
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample