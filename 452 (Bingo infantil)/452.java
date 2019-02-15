import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class BingoInfantil {

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		// Escritor, más rápido que System.out.print
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		int casos = 0;
		while ((casos = sc.readInt()) != 0) {
			ArrayList<Integer> bolas = new ArrayList<Integer>();
			Set<Integer> uniqueBolas = new HashSet<>();
			for (; casos > 0; casos--) {
				bolas.add(sc.readInt());
			}
			Collections.sort(bolas);
			for (; bolas.size() > 0; bolas.remove(0)) {
				for (int j = 1; j < bolas.size(); j++) {
					Integer sum = bolas.get(j) - bolas.get(0);
					if (sum > 0)
						uniqueBolas.add(sum);
				}
			}
			bolas.addAll(uniqueBolas);
			Collections.sort(bolas);
			for (int i = 0; i < bolas.size(); i++) {
				sBuilder.append(bolas.get(i));
				if (i == bolas.size() - 1)
					sBuilder.append('\n');
				else
					sBuilder.append(' ');

			}
		}
		output.print(sBuilder.toString());
		output.flush();
		output.close();
	}

	
}

