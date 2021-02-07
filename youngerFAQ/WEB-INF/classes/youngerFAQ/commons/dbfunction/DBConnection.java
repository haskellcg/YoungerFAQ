package youngerFAQ.commons.dbfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	private final String URL = "jdbc:mysql://localhost:3306/youngerFAQ?useUnicode=true&characterEncoding=utf-8";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String USER = "root";
	private final String PWD = "";
	
	
	@SuppressWarnings("null")
	public Connection  getConnection(){
		
		
		Connection conn =null;
		try{
			
			Class.forName(DRIVER);
			
				try{
					
					conn= DriverManager.getConnection(URL, USER, PWD);
				}catch(SQLException sqlEx){
					try{
						conn.close();
					}catch(SQLException sqlEx2){
						sqlEx2.printStackTrace();
					}
				}
		}catch(ClassNotFoundException notFoundEx){
			
			notFoundEx.printStackTrace();
		}

		return conn;

	}
	
	@SuppressWarnings("null")
	public PreparedStatement getPreparedStatement(String sql){
			
		Connection conn=getConnection();
			
		PreparedStatement preparedSm=null;
		
		try{
			
			preparedSm=conn.prepareStatement(sql);
			
		}catch(SQLException sqlEx3){
			
			try{
				preparedSm.close();
			}catch(SQLException sqlEx4){
				sqlEx4.printStackTrace();
			}
			
		}
		
		return preparedSm;
		
		
	
	}
	
	// 调试函数
	public void testPrintTable(String tableName) throws SQLException{
		
		String sql="select user_id,user_name from younger_user_info where user_id="+"33";
		PreparedStatement ps=getPreparedStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
				
				System.out.print(rs.getInt("user_id")+"\t");
				System.out.print(rs.getString("user_name")+"\t");
				
				System.out.println();
		}
		
	}
	
	public static void main(String []args) throws ClassNotFoundException, SQLException{
		
		DBConnection db=new DBConnection();
		db.testPrintTable("younger_user_info");
		
	}
}
