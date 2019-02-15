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
		int n,suma;
		while ((n=sc.readInt())!=0) {
			int[] alturas=new int[n];
			for (int i=0;i<n;i++) {
				alturas[i]=sc.readInt();
			}
			int[] esquis=new int[n];			
			for (int i=0;i<n;i++) {
				esquis[i]=sc.readInt();
			}
			Arrays.sort(alturas);
			Arrays.sort(esquis);
			suma=0;
			for(int i=0;i<n;i++) {
				suma+=Math.abs(alturas[i]-esquis[i]);
			}
			sBuilder.append(suma);
			sBuilder.append('\n');
		}
		output.print(sBuilder);
		output.flush();
		output.close();

	}

}
