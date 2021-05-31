import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import Bridge.databaseBridgeConnect;

public class databaseController {

	Connection connection;

	public databaseController() {
		try {
			initConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initConnection() throws SQLException {
		connection = databaseBridgeConnect.connect();
		if (connection == null) {
			throw new SQLException("Connection");
		}
	}

	public Vector<Vector<String>> getMenuData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from bobacool";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Vector<String> rows = new Vector<>();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				data.add(rows);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void createNewElementDatabase(String kode, String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "INSERT INTO bobacool " + "VALUES ('" + kode + "', '" + nama + "', '" + harga + "', '" + stok + "')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Success insert data");
			System.out.println("Insert success. Please check you database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteElementDatabase(String kode) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "DELETE FROM bobacool " + 
					"WHERE id = '"+kode+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Success delete data");
			System.out.println("Delete success. Please check you database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateElementDatabase(String kode, String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "UPDATE bobacool " + 
					"SET Nama = '" + "BobaTea" + "', Harga = '" + "27000" + "', Stok = '" + "14" + "' WHERE id = '"+"BC-833"+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Success update data");
			System.out.println("Update success. Please check you database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}