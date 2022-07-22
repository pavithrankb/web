package com.todo;
import java.sql.*;


public class connectDB {
	public static void main(String[] args) {
		connectDB obj = new connectDB();
		System.out.println(obj.get_conn());

	}
    public Connection get_conn() {
    	
        Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="todo";
        String username="postgres";
        String password="password";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
                System.out.println("connection done"+connection);
            } else {
                System.out.println("nothing came");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return connection;
    }


	public ResultSet viewlist() {
		
		{
			
			Connection conn=null;
			PreparedStatement statement=null;
			ResultSet rs=null;
			connectDB obj = new connectDB();
			System.out.println(obj.get_conn());
			conn=obj.get_conn();
			
//				String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
				try {
					
					statement=conn.prepareStatement("select* from todolist");


					rs=statement.executeQuery();
					System.out.println("fetched");
					conn.close();

				} 
				catch (SQLException e) {

					e.printStackTrace();
				}
				return rs;		
		}
	}
	public void removeitem(String x) {
		{
	    	Connection conn=null;
	    	PreparedStatement statement=null;
	    	connectDB obj = new connectDB();
	    	System.out.println(obj.get_conn());
	    	conn=obj.get_conn();
	    	System.out.println(conn+"no connection?");
	    	
//	    		String  query=String.format("insert into bus(bus_no,owner_username,source,dest,cost,total_seats,available_seats,bus_name) values('%s','%s','%s','%s',%d,%d,%d,'%s')",busno,username,sourcee,destt,fare,totalseats,freeseats,busname);
	    		try {
	    			statement=conn.prepareStatement("delete from todolist where item=?");
	    			statement.setString(1, x);
	   

	    			statement.executeUpdate();
	    			System.out.println("new user added added");
	    			conn.close();
	    		} catch (SQLException e) {

	    			e.printStackTrace();
	    		}
	        
	    	
	    }
		// TODO Auto-generated method stub
		
	}
	public void additem(String x) {
    	Connection conn=null;
    	PreparedStatement statement=null;
    	connectDB obj = new connectDB();
    	System.out.println(obj.get_conn());
    	conn=obj.get_conn();
    	System.out.println(conn+"no connection?");
    	
//    		String  query=String.format("insert into bus(bus_no,owner_username,source,dest,cost,total_seats,available_seats,bus_name) values('%s','%s','%s','%s',%d,%d,%d,'%s')",busno,username,sourcee,destt,fare,totalseats,freeseats,busname);
    		try {
    			statement=conn.prepareStatement("insert into todolist(item) values(?)");
    			statement.setString(1, x);
   

    			statement.executeUpdate();
    			System.out.println("new user added added");
    			conn.close();
    		} catch (SQLException e) {

    			e.printStackTrace();
    		}
        
    	
    }
}
