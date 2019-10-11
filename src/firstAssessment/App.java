package firstAssessment;

import java.security.SecureRandom;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the game");
		System.out.println("Do you want to play?");
		
		
		
		Game infiniteSwamps = new Game();
		boolean wantToPlay= true;
		while(wantToPlay)
		{
			infiniteSwamps.Run();
			
			System.out.println("Do you want to play another game?");
			switch(App.scan.nextLine().toLowerCase())
			{
			case "n":
				wantToPlay = false;
				break;
			}
		}
	}
	public static Scanner scan = new Scanner(System.in);
	private static final SecureRandom random = new SecureRandom();
	public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
	    int x = random.nextInt(clazz.getEnumConstants().length);
	    return clazz.getEnumConstants()[x];
	}

}
