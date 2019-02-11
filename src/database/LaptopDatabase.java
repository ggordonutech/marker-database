package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Laptop;

public class LaptopDatabase 
    extends SQLProvider<Laptop>
{

	private static final String TABLE_NAME = "lb5_laptops";

	@Override
	protected void initSQLDatabase() {
		try {
			statement = con.createStatement();
			if (statement
					.execute("create table if not exists "
							+ TABLE_NAME
							+ " (id INTEGER PRIMARY KEY AUTOINCREMENT, model varchar(50) )")) {
				//logger.debug("ITEM table created");
			} else {
				//logger.debug("ITEM table does not need to be created");
			}
			//logger.debug("ITEM table exists");
		} catch (SQLException e) {
			e.printStackTrace();
			//logger.error("Unable to initialize SQL Database", e);
		}

	}

	@Override
	public List<Laptop> selectAll() {
		List<Laptop> items = new ArrayList<Laptop>();
		try {
			Statement statement = con.createStatement();
			String sql = "select id, model from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
					Laptop laptop = new Laptop();
					laptop.setId( rs.getInt("id") );
					laptop.setModel( rs.getString("model") );
					items.add(laptop);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Laptop get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Laptop item, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMultiple(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Laptop item) {
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(model)  VALUES (?) ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, item.getModel());
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			//logger.error("Unable to add marker",e);
		}
		
		return 0;
	}

}
