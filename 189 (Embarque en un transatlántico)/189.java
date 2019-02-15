import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.InputMismatchException;

public class EmbarqueEnUnTransatlantico {

	public static void main(String[] args) throws IOException {
		// Lector
		InputReader br = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		int n = 0;
		int[] pasajeros;
		while ((n = br.readInt()) != 0) {
			// Leer Pasajeros
			pasajeros= new int[n];
			for (int j = 0; j < n; j++) {
				pasajeros[j] = br.readInt();
			}
			// Leer Acciones
			for (int i = br.readInt(); i > 0; i--) {
				// Identificar acciones
				switch (br.readString().charAt(0)) {
				case 'E':
					int cBuscado = br.readInt();
					int count = 0;
					for (int j = 0; j < n; j++)
						if (pasajeros[j] != cBuscado)
							pasajeros[count++] = pasajeros[j];
					n = count;
					sBuilder.append(n + "\n");
					/*//Poner el elemento buscado al final
					 * while (count < n) { pasajeros[count++] = 0; }
					 */
					break;
				case 'C':
					sBuilder.append(pasajeros[br.readInt() - 1] + "\n");
					break;
				}

			}
			sBuilder.append("*\n");
			// Para conservar memoria
			if (sBuilder.length() >= 500) {
				output.write(sBuilder.toString());
				sBuilder = new StringBuilder(1000);
			}
		}
		output.print(sBuilder.toString());
		output.flush();
		output.close();
	}
}
