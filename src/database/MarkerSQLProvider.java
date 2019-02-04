package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.Marker;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.//logger;

public class MarkerSQLProvider extends SQLProvider<Marker> {

//	private static //logger //logger = LogManager.get//logger(MarkerSQLProvider.class);

	public static final String TABLE_NAME = "lb6_marker";

	public MarkerSQLProvider() {
		super();

	}

	@Override
	protected void initSQLDatabase() {
		try {
			statement = con.createStatement();
			if (statement
					.execute("create table if not exists "
							+ TABLE_NAME
							+ " (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(50) )")) {
				//logger.debug("ITEM table created");
			} else {
				//logger.debug("ITEM table does not need to be created");
			}
			//logger.debug("ITEM table exists");
		} catch (SQLException e) {
			//logger.error("Unable to initialize SQL Database", e);
		}

	}

	@Override
	public List<Marker> selectAll() {
		List<Marker> items = new ArrayList<Marker>();

		try {
			statement = con.createStatement(); // create SQL statement
			String query = "SELECT * FROM " + TABLE_NAME; // specify query to
															// pull all
			// records
			//logger.debug(query);
			result = statement.executeQuery(query); // execute query

			while (result.next()) // while records were retrieved and unread
			// results
			{
				Marker item = new Marker(); // declare new Student
				item.setId(result.getInt(1)); // get ID column 1
				item.setName(result.getString(2)); // get Name  2

				items.add(item);
				
			}
			//logger.debug("Retrieved "+items.size()+" markers");
		} catch (SQLException e) {
			//logger.error("Unable to retrieve markers",e);

		}
		return items;

	}

	@Override
	public Marker get(int id) {
		Marker item = null;
		try{
			statement = con.createStatement();
			String query = "select * from "+TABLE_NAME+" where id = "+id+";";
			//logger.debug("QUERY : "+query);
			result = statement.executeQuery(query);
			while(result.next()){
				item = new Marker();
				item.setId(result.getInt(1)); // get ID column 1
				item.setName(result.getString(2)); // get Name  2
			}
			
			return item;
			
			
		}catch(SQLException e){
			//logger.error("Unable to retrieve marker with id "+id,e);
				
		}
		return item;
		
	}

	@Override
	public int update(Marker item, int id) {
		try{
			String query = "UPDATE "+TABLE_NAME
					       + " SET name = ? "
					       + " WHERE id = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, item.getName());
			ps.setInt(2, id);
			return ps.executeUpdate();
					
    	}catch(SQLException e){
			//logger.error("Unable to update marker with id "+id,e);
		}
		
		return 0;
	}

	@Override
	public int delete(int id) {
		try{
			String query = "DELETE FROM "+TABLE_NAME
					       + " WHERE id = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			return ps.executeUpdate();
					
    	}catch(SQLException e){
			//logger.error("Unable to delete marker with id "+id,e);
		}
		
		return 0;
	}

	@Override
	public int add(Marker item) {
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(name)  VALUES (?) ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, item.getName());
			return ps.executeUpdate();
					
    	}catch(SQLException e){
			//logger.error("Unable to add marker",e);
		}
		
		return 0;
	}

	@Override
	public int deleteMultiple(int[] ids) {
		try{
			String IdsConcatenated = Arrays.toString(ids).replace("[","").replace("]","");
			String query = "DELETE FROM "+TABLE_NAME
					       + " WHERE id in ("+IdsConcatenated+") ";
			PreparedStatement ps = con.prepareStatement(query);
			
			return ps.executeUpdate();
					
    	}catch(SQLException e){
			//logger.error("Unable to delete markers with ids : "+Arrays.toString(ids),e);
		}
		
		return 0;
	}

}
