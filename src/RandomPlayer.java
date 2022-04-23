import java.util.Random;

public class RandomPlayer extends Player{
	
	private Random generator;
	
	public RandomPlayer(String name) {
		super(name);
		generator = new Random();
	}
	
	public int[] getMove(int[] pileSizes) {
		int a; 
		do {
			a = generator.nextInt(pileSizes.length);
		}while(pileSizes[a] == 0);
		
		int b;
		do {
		b = generator.nextInt(pileSizes[a]+1);
		} while(b == 0);
		
		return new int[] {a, b};
	}
	
	public void notifyWin() {
		
	}
	
	public void notifyLose() {
		
	}
}
