package code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FinderTask implements Callable<List<Coordinates>>{
	
	private List<Integer> fila;
	private int num;
	private int x;
	
	public FinderTask(List<Integer> fila, int num, int x) {
		this.fila = fila;
		this.num = num;
		this.x = x;
	}

	@Override
	public List<Coordinates> call() throws Exception {
		return find();
	}
	
	private List<Coordinates> find(){
		List<Coordinates> coordinates = new ArrayList<Coordinates>();
		int y = 0;
		for(int i : fila) {
			if(i == num) {
				try {
					TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 1001));
					Coordinates c = new Coordinates(y, x);
					coordinates.add(c);
					System.out.print(c.toString());
				} catch (InterruptedException e) {
					System.out.printf("Row %d in collumn %d interrupted while sleeping\n", x, y);
				}
			}
			y++;
		}
		return coordinates;
		
	}

}
