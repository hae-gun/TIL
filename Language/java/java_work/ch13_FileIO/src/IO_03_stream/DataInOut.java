package IO_03_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInOut {
	public static void main(String[] args) throws IOException {

		DataOutputStream dos = new DataOutputStream(new FileOutputStream("prime.dat"));

		dos.writeUTF("비오는날");
		dos.writeDouble(3.14);
		dos.writeInt(7);
		dos.writeBoolean(true);

		dos.writeUTF("asdf");
		dos.writeDouble(3.14);
		dos.writeInt(7);
		dos.writeBoolean(true);

		dos.flush();

		DataInputStream dis = new DataInputStream(new FileInputStream("prime.dat"));

		for (int i = 0; i < 100; i++) {
			try {
				String day = dis.readUTF();
				Double db = dis.readDouble();
				Integer lucky = dis.readInt();
				Boolean code = dis.readBoolean();
				System.out.printf("%s, %.2f, %d, %b\n", day, db, lucky, code);
			} catch (EOFException e) {
				System.out.println("파일 읽기 완료.");
				break;
			}
		}

	}
}
