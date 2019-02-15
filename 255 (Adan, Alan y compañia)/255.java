import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class alaska {

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		String str;
		int n;
		while (true) {
			try {
				str = sc.readString();
			} catch (Exception e) {
				break;
			}
			n = str.length();
			boolean[][] p = new boolean[n][n];
			int max = 0;
			for (int i = n - 2; i >= 0; i--) {
				for (int j = n - 1; j > i; j--) {
					if (!p[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
						p[i][j] = false;
						if (j - i > max)
							max = j - i;

					} else
						p[i][j] = true;

				}
			}

			sBuilder.append(max+1);
			sBuilder.append('\n');
		}
		output.print(sBuilder);
		output.flush();
		output.close();

	}

	private static boolean isPalindrome(String s) {
		if (s.length() == 1)
			return true;
		else {
			if (s.charAt(0) == s.charAt(s.length() - 1))
				return isPalindrome(s.substring(1, s.length() - 1));
			else
				return false;
		}
	}

}
