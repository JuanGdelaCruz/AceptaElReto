import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class UltimoFactorial {

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		for (int i = sc.readInt(); i > 0; i--) {
			sBuilder.append(factorial(sc.readInt()) + "\n");
		}
		output.print(sBuilder.toString());
		output.flush();
		output.close();
	}

	public static int factorial(int n) {
		if (n > 5)
			return 0;
		int resultado = 1;
		for (int i = 1; i <= n; i++) {
			resultado *= i % 10;
		}
		return resultado % 10;
	}
}
