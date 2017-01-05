package celebrities;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CelebrityDAO {
	String url = "jdbc:mysql://127.0.0.1:3306/jdbcdb?user=root&password=&useSSL=false&useUnicode=yes&charactEncoding=UTF-8";
	String createTable = "create table celebrity ("
			+ " id int not null primary key auto_increment, "
			+ " CeleName varchar(30), "
			+ " gender varchar(60), "
			+ " filename varchar(60), "
			+ " size        BigInt, "
			+ " timesave    DateTime,  "
			+ " picture     longblob);";
	String dropTable = "drop table if exists celebrity;";
	String insertInto = "insert into celebrity values (null,?,?,?,?,?,?);";
	
	public void resetTable(){

		try(Connection con = DriverManager.getConnection(url); 
			PreparedStatement ps = con.prepareStatement(insertInto);
				){
			ps.executeUpdate(dropTable);
			ps.executeUpdate(createTable);
			System.out.println("Created Celebrity");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String path, int n,String gender) throws IOException{
		
		String celeName = path.substring(path.lastIndexOf("/")+1, path.lastIndexOf("_"));
		celeName = celeName.substring(0,1).toUpperCase()+celeName.substring(1);
		path = path.substring(0, path.lastIndexOf("_")+1);
		
		for(int r=1;r<=n;r++){
			URL imgUrl = new URL(path + r + ".jpg");
			HttpURLConnection connection = (HttpURLConnection) imgUrl.openConnection();
		
			try(Connection con = DriverManager.getConnection(url);
					PreparedStatement ps = con.prepareStatement(insertInto);
					InputStream is = connection.getInputStream();
					) {
				int fileSize = connection.getContentLength();
				ps.setString(1, celeName);
				ps.setString(2, gender);
				ps.setString(3, celeName+r+".jpg");
				ps.setLong(4, fileSize);
				java.util.Date time = new java.util.Date();
				ps.setDate(5, new Date(time.getTime()));
				ps.setBlob(6, is);
				ps.executeUpdate();
				System.out.println(celeName+r+".jpg  Done!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	}
	
	public void downloadToFile(String path, int n, String gender) {
		String celeName = path.substring(path.lastIndexOf("/")+1, path.lastIndexOf("_"));
		celeName = celeName.substring(0,1).toUpperCase()+celeName.substring(1);
		int picNum = 0;
		path = path.substring(0, path.lastIndexOf("_")+1);
		try {
			for(int r=1;r<=n;r++){
				URL url = new URL(path+r+".jpg");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				try(InputStream is = con.getInputStream();
					BufferedInputStream bis = new BufferedInputStream(is);
					OutputStream os = new FileOutputStream("d:/0105/"+celeName+"/"+celeName+r+".jpg");
					BufferedOutputStream bos = new BufferedOutputStream(os);
						){
					int len = 0;
					byte[] b = new byte[8192];
					while((len=is.read(b))!=-1){
						bos.write(b, 0, len);
					}
					System.out.println(celeName+r);
				} 
			}
			System.out.println("Done");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}
}
