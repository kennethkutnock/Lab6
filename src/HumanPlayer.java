import java.util.Arrays;
import java.util.Scanner;

public class HumanPlayer extends Player {

	private Scanner keyboard;
	
	public HumanPlayer(String name, Scanner keyboard) {
		super(name);
		this.keyboard = keyboard;
	}
	
	@Override
	public int[] getMove(int[] pileSizes) {
		System.out.println("Piles: " + Arrays.toString(pileSizes));
		int pileIdx = getUserInput("Enter pile index: ");
		int numObjects = getUserInput("Enter object number: ");
		return new int[] {pileIdx, numObjects};
	}

	public int getUserInput(String prompt) {
		int a = 0;
		boolean valid = false;
		
		do { 
			try {
				System.out.print(prompt);
				a = keyboard.nextInt();
				valid = true;
			}
			catch (Exception e) {
				keyboard.nextLine();
			}
		} while(valid == false);
		
		return a;
	}
	
	@Override
	public void notifyIllegalMove(String moveInfo) {
		System.out.println(moveInfo);
		System.out.println();
	}
	
	@Override
	public void notifyOpponentMove(String name, int[] move) {
		String notification = name + " removed " + move[1] + " from pile " 
				+ move[0] + ".";
		System.out.println(notification);
		System.out.println();
	}
	
	@Override
	public void notifyWin() {
		System.out.println("Nice job, " + super.getName() + ". You win!");
	}
	
	@Override
	public void notifyLose() {
		System.out.println("Sorry, " + super.getName() + ". You lose :(");
	}
}
