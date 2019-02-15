import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class SaliendoDeLaCrisis {
	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		String si = "SI";
		String no = "NO";
		int casos;
		while ((casos = sc.readInt()) != 0) {
			int datoAnt = 0;
			boolean cumple = true;
			for (; casos > 0; casos--) {
				int dato = sc.readInt();
				if(cumple)
					cumple = (dato > datoAnt);
				datoAnt = dato;
			}
			sBuilder.append(cumple ? si:no);
			sBuilder.append('\n');
		}
		/////// FIN///////
		output.print(sBuilder);
		output.flush();
		output.close();

	}
}
