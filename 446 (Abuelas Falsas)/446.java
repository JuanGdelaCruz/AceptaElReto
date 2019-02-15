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
