import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class Dados {
	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		int caras;
		int relaciones = 0;
		int n1, n2;
		ArrayList<Integer> valores1, valores2;
		while ((caras = sc.readInt()) != 0) {
			valores1 = new ArrayList<Integer>();
			valores2 = new ArrayList<Integer>();
			for (int i = 0; i < caras; i++) {
				valores1.add(sc.readInt());
			}
			for (int i = 0; i < caras; i++) {
				valores2.add(sc.readInt());
			}
			Collections.sort(valores1);
			Collections.sort(valores2);
			int index, index2 = 0;
			int PP = 0, PG = 0;
			for (int i = 0; i < caras; i++) {
				int comparar = valores1.get(i);
				index = Collections.binarySearch(valores2, comparar);
				if (index < 0) {// el elemento no esta en el array
					index=-index-1;
					PP += caras - index;
					PG += index;
				} else {// el elemento esta en el array
						// busqueda binaria que devuelve la posicion de la ultima ocurrencia en el array
					int low = 0, high = caras - 1, result = -1, mid = 0;
					while (low <= high) {
						mid = low + (high - low) / 2;
						if (valores2.get(mid) == comparar) {
							result = mid;
							low = mid + 1;
						} else if (comparar < valores2.get(mid)) {
							high = mid - 1;
						} else {
							low = mid + 1;
						}
					}
					PP += (caras - (result + 1));
					low = 0;
					high = caras - 1;
					result = -1;
					mid = 0;
					while (low <= high) {
						mid = low + (high - low) / 2;
						if (valores2.get(mid) == comparar) {
							result = mid;
							high = mid - 1;
						} else if (comparar < valores2.get(mid)) {
							high = mid - 1;
						} else {
							low = mid + 1;
						}
						
					}
					PG += result;

				}

			}
			if (PG == PP) {
				sBuilder.append("NO HAY DIFERENCIA");
			} else if (PG > PP) {
				sBuilder.append("PRIMERO");
			} else {
				sBuilder.append("SEGUNDO");
			}
			sBuilder.append('\n');
		}
		output.print(sBuilder);
		output.flush();
		output.close();

	}
}
