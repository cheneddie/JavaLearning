package ex01;

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

import ex01.util.SystemConstant;

public class PlaceDAO {
	String dbURL = SystemConstant.URL;

	public PlaceDAO() {

	}

	public PlaceDAO(String url) {  

	}

	public int insert(PlaceBean pb) {
		int n = 0 ;
		String sql = "INSERT INTO Place "
				+ "VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
		  Connection con = DriverManager.getConnection(dbURL);
		  PreparedStatement pstmt = con.prepareStatement(sql);		
		) {
			pstmt.setInt(1, pb.getTypeId());
			pstmt.setString(2, pb.getName());
			pstmt.setString(3, pb.getPhone());
			pstmt.setString(4, pb.getAddress());
			pstmt.setDouble(5, pb.getLongitude());	//經度
			pstmt.setDouble(6, pb.getLatitude());	//緯度	
			pstmt.setString(7, pb.getLink());
			pstmt.setString(8, pb.getFilename());
			pstmt.setBytes(9, pb.getPicture());
			SerialClob clob = new SerialClob(pb.getComment());
			pstmt.setClob(10, clob);
			n = pstmt.executeUpdate();
			System.out.println("表格記錄成功, id=" + pb.getPlaceId());
		} catch (SQLException ex) {
			System.out.println(ex.getSQLState() + " " + pb.getPlaceId());
			ex.printStackTrace() ;
		}
		return n;
	}
	public int update(PlaceBean pb) {
		int n = 0;
		String sql = "UPDATE Place set typeId = ?, name = ?, phone=?, "
				+ " address =?, longitude = ?, latitude= ?, "
				+ " link = ?, filename = ?, picture = ?, comment =? "
				+ " WHERE placeId= ?";
		try (
		    Connection con = DriverManager.getConnection(dbURL);
		    PreparedStatement pstmt = con.prepareStatement(sql);		
		) {
		    pstmt.setInt(1, pb.getTypeId());
			pstmt.setString(2, pb.getName());
			pstmt.setString(3, pb.getPhone());
			pstmt.setString(4, pb.getAddress());
			pstmt.setDouble(5, pb.getLongitude());	//經度
			pstmt.setDouble(6, pb.getLatitude());	//緯度	
			pstmt.setString(7, pb.getLink());
			pstmt.setString(8, pb.getFilename());
			pstmt.setBytes(9, pb.getPicture());
			SerialClob clob = new SerialClob(pb.getComment());
			pstmt.setClob(10, clob);
			pstmt.setInt(11, pb.getPlaceId());
			n = pstmt.executeUpdate();
			System.out.println("修改記錄成功, id=" + pb.getPlaceId());
		} catch (SQLException ex) {
			ex.printStackTrace() ;
		}
		return n;
		
	}
	public int delete(PlaceBean pb) {
		return delete( pb.getPlaceId() );
	}
	public int delete(int key) {
		int  n = 0;
		String sql = "DELETE FROM Place WHERE placeId = ?";
		try (
			Connection con = 
			   DriverManager.getConnection(SystemConstant.URL);
			PreparedStatement pstmt = con.prepareStatement(sql);	
		) {
			pstmt.setInt(1, key);
			n = pstmt.executeUpdate();
			System.out.println("刪除紀錄成功");
		} catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		return n;
	}

	public PlaceBean findByPrimaryKey(int key) {
		String sql = "SELECT * FROM Place "
				+ "WHERE placeId = ?";
		PlaceBean pb = null;
		try (
		  Connection con = DriverManager.getConnection(dbURL);
		  PreparedStatement pstmt = con.prepareStatement(sql);
		  		
		) {
			pstmt.setInt(1, key);
			try (
			   ResultSet rs = pstmt.executeQuery();
            ) {
			   if (rs.next()){
				   pb = new PlaceBean();
				   pb.setPlaceId(rs.getInt(1));
				   pb.setTypeId(rs.getInt(2));
				   pb.setName(rs.getString(3));
				   pb.setPhone(rs.getString(4));
				   pb.setAddress(rs.getString(5));
				   pb.setLongitude(rs.getDouble(6));
				   pb.setLatitude(rs.getDouble(7));
				   pb.setLink(rs.getString(8));
				   pb.setFilename(rs.getString(9));
				   pb.setPicture(rs.getBytes(10));
				   pb.setComment(clobToCharArray(rs.getClob(11)));
				   
			   }	
			}
			System.out.println("查詢記錄成功, id=" + pb.getPlaceId());
		} catch (SQLException ex) {
			System.out.println(ex.getSQLState() + " " + pb.getPlaceId());
			ex.printStackTrace() ;
		}
		return pb;
	}

	private char[] clobToCharArray(Clob clob) {
		try (
        Reader rd = clob.getCharacterStream();
        CharArrayWriter caw = new CharArrayWriter();
		) {
           char[] ca = new char[8192];
           int len = 0 ;
           while ((len=rd.read(ca))!=-1){
        	  caw.write(ca, 0, len);
           }
           char[] output = caw.toCharArray();
		   return output;
		} catch(Exception ex){
			ex.printStackTrace();
		}   
		return null;
	}

	public List<PlaceBean> findAll() {
		List <PlaceBean> list = new ArrayList<>();
		String sql = "SELECT * FROM Place WHERE PlaceId ";
		try (
			Connection con = DriverManager.getConnection(dbURL);
			PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			try (
			   ResultSet rs = pstmt.executeQuery();
            ) {
			   while (rs.next()){
				   PlaceBean  pb = new PlaceBean();
				   pb.setPlaceId(rs.getInt(1));
				   pb.setTypeId(rs.getInt(2));
				   pb.setName(rs.getString(3));
				   pb.setPhone(rs.getString(4));
				   pb.setAddress(rs.getString(5));
				   pb.setLongitude(rs.getDouble(6));
				   pb.setLatitude(rs.getDouble(7));
				   pb.setLink(rs.getString(8));
				   pb.setFilename(rs.getString(9));
				   pb.setPicture(rs.getBytes(10));
				   pb.setComment(clobToCharArray(rs.getClob(11)));
				   list.add(pb);
			   }	
			}
			System.out.println("查詢多筆記錄成功");		
		} catch(SQLException ex){
			ex.printStackTrace();
		}
		return list;
	}

	
	public void createTables() {
		String dropStr = readSQLFile("dropPlace.sql");
		String createStr = readSQLFile("CreatePlace.sql");
		try (Connection con = DriverManager.getConnection(dbURL); 
			Statement stmt = con.createStatement();) {
			stmt.executeUpdate(dropStr);
			stmt.executeUpdate(createStr);
			System.out.println("表格重置成功");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	private String readSQLFile(String filename) {
//		String filename = "CreatePlace.sql";
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
