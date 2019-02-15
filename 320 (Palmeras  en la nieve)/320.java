import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class PalmerasEnLaNieve {
	public static void main(String[] args) throws IOException {
		StringBuilder sBuilder = new StringBuilder(1000);
		InputReader input = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);

		for (int i = input.readInt(); i > 0; i--) {
			int pesoNieve = input.readInt();
			boolean[] palmeras = new boolean[input.readInt()];
			for (int j = 0; j < palmeras.length; j++) {
				palmeras[j] = pesoNieve <= input.readInt();
			}
			int palmerasMaximas = 0;
			int palmerasSeguidas;
			int palmerasVivas;
			for (int j = 0; j < palmeras.length && palmerasMaximas < palmeras.length - j; j++) {
				palmerasSeguidas = 0;
				palmerasVivas = 0;
				for (int t = j; t < palmeras.length && palmerasVivas <= 5; t++) {
					if (palmeras[t])
						palmerasVivas++;
					if (palmerasVivas <= 5)
						palmerasSeguidas++;
				}
				if (palmerasSeguidas > palmerasMaximas) {
					palmerasMaximas = palmerasSeguidas;
				}
			}
			sBuilder.append(palmerasMaximas + "\n");
			if (sBuilder.length() >= 500) {
				output.print(sBuilder.toString());
				sBuilder = new StringBuilder(1000);
			}
		}
		output.print(sBuilder);
		output.flush();
		output.close();

	}
}
