package code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) {
		ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		int tMatriz = 5;
		int max = 10;
		int find = ThreadLocalRandom.current().nextInt(1, 21);
		int[][] matriz = new int[tMatriz][tMatriz];
		List<FinderTask> allFinders = new ArrayList<>();
		
		for(int i=0; i<tMatriz; i++) {
			List<Integer> fila = new ArrayList<>();
			for(int j=0; j<tMatriz; j++) {
				matriz[i][j] = ThreadLocalRandom.current().nextInt(1, max+1);
				fila.add(matriz[i][j]);
				System.out.printf("%-3d ",matriz[i][j]);
			}
			allFinders.add(new FinderTask(fila, find, i));
			System.out.print("\n");
		}
		
		System.out.printf("Número a buscar: %d\n", find);
		
		try {
			List<Coordinates> allCoordinates = fixedThreadPool.invokeAny(allFinders);
			if(find>max) {
				System.out.println("No se ha encontrado");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
		} finally {
			fixedThreadPool.shutdown();
		}

	}

}
