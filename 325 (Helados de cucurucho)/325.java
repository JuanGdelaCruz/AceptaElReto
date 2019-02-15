import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class BolasDeHelado {

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(2000);
		for (int nPruebas = in.readInt(); nPruebas > 0; nPruebas--) {
			char[] entry;
			int nChoc = in.readInt();
			int nVai = in.readInt();
			entry = new char[nChoc + nVai];
			for (int i = 0; i < entry.length; i++)
				if (i < nChoc)
					entry[i] = 'C';
				else
					entry[i] = 'V';
			//////////////////////////////////////////////////////
			char[] clone = new char[entry.length];
			boolean[] mark = new boolean[entry.length];
			permute(entry, clone, mark, 0, entry.length, sBuilder);
			/////////////////////////////////////////////////////////
			sBuilder.append("\n");
			if (sBuilder.length() >= 1000) {
				output.write(sBuilder.toString());
				sBuilder = new StringBuilder(1000);
			}
		}
		output.print(sBuilder.toString());
		output.flush();
		output.close();
	}

	private static void permute(char[] original, char[] clone, boolean[] mark, int length, int n,
			StringBuilder sBuilder) {
		if (length == n) {
			if (sBuilder.length() != 0)
				if (sBuilder.charAt(sBuilder.length()-1) != '\n')
					sBuilder.append(' ');
			sBuilder.append(clone);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (mark[i] == true) {
				continue;
			}
			if (i > 0 && original[i] == original[i - 1] && mark[i - 1] == false) {
				continue;
			}
			mark[i] = true;
			clone[length] = original[i];
			permute(original, clone, mark, length + 1, n, sBuilder);
			mark[i] = false;
		}

	}
}
