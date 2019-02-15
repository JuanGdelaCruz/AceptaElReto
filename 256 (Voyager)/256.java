import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Voyager {

	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		while (true) {
			try {
				String a = sc.readString();
				String b = sc.readString();
				String c = sc.readString();
				int max = Math.max(c.length(), Math.max(a.length(), b.length()));
				StringBuilder tempRes = new StringBuilder(max);
				for (int i = 1; i <= max; i++) {
					char ai = i > a.length() ? '0' : a.charAt(a.length() - i);
					char bi = i > b.length() ? '0' : b.charAt(b.length() - i);
					char ci = i > c.length() ? '0' : c.charAt(c.length() - i);
					if (ai == bi || ai == ci) {
						tempRes.insert(0, ai);
					} else if (bi == ci) {
						tempRes.insert(0, bi);
					} else {
						tempRes = new StringBuilder("RUIDO COSMICO");
						break;
					}
				}
				if(tempRes.charAt(0)=='0'){
					int res = Integer.parseInt(tempRes.toString());
					tempRes = new StringBuilder(max);
					tempRes.append(res);
				}
				sBuilder.append(tempRes);
				sBuilder.append('\n');
			} catch (Exception e) {
				break;
			}
		}
		/////// FIN///////
		output.print(sBuilder);
		output.flush();
		output.close();

	}
}
