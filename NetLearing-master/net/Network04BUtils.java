package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Network04BUtils {
	/**
	 * 
	 * @param file: �n�ǰe���ɮ�
	 * @param os: ����g�X�ɮת���X��y
	 */
	public void sendFile(File file, OutputStream os) {
		// ���ǰe�ɮת��줸�խӼ�
		// �ǰe�ɮת����e
		long fileSize = file.length();
		String filename = file.getName();
		DataOutputStream dos = new DataOutputStream(os);
		try {
			dos.writeUTF(filename);
			dos.writeLong(fileSize);
			dos.flush();
			try (
			    FileInputStream fis = new FileInputStream(file);
			) {
				int len = 0;
				byte[] b = new byte[81920];
				while ((len = fis.read(b)) != -1) {
					dos.write(b, 0, len);
				}
				dos.flush();
				System.out.println("�o�e��: " + filename + "�ǰe����");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * 
	 * @param folder: �x�s�����줧�ɮת���Ƨ�
	 * @param is: ���Ū�J�ɮת���J��y
	 */
	public void receiveFile(File folder, InputStream is) {
		long fileSize;   // �|���쪺�줸�խӼ�
		String filename;
		DataInputStream dis = new DataInputStream(is);
		try {
			filename = dis.readUTF();
			fileSize = dis.readLong();
			File file = new File(folder, filename);
			FileOutputStream fos = new FileOutputStream(file);
			byte[] b = new byte[8192];
			while (true) {
				int len = dis.read(b);
				fos.write(b, 0, len);
				fileSize -= len;
				if (fileSize <= 0) {
					break;
				}
			}
			System.out.println("������: " + filename + "Ū������");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
