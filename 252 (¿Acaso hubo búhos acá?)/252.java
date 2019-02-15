import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class AcasoHuboBuhos {
	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		String phrase;
		String endOfInput = "XXX";
		String si = "SI";
		String no = "NO";
		while (!(phrase = sc.readString()).equals(endOfInput)) {
			phrase = phrase.toLowerCase().trim().replaceAll("\\s","");;
			String sub1 = new StringBuilder(phrase.substring(0, (int) Math.floor((double) phrase.length() / 2))).toString();
			String sub2 = new StringBuilder( phrase.substring((int) Math.ceil( (double) phrase.length() / 2), phrase.length())).reverse().toString();
			sBuilder.append(sub1.equals(sub2)? si : no);
			sBuilder.append('\n');
		}
		/////// FIN///////
		output.print(sBuilder);
		output.flush();
		output.close();

	}
}
