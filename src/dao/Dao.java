package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao { 
	public Connection con=null;
	public ResultSet rs = null;
	public PreparedStatement stmtPrep=null; 
	public String sql;
	
	public Connection yhdista() throws Exception{
    	Connection con = null;    	        	
    	String JDBCAjuri = "org.mariadb.jdbc.Driver";
    	String url = "jdbc:mariadb://localhost:3306/a1700477";        	
   	    Class.forName(JDBCAjuri);
	    con = DriverManager.getConnection(url,"a1700477", "liTAaI75u");	        
	    return con;	    
	}
	
	public void sulje() throws Exception{
		if(con!=null){			
			con.close();			
		}		
	}		
}
