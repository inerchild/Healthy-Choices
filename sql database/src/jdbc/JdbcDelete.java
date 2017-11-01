package jdbc;

import java.sql.ResultSet;
import java.util.Observer;

import javafx.scene.layout.Pane;
import nine.maze.MazeManager;



//public class JdbcDelete extends Jdbc;

 //delete record code here part of 4
	
	/* {
		private MazeManager mazeManager;
		public void setMazeManager(MazeManager aMgr) { 
			mazeManager = aMgr;
		}  */

    // Execute a query
     System.out.println("Creating (delete) statement...");
    //invoked method stmt
     stmt = conn.createStatement();
    
     String sql = "DELETE FROM patient_info " +
                  "WHERE patient_id = 100";
     //method stmt
     stmt.executeUpdate(sql);

     // Now you can extract all the records
     // to see the remaining records
     sql = "SELECT patient_id, first-name, last_name, FROM patient_info";
    //here a method rs is called
     ResultSet rs = stmt.executeQuery(sql);	
	
}
