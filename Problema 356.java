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

	/// -----LECTOR------///
	static final class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read(buf);
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public final int readInt() throws IOException {
			return (int) readLong();
		}

		public final long readLong() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
				if (c == -1)
					throw new IOException();
			}
			boolean negative = false;
			if (c == '-') {
				negative = true;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += (c - '0');
				c = read();
			} while (!isSpaceChar(c));
			return negative ? (-res) : (res);
		}

		public final int[] readIntBrray(int size) throws IOException {
			int[] arr = new int[size];
			for (int i = 0; i < size; i++)
				arr[i] = readInt();
			return arr;
		}

		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}
}

(
