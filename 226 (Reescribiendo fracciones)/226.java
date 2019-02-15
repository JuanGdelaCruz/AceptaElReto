import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.math.*;

public class RescribiendoFracciones {

	public static int numPares(int n) { /*
										 * dado un numero n=p1^e1*..*pk^ek,
										 * devuelve (2*p1+1)*...*(2*pk+1)
										 */
		int cont = 1;
		int t;
		for (int i = 0; i < prim.size() && prim.get(i) * prim.get(i) <= n; i++) {
			int primo = prim.get(i);
			t = 0;
			while (n % primo == 0) {
				n /= primo;
				t++;
			}
			if (t > 0)
				cont *= (2 * t + 1);
		}
		if (n > 1)
			cont *= (2 * 1 + 1);
		return cont % 2 == 0 ? cont / 2 : (cont + 1) / 2;
	}

	public static boolean[] primos;
	public static ArrayList<Integer> prim;

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		primos = new boolean[(int) Math.pow(2, 16)];
		prim = new ArrayList<Integer>();
		for (int i = 2; i <= 254; i++)
			if (!primos[i]) {
				for (int j = 2 * i; j < primos.length; j += i) {
					primos[j] = true;
				}
			}
		for (int i = 2; i < Math.pow(2, 16); i++) {
			if (!primos[i])
				prim.add(i);
		}
		int k = 0;

		while ((k = sc.readInt()) != -1) {

			sBuilder.append(numPares(k) + "\n");
		}
		output.print(sBuilder.toString());
		output.flush();
		output.close();
	}
}
