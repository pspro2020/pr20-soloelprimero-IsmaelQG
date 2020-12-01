package code;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FinderTask implements Callable<Coordinates>{
	
	private List<Integer> fila;
	private int num;
	private int x;
	
	public FinderTask(List<Integer> fila, int num, int x) {
		this.fila = fila;
		this.num = num;
		this.x = x;
	}

	@Override
	public Coordinates call() throws InterruptedException {
		int y = 0;
		for(int i : fila) {
			if(i == num) {
				Coordinates coordinates = new Coordinates(y, x);
				System.out.print(coordinates.toString());
				return coordinates;
			}
			TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 1001));
			y++;
		}
		throw new InterruptedException();
	}

}
