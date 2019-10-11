package firstAssessment;

import java.util.stream.Collectors;

public class Game {
	
	private Map map;
	private boolean play = true;
	private int noOfItems, noOfPlayers;
	public void Run() {
		Init();
		Intro();
		while(play)
		{
			// TODO Auto-generated method stub
			for(Player p : map.getPlayers())
			{
				
				System.out.println(p.getName()+" it's your turn to play");
				if(map.getItems().size() != 0)
				{
				p.localise(map.getItems());
				p.choose();
				}
				for(Enemies e : map.getEnemies())
				{
					//System.out.println(p.getName() +" has encountered a: "+ e.getName()+ " prepare to fight!"); //debug
					if(p.getPositionX() == e.getPositionX() && p.getPositionY() == e.getPositionY())
					{
						System.out.println(p.getName() +" has encountered a: "+ e.getName()+ " prepare to fight!");
					}
				}
				
				for(Item i : map.getItems())
				{
					//i.ToString(); debug
					if(p.getPositionX() == i.getPositionX() && p.getPositionY() == i.getPositionY())
					{
						System.out.println("Congratulation you have found a chest the chess countains: "+ i.getName());
						p.setPoints(p.getPoints()+ 1);
						//remove item from list
						map.setItems(map.getItems().stream().filter(x -> x!=i).collect(Collectors.toList()));
						
						if(map.getItems().size() == 0)
						{
							play= false;
							System.out.println("Congratulation you have found all the treasure of the swamp");
						}
						
					}
				}
				
			}
		}
		if(map.getPlayers().size()>1)
		{
			Player winner = new Player();
			int temp = 0;
			int max = 0;
			for(int i = 0; i< map.getPlayers().size() -1; i++)
			{
				if(map.getPlayers().get(i).getPoints() > map.getPlayers().get(i+1).getPoints())
				{
					temp = map.getPlayers().get(i).getPoints();
				}
				else
				{
					temp = map.getPlayers().get(i+1).getPoints();
				}
				if(temp > max)
				{
					max = temp;
					if(max == map.getPlayers().get(i).getPoints())
					{
						winner = map.getPlayers().get(i);
					}
					else
					{
						winner = map.getPlayers().get(i+1);
					}
						
				}
			}
			//Player winner = map.getPlayers().stream().reduce((a,b) -> Math.max(a.getPoints(), b.getPoints())).get();
			System.out.println(winner.getName()+ " has won the game. He found the most treasure, he found: "+ max + " treasures!");
		}
	}
	private void Intro() {
		// TODO Auto-generated method stub
		System.out.println(App.randomEnum(Intros.class));
	}
	public void Init()
	{		
		System.out.println("How Many players want to play today?");
		noOfPlayers = Integer.parseInt(App.scan.nextLine());

		System.out.println("How Many treasure do you want to find (or at least try)");
		noOfItems = Integer.parseInt(App.scan.nextLine());

		if(noOfPlayers <= 0 || noOfItems <=0)
		{
			Init();
		}
		else
		{
		//App.scan.close(); // find a way to enable that without crashing it all
		map = new Map(noOfItems, noOfPlayers);
		System.out.println("Map is being generated please wait...");
		}
	}
	
}
