package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Marker;
import entity.Phone;

public class PhoneDatabase
   extends SQLProvider<Phone>
{

	private static final String TABLE_NAME ="lb5_phone";

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

	public List<Phone> selectAll() {
		List<Phone> items = new ArrayList<Phone>();

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
				Phone item = new Phone(); // declare new Student
				item.setId(result.getInt(1)); // get ID column 1
				item.setModel(result.getString(2)); // get Model  2

				items.add(item);
				
			}
			//logger.debug("Retrieved "+items.size()+" markers");
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return items;

	}


	@Override
	public Phone get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Phone item, int id) {
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
	public int add(Phone item) {
		String query = "INSERT INTO "+TABLE_NAME
				      +" (model) values (?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, item.getModel());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
