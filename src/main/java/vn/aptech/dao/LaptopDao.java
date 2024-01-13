package vn.aptech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.aptech.entity.Laptop;

public class LaptopDao {
	private Connection connectDb() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/demo";
		return DriverManager.getConnection(url, "root", "");
	}

	public List<Laptop> findAll() {
		List<Laptop> result = new ArrayList<>();
		try {
			Connection con = connectDb();
			String query = "SELECT * FROM laptops";
			PreparedStatement stm = con.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Laptop lt = new Laptop();
				lt.setId(rs.getInt(1));
				lt.setName(rs.getString(2));
				lt.setPrice(rs.getInt(3));
				lt.setDescription(rs.getString(4));
				lt.setImage(rs.getString(5));
				result.add(lt);
			}
			rs.close();
			stm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Laptop> findByPrice(int min, int max) {
		List<Laptop> result = new ArrayList<>();
		try {
			Connection con = connectDb();
			String query = "SELECT * FROM laptops WHERE price BETWEEN ? AND ?";
			PreparedStatement stm = con.prepareStatement(query);
			// gán giá trị cho tham số ?
			stm.setInt(1, min);
			stm.setInt(2, max);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Laptop lt = new Laptop();
				lt.setId(rs.getInt(1));
				lt.setName(rs.getString(2));
				lt.setPrice(rs.getInt(3));
				lt.setDescription(rs.getString(4));
				lt.setImage(rs.getString(5));
				result.add(lt);
			}
			rs.close();
			stm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean create(Laptop lt) {
		boolean result = false;
		try {
			Connection con = connectDb();
			String query = "INSERT INTO laptops (name, price, description) VALUES (?,?,?)";
			PreparedStatement stm = con.prepareStatement(query);
			// gán giá trị cho tham số ?
			stm.setString(1, lt.getName());
			stm.setInt(2, lt.getPrice());
			stm.setString(3, lt.getDescription());
			result = stm.executeUpdate() > 0;

			stm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
