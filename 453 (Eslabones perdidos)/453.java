import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
public class eslabones {
	
	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);
		int nodos = 0;
		int relaciones=0;
		int n1,n2;
		while ((nodos = sc.readInt()) != 0) {
			relaciones=sc.readInt();
			for (int i=0;i<relaciones;i++) {
				n1=sc.readInt();
				n2=sc.readInt();
			}
			if(relaciones>=nodos-1) {
				sBuilder.append("TODAS");
			}else {
				sBuilder.append("FALTA ALGUNA");
			}
			sBuilder.append('\n');
		}
		output.print(sBuilder);
		output.flush();
		output.close();

	}

}

