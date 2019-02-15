import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class HyperPar {

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(500);
		String numero;
		while ((numero = sc.readString()).charAt(0) != '-') {
			boolean cumple = true;
			for (int i = 0; i < numero.length() && cumple; i++)
				cumple = numero.charAt(i) % 2 == 0;
			sBuilder.append(cumple ? "SI\n" : "NO\n");

		}
		output.print(sBuilder.toString());
		output.flush();
		output.close();
	}
}
