import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Pixel {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder output = new StringBuilder(500);
		// BufferedReader bf = new BufferedReader();
		for (long i = in.readLong(); i > 0; i--) {

			int[] rgb = new int[3];
			for (int j = 0; j < 3; j++) {
				rgb[j] = in.readInt();

			}
			char c;
			while ((c = in.readChar()) != '-') {
				switch (c) {
				case 'M':
					rgb[0]--;
					break;
				case 'A':
					rgb[1]--;

					break;

				case 'C':
					rgb[2]--;

					break;
				case 'B':

					break;

				case 'R':
					rgb[0]--;
					rgb[1]--;
					break;

				case 'V':
					rgb[1]--;
					rgb[2]--;

					break;

				case 'N':
					rgb[0]--;
					rgb[1]--;
					rgb[2]--;

					break;

				case 'L':
					rgb[0]--;
					rgb[2]--;

					break;

				}
			}
			boolean k = rgb[1] >= 0 && rgb[2] >= 0 && rgb[0] >= 0;

			output.append(k ? "SI " + rgb[0] + " " + rgb[1] + " " + rgb[2]
					: "NO");
			output.append("\n");

			if (output.length() > 500) {
				out.print(output);
				output = new StringBuilder(500);
			}
		}
		out.print(output);
		out.flush();
		out.close();

	}
}
