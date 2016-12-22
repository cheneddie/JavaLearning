package PetMain.util;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import PetMain.PetBean;
import PetMain.PetDAO;

public class DBUtils {
	public static char[] fileToChars(String filename, String encoding) {
		try (
				FileInputStream fis = new FileInputStream(filename);
				InputStreamReader in = new InputStreamReader(fis, encoding);
				CharArrayWriter caw = new CharArrayWriter();
				) {
			int len = 0;
			char[] ca = new char[8192];
			while ((len = in.read(ca)) != -1) {
				caw.write(ca, 0, len);
			}
			return caw.toCharArray();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static byte[] fileToBytes(String filename) {
		File f = new File(filename);
		int len = (int) f.length();
		byte[] b = new byte[len];
		try (FileInputStream fis = new FileInputStream(f);) {
			fis.read(b);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return b;
	}

	public static void saveCharsToFile(char[] comment, File file, String encoding) {
		try (
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos, encoding);
				PrintWriter pw = new PrintWriter(osw);
				) {
			pw.println(new String(comment));
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void saveBytesToFile(byte[] picture, File file) {
		try (
			FileOutputStream fos = new FileOutputStream(file);
				) {
			fos.write(picture);
		}catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public static void initPlace(String filename, String encoding) {
		PetDAO dao = new PetDAO();
		try (
				FileInputStream fis = new FileInputStream(filename);
				InputStreamReader in = new InputStreamReader(fis, encoding);
				BufferedReader br = new BufferedReader(in);
				) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] sa = line.split(",");
				int id = Integer.parseInt(sa[0].trim());
				String petName = sa[1].trim();
				String masterName = sa[2].trim();
				String birthday = sa[3].trim();
				double price = Double.parseDouble(sa[4].trim());
				double weight = Double.parseDouble(sa[5].trim());
				String picFilename = sa[6].trim();
				byte[] picture = DBUtils.fileToBytes("pics\\" + sa[6].trim());
				char[] comment = DBUtils.fileToChars("txts\\" + sa[7].trim(), encoding);
				PetBean pb = new PetBean(id, petName, masterName, birthday, price, weight, picFilename, picture,
						comment);
				dao.insert(pb);
			}
			System.out.println("檔案" + filename + "新增完畢");
		} catch (IOException ex) {
			System.out.println(ex.getMessage() + "==>" + filename);
			ex.printStackTrace();
		}
	}
	public static void displayData(PetBean pb) {
		String saveFolderImg = "images1221";
		File dirImg = new File(saveFolderImg);
		if (!dirImg.exists())  dirImg.mkdirs();
		String filenameImg = pb.getFilename(); 
		File fileImg = new File(dirImg, filenameImg);
		
		
		String saveFolderTxt = "text1221";
		File dirTxt = new File(saveFolderTxt);
		if (!dirTxt.exists())  dirTxt.mkdirs();
		String filenameTxt = "Comment" + pb.getId() + ".txt"; 
		File fileTxt = new File(dirTxt, filenameTxt);
		
		System.out.println("Pet Id       :"  + pb.getId());
		System.out.println("Pet Name     :"  + pb.getPetName());
		System.out.println("MasterName   :"  + pb.getMasterName());
		System.out.println("Birthday     :"  + pb.getBirthday());
		System.out.println("Price        :"  + pb.getPetName());
		System.out.println("Weight     :"  + pb.getWeight());
		System.out.println("Filename :"  + pb.getFilename());
		saveBytesToFile(pb.getPicture(), fileImg);
		saveCharsToFile(pb.getComment(), fileTxt, "BIG5");
	}
}
