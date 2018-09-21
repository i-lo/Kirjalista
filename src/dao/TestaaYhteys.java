package dao;

public class TestaaYhteys {

	public static void main(String[] args) {
		
		Dao dao = new Dao();
		dao.sql = "SELECT * FROM aanite"; 	
		try {
			dao.con=dao.yhdista();
			dao.stmtPrep = dao.con.prepareStatement(dao.sql);        		
    		dao.rs = dao.stmtPrep.executeQuery();
    		dao.rs.next();
    		System.out.println(dao.rs.getString("nimi"));
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		
		

	}

}
