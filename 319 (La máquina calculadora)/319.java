import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;;

public class Calculadora {

	public static void main(String[] args) throws IOException {

		InputReader input = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		StringBuilder sBuilder = new StringBuilder(1000);

		int nActual;
		int objetivo;
		while ((nActual = input.readInt()) != -1) {
			objetivo = input.readInt();
			sBuilder.append(bfs(new Node(nActual, 0), objetivo) + "\n");
			if (sBuilder.length() >= 500) {
				output.print(sBuilder);
				sBuilder = new StringBuilder(1000);
			}
		}
		output.print(sBuilder);
		output.flush();
		output.close();
	}

	static int bfs(Node start, int valorBuscado) {
		LinkedList<Node> cola = new LinkedList<Node>();
		boolean[] xAxis = new boolean[10000];
		cola.add(start);
		xAxis[start.valor] = true;
		while (cola.size() != 0) {
			Node top = cola.getFirst();
			cola.removeFirst();
			int valor = top.valor;
			int nivel = top.nivel;
			if (valor == valorBuscado)
				return top.nivel;
			valor = mod(valor * 2);
			if (!xAxis[valor]) {
				cola.add(new Node(valor, nivel + 1));
				xAxis[valor] = true;
			}
			valor = mod(top.valor / 3);
			if (!xAxis[valor]) {
				cola.add(new Node(valor, nivel + 1));
				xAxis[valor] = true;
			}
			valor = mod(top.valor + 1);
			if (!xAxis[valor]) {
				cola.add(new Node(valor, nivel + 1));
				xAxis[valor] = true;
			}
		}
		return -1;
	}

	static int mod(int op) {
		return op % 10000;
	}

	static class Node {
		public int valor;
		public int nivel;

		public Node(int valor, int nivel) {
			this.valor = valor;
			this.nivel = nivel;
		}

	}
}
