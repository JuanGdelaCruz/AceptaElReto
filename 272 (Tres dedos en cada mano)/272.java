import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class TresDedos {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(2000);
		for (int i = in.readInt(); i > 0; i--) {
			sBuilder.append(Integer.toString(in.readInt(), 6));
			sBuilder.append('\n');
		}
		output.print(sBuilder);
		output.flush();
		output.close();
	}
}
