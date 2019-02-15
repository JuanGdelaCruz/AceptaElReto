import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class ClarasOscuras {

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		int casos = sc.readInt();
		for (; casos > 0; casos--) {
			double n = sc.readInt()*sc.readInt();
			sBuilder.append( (int)Math.ceil(n/2));
			sBuilder.append(' ');
			sBuilder.append((int)Math.floor(n/2));
			sBuilder.append('\n');
		}
		output.print(sBuilder.toString());
		output.flush();
		output.close();
	}
}
