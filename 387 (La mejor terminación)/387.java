import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Terminacion {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder output = new StringBuilder(500);
		int n;
		while ((n = in.readInt()) != 0) {
			int[] a = new int[n];
			int[] apar = new int[10];
			for (int i = 0; i < a.length; i++) {
				apar[in.readInt() % 10]++;
			}
			int max = 0;
			int index=-1;
			boolean duplicado = false;
			for (int i = 0; i < 10; i++) {
				if (max == apar[i]) {
					duplicado = true;
				} else if (max < apar[i]) {
					max = apar[i];
					index = i;
					duplicado = false;
				}
			}
			output.append(duplicado ? "VARIAS\n" : index + "\n");

		}
		out.print(output);
		out.flush();
		out.close();
	}
}
