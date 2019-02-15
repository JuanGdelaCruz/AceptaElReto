import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Stack;

public class LaRondaDeLaNoche {

	public static void main(String[] args) throws IOException {
		//////////////////// VARIABLES////////////////////////

		StringBuilder sBuilder = new StringBuilder(1000);
		InputReader input = new InputReader(System.in);
		PrintWriter output = new PrintWriter(System.out);
		int[][] laberinto;
		Stack<Integer> type = new Stack<Integer>();
		Stack<Integer> sX = new Stack<Integer>();
		Stack<Integer> sY = new Stack<Integer>();

		//////////////////// Lectura//////////////////////////

		for (int i = input.readInt(); i > 0; i--) {
			int[] labSize = new int[] { input.readInt(), input.readInt() };
			laberinto = new int[labSize[0]][labSize[1]];
			int x = 0, y = 0;
			for (int alto = 0; alto < laberinto[0].length; alto++) {
				for (int ancho = 0; ancho < laberinto.length; ancho++) {
					char in = input.readChar();
					switch (in) {
					case 'E':// Casilla Inicial
						x = ancho;
						y = alto;
						laberinto[ancho][alto] = -2;
						break;
					case 'P':// Salida
						laberinto[ancho][alto] = -3;
						break;
					case '#':// Muro
						laberinto[ancho][alto] = -5;
						break;
					case '.':
						break;
					default:// Camara
						sX.push(ancho);
						sY.push(alto);
						type.push(in - '0');
						break;
					}
				}

			}

			//////////////////// LOGICA//////////////////////////
			while (!sX.isEmpty()) {
				sensor(laberinto, type.pop(), sX.pop(), sY.pop());
			}
			int path;
			if (laberinto[x][y] != -1)
				path = bfs(laberinto, x, y);
			else
				path = -1;
			sBuilder.append((path == -1 ? "NO" : path) + "\n");
			if (sBuilder.length() >= 500) {
				output.write(sBuilder.toString());
				sBuilder = new StringBuilder(1000);
			}
			//////////////////// DIBUJAR//////////////////////////
/*
			for (short alto = 0; alto < laberinto[0].length; alto++) {
				for (short ancho = 0; ancho < laberinto.length; ancho++) {
					sBuilder.append(laberinto[ancho][alto]);
					sBuilder.append(" | ");
				}
				sBuilder.append('\n');

			}
			System.out.println(sBuilder);
			sBuilder = new StringBuilder(1000);
*/
		}

		////////////////// RESULTADO FINAL///////////////////////
		output.print(sBuilder.toString());
		output.flush();
		output.close();
		///////////////////////////////////////////////////////
	}

	////////////////// BUSQUEDA EN ANCHURA//////////////////////////////
	public static int bfs(int[][] laberinto, int x, int y) {
		LinkedList<Node> s = new LinkedList<Node>();
		s.add(new Node(x, y, 0, -2));
		int nivel = 0;
		while (s.size() != 0) {
			Node top = s.getFirst();
			s.removeFirst();
			x = top.x;
			y = top.y;
			nivel = top.nivel + 1;
			if (top.value == -3)
				return top.nivel;
			// add all of top's unvisited neighbors to the queue
			// mark all of top's unvisited neighbors as visited
			// Arriba
			if (canMove(laberinto, x, y - 1, nivel)) {
				s.add(new Node(x, y - 1, nivel, laberinto[x][y - 1]));
				laberinto[x][y - 1] = nivel;
			}
			// Derecha
			if (canMove(laberinto, x + 1, y, nivel)) {
				s.add(new Node(x + 1, y, nivel, laberinto[x + 1][y]));
				laberinto[x + 1][y] = nivel;
			}

			// Abajo
			if (canMove(laberinto, x, y + 1, nivel)) {
				s.add(new Node(x, y + 1, nivel, laberinto[x][y + 1]));
				laberinto[x][y + 1] = nivel;

			}
			// Izquierda
			if (canMove(laberinto, x - 1, y, nivel)) {
				s.add(new Node(x - 1, y, nivel, laberinto[x - 1][y]));
				laberinto[x - 1][y] = nivel;

			}
		}
		return -1;
	}
	//////////// METODOS & CLASES PARA BUSQUEDA/////////////////////////

	static final class Node {
		public int x;
		public int y;
		public int nivel;
		public int value;

		public Node(int x, int y, int nivel, int value) {
			this.x = x;
			this.y = y;
			this.nivel = nivel;
			this.value = value;
		}

	}

	public static boolean canMove(int[][] laberinto, int xDes, int yDes, int nivel) {
		if (xDes < 0 || xDes >= laberinto.length)
			return false;
		if (yDes < 0 || yDes >= laberinto[xDes].length)
			return false;
		return laberinto[xDes][yDes] == 0 || laberinto[xDes][yDes] == -3;
	}

	////////////////// BUSQUEDA EN PROFUNDIDAD//////////////////////////////
	public static int dfs(int[][] laberinto, int x, int y, int nivel) {
		if (laberinto[x][y] == -3)
			return nivel;
		int value = -1;
		if (nivel > 0)
			laberinto[x][y] = nivel;
		// Arriba
		if (canMove(laberinto, x, y - 1, nivel) && value == -1) {
			value = dfs(laberinto, x, y - 1, nivel + 1);
		}
		// Derecha
		if (canMove(laberinto, x + 1, y, nivel) && value == -1) {
			value = dfs(laberinto, x + 1, y, nivel + 1);
		}
		// Abajo
		if (canMove(laberinto, x, y + 1, nivel) && value == -1) {
			value = dfs(laberinto, x, y + 1, nivel + 1);
		}
		// Izquierda
		if (canMove(laberinto, x - 1, y, nivel) && value == -1) {
			value = dfs(laberinto, x - 1, y, nivel + 1);
		}
		return value;
	}

	/////////////////////////////////////////////////////////////////////

	public static void sensor(int[][] laberinto, int tipoSensor, int ancho, int alto) {
		laberinto[ancho][alto] = -1;
		boolean north = true, south = true, east = true, west = true;
		for (int range = 1; range < tipoSensor + 1; range++) {
			// Oeste
			if (west) {
				west = !override(laberinto, ancho - range, alto);
				if (west)
					laberinto[ancho - range][alto] = -1;
			}
			// Este
			if (east) {
				east = !override(laberinto, ancho + range, alto);
				if (east)
					laberinto[ancho + range][alto] = -1;
			}

			// Norte
			if (north) {
				north = !override(laberinto, ancho, alto - range);
				if (north)
					laberinto[ancho][alto - range] = -1;
			}
			// Sur
			if (south) {
				south = !override(laberinto, ancho, alto + range);
				if (south)
					laberinto[ancho][alto + range] = -1;
			}

		}
	}

	public static boolean override(int[][] laberinto, int anchoPos, int altoPos) {
		if (anchoPos < 0 || anchoPos >= laberinto.length)
			return true;
		if (altoPos < 0 || altoPos >= laberinto[anchoPos].length)
			return true;
		return laberinto[anchoPos][altoPos] == -5 || laberinto[anchoPos][altoPos] > 0;
	}
]
