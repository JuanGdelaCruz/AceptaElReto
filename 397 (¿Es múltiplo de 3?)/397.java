import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class MultiploDe3 {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder output = new StringBuilder(1600);
		String si = "SI";
		String no = "NO";
		for (long i = in.readLong(); i > 0; i--) {
			long n = in.readLong();
			output.append((((n * (n + 1)) / 2) % 3) == 0 ? si : no);
			output.append('\n');
		}
		out.print(output);
		out.flush();
		out.close();

	}
}
