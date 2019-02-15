import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class SumaDescendente {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(2000);
		int caso;
		while ((caso = in.readInt()) != 0) {
			Long mod = 10L;
			Long partialSum = 0L;
			while((mod/10<=caso)){
				partialSum+=caso%mod;
				mod*=10;
			}
			sBuilder.append(partialSum);
			sBuilder.append('\n');

		}
		output.print(sBuilder);
		output.flush();
		output.close();
	}
}
