package PetMain;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import PetMain.util.SystemConstant;

public class PetDAO {
	String dbURL = SystemConstant.URL;

	public PetDAO() {
		super();
	}

	public PetDAO(String dbURL) {
		super();
		this.dbURL = dbURL;
	}
//
	public int insert(PetBean pb) {
		int n = 0;
		String sql = "INSERT INTO Pet " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//對應SQL的個欄位及型態
			pstmt.setInt(1, pb.getId());
			pstmt.setString(2, pb.getPetName());
			pstmt.setString(3, pb.getMasterName());
			pstmt.setString(4, pb.getBirthday());
			pstmt.setDouble(5, pb.getPrice()); 
			pstmt.setDouble(6, pb.getWeight()); 
			pstmt.setString(7, pb.getFilename());
			pstmt.setBytes(8, pb.getPicture());
			SerialClob clob = new SerialClob(pb.getComment());
			pstmt.setClob(9, clob);
			n = pstmt.executeUpdate();
			System.out.println("表格記錄成功, id=" + pb.getId());
		} catch (SQLException ex) {
			System.out.println(ex.getSQLState() + " " + pb.getId());
			ex.printStackTrace();
		}
		return n;
	}

	public int update(PetBean pb) {
		int n = 0;
		String sql = "UPDATE Pet set Id = ?, PetName = ?, MasterName=?, " + " Birthday =?, Price = ?, Weight= ?, "
				+ " Filename = ?, picture = ?, comment =? " + " WHERE Id= ?";
		try (Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, pb.getId());
			pstmt.setString(2, pb.getPetName());
			pstmt.setString(3, pb.getMasterName());
			pstmt.setString(4, pb.getBirthday());
			pstmt.setDouble(5, pb.getPrice());
			pstmt.setDouble(6, pb.getWeight());
			pstmt.setString(7, pb.getFilename());
			pstmt.setBytes(8, pb.getPicture());
			SerialClob clob = new SerialClob(pb.getComment());
			pstmt.setClob(9, clob);
			pstmt.setInt(10, pb.getId());
			n = pstmt.executeUpdate();
			System.out.println("表格修改成功, id=" + pb.getId());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return n;
	}

	public int delete(PetBean pb) {
		return delete(pb.getId());
	}

	public int delete(int key) {
		int n = 0;
		String sql = "DELETE FROM pet WHERE Id = ?";
		try (Connection con = DriverManager.getConnection(SystemConstant.URL);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, key);
			n = pstmt.executeUpdate();
			System.out.println("刪除紀錄成功");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return n;
	}

	public PetBean findByPrimaryKey(int key) {
		String sql = "SELECT * FROM pet " + "WHERE Id = ?";
		PetBean pb = null;
		try (Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, key);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					pb = new PetBean();
					pb.setId(rs.getInt(1));
					pb.setPetName(rs.getString(2));
					pb.setMasterName(rs.getString(3));
					pb.setBirthday(rs.getString(4));
					pb.setPrice(rs.getDouble(5));
					pb.setWeight(rs.getDouble(6));
					pb.setFilename(rs.getString(7));
					pb.setPicture(rs.getBytes(8));
					pb.setComment(clobToCharArray(rs.getClob(9)));
				}
			}
			System.out.println("查詢記錄成功, id=" + pb.getId());
		} catch (SQLException ex) {
			System.out.println(ex.getSQLState() + " " + pb.getId());
			ex.printStackTrace();
		}
		return pb;
	}

	private char[] clobToCharArray(Clob clob) {
		try (Reader rd = clob.getCharacterStream(); CharArrayWriter caw = new CharArrayWriter();) {
			char[] ca = new char[8192];
			int len = 0;
			while ((len = rd.read(ca)) != -1) {
				caw.write(ca, 0, len);
			}
			char[] output = caw.toCharArray();
			return output;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<PetBean> findAll() {
		List<PetBean> list = new ArrayList<>();
		String sql = "SELECT * FROM pet WHERE Id ";
		try (Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					PetBean pb = new PetBean();
					pb.setId(rs.getInt(1));
					pb.setPetName(rs.getString(2));
					pb.setMasterName(rs.getString(3));
					pb.setBirthday(rs.getString(4));
					pb.setPrice(rs.getDouble(5));
					pb.setWeight(rs.getDouble(6));
					pb.setFilename(rs.getString(7));
					pb.setPicture(rs.getBytes(8));
					pb.setComment(clobToCharArray(rs.getClob(9)));
					list.add(pb);
				}
			}
//			catch(FileNotFoundException e){
//				e.printStackTrace();
			System.out.println("查詢多筆記錄成功");
//		}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public void createTables() {
		String dropStr = readSQLFile("DropPlace.sql");
		String createStr = readSQLFile("CreatePlace.sql");
		try (Connection con = DriverManager.getConnection(dbURL); Statement stmt = con.createStatement();) {
			stmt.executeUpdate(dropStr);
			stmt.executeUpdate(createStr);
			System.out.println("表格重置成功");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	private String readSQLFile(String filename) {
		// String filename = "CreatePlace.sql";
		try (FileInputStream fis = new FileInputStream(filename);
				InputStreamReader in = new InputStreamReader(fis, "BIG5");
				BufferedReader br = new BufferedReader(in);) {
			String line = "";
			StringBuffer sb = new StringBuffer();
			// 將放在檔案內的字串合併為一個長字串
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
