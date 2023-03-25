package Banking;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Demo {
	public static void main(String[] args) throws Exception {
	
		FileWriter fw = new FileWriter("MiniStatement.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("You can see your last 10 transaction");
		bw.newLine();
		bw.write("on 12/12/11   ₹ 1000.00 (Dr)");
		bw.newLine();
		bw.write("on 11/12/11   ₹ 500.00  (Cr)");
		bw.newLine();
		bw.write("on 11/12/11   ₹ 2000.00 (Dr)");
		bw.newLine();
		bw.write("on 10/12/11   ₹ 5000.00 (Cr)");
		bw.newLine();
		bw.write("on 08/12/11   ₹ 200.00  (Dr)");
		bw.newLine();
		bw.write("on 07/12/11   ₹ 600.00  (Dr)");
		bw.newLine();
		bw.write("on 05/12/11   ₹ 7000.00 (Cr)");
		bw.newLine();
		bw.write("on 05/12/11   ₹ 8000.00 (Cr)");
		bw.newLine();
		bw.write("on 03/12/11   ₹ 400.00  (Dr)");
		bw.newLine();
		bw.write("on 02/12/11   ₹ 600.00  (Dr)");
		bw.flush();
		bw.close();
	}
}
