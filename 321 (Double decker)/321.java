import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Stack;

public class RangoBus {
	public static void main(String[] args) throws IOException {
		//////////////////// VARIABLES////////////////////////
		StringBuilder sBuilder = new StringBuilder(1000);
		InputReader input = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		
		for (int i = input.readInt(); i > 0; i--) {
			int n = input.readInt();
			int n2 = input.readInt();
			int r = (((1 + (n + n2)) * (n + n2)) / 2) + (n + 1);
			sBuilder.append(r + "\n");
			if (sBuilder.length() > 500) {
				output.print(sBuilder);
				sBuilder = new StringBuilder(1000);
			}
		}
		output.print(sBuilder);
		output.flush();
		output.close();
	}
}
