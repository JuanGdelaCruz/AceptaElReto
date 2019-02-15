import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class AbuelasFalsas {

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		int i = sc.readInt();
		for (; i > 0; i--) {
			String nombreReal = sc.readString();
			int j = sc.readInt();
			boolean detectada = false;
			for (int n = j; n > 0; n--) {
				if (detectada) {
					sc.readString();
					continue;
				}
				if (nombreReal.equals(sc.readString())) {
					detectada = true;
					if (n == 1 && j >1) {
						sBuilder.append("VERDADERA");
						sBuilder.append('\n');
					} else {
						sBuilder.append("FALSA");
						sBuilder.append('\n');
					}
				}else if( n==1){
					sBuilder.append("FALSA");
					sBuilder.append('\n');
				}
					
			}
		}

		/////// FIN///////
		output.print(sBuilder);
		output.flush();
		output.close();
	}

	
}
