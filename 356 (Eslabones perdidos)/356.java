import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Dolar {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String s = stdin.readLine();
		StringTokenizer tokens = new StringTokenizer(s);

		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(2000);
		for (int casos = Integer.parseInt(tokens.nextToken()); casos > 0; casos--) {
			s= stdin.readLine();
			tokens = new StringTokenizer(s);
			long[] caso = new long[3];
			for (int i = 0; i < 3; i++) {
				caso[i] =Long.parseLong(tokens.nextToken());
			}
			for (int i = 0; i < 2; i++) {
				while (caso[i + 1] < caso[i]) {
					long temp = caso[i + 1];
					caso[i + 1] = caso[i];
					caso[i] = temp;
					i = 0;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (i < 2)
					sBuilder.append(caso[i] + " ");
				else
					sBuilder.append(caso[i]);

			}
			sBuilder.append("\n");
		}
		output.print(sBuilder);
		output.flush();
		output.close();
	}

}
