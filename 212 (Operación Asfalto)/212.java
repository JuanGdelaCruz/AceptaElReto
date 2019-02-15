import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class OperacionAsfalto {

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output=new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		int nAristas;
		final int v[] = new int[2];
		while ((nAristas = sc.readInt()) != 0) {
			int[] vertices = new int[sc.readInt()];
			for (int i = 0; i < nAristas; i++) {
				for (int j = 0; j < 2; j++) {
					vertices[(v[j] = sc.readInt()) - 1]++;
				}
			}
			int cont = 0;
			for (int i = 0; i < vertices.length; i++) {
				if (vertices[i] % 2 != 0)
					cont++;
			}
			sBuilder.append((cont - 2 <= 0 ? "SI\n" : "NO\n"));

		}
		output.print(sBuilder.toString());
		output.flush();
		output.close();
	}
}
