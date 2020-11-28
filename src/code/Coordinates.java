package code;

public class Coordinates {
	
	int x;
	int y;
	
	public Coordinates(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("Encontrado en la fila %d y la columna %d\n", x, y);
	}

}
