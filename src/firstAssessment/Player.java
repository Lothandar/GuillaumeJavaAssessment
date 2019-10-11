package firstAssessment;

import java.util.List;
import java.util.Random;

public class Player extends Character implements IIsPlayable , IsFightable{

	private int turn = 0;
	private int points = 0;
	private int ID;
	private int energy = 100;  //change this value to a very high one for testing purpose

	public Player()
	{
		
	}
	
	public Player(int ID)
	{
		this.ID = ID;
		this.Init();
	}
	
	
	@Override
	public void Init() {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		this.setPositionX(rnd.nextInt(100));
		this.setPositionY(rnd.nextInt(100));
		System.out.println("Player "+ID+" What will be your character name?");
		this.setName(App.scan.nextLine());
		//scanner.close();
		System.out.println("Alright "+ this.getName() + "! I hope you are ready for new adventures today in the world of POKE**** copyright strike");
		
	}

	@Override
	public void rest() {
		// TODO Auto-generated method stub
		setEnergy(100);
		System.out.println("You rest your energy has been refilled");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("You eat some food your are less hungry now");
		
	}

	@Override
	public void order() {
		System.out.println("You ordered a bonus you will receive it in few turns");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		//can only be casted if in fight
		//implement enemies and pvp
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//can only be casted if in fight
		//implement enemies and pvp
	}

	@Override
	public void heal() {
		// TODO Auto-generated method stub
		this.setHp(100);
		System.out.println("you heal your injuries. You feel way better now");
	}

	@Override
	public void localise(List<Item> items) {
		// TODO Auto-generated method stub
		int min = 1000;
		int temp = 0;
		String direction = null;
	//	items
	//	.stream()
	//	.reduce((a, b) -> Math.min(Math.hypot(Math.abs(positionX - a.getPositionX()), Math.abs(positionY - a.getPositionY())) , Math.hypot(Math.abs(positionX - b.getPositionX()), Math.abs(positionY - b.getPositionY())))).get();
		if(items.size() == 1)
		{
			min = (int) Math.hypot(Math.abs(getPositionX() - items.get(0).getPositionX()), Math.abs(getPositionY() - items.get(0).getPositionY()));
				if(getPositionY() > items.get(0).getPositionY())
				{
					direction = "South";
					if(getPositionX() > items.get(0).getPositionX())
					{
						direction+= "-West";
					}
					else if(getPositionX() < items.get(0).getPositionX())
					{
						direction+= "-East";
					}
				}
				else if(getPositionY() < items.get(0).getPositionY())
				{
					direction= "North";
					if(getPositionX() > items.get(0).getPositionX())
					{
						direction+= "-West";
					}
					else if(getPositionX() < items.get(0).getPositionX())
					{
						direction+= "-East";
					}
				}
				else
				{
					if(getPositionX() > items.get(0).getPositionX())
					{
						direction= "West";
					}
					else if(getPositionX() < items.get(0).getPositionX())
					{
						direction= "East";
					}
				}
		}
		else
		{
			for(int i = 0; i< items.size() - 1; i++)
			{
				temp = (int) Math.min(Math.hypot(Math.abs(getPositionX() - items.get(i).getPositionX()), Math.abs(getPositionY() - items.get(i).getPositionY())) , Math.hypot(Math.abs(getPositionX() - items.get(i +1).getPositionX()), Math.abs(getPositionY() - items.get(i+1).getPositionY())));
				if(temp < min)
				{
					min = temp;	
					if(min== Math.hypot(Math.abs(getPositionX() - items.get(i).getPositionX()), Math.abs(getPositionY() - items.get(i).getPositionY()))) 
					{
						if(getPositionY() > items.get(i).getPositionY())
						{
							direction = "South";
							if(getPositionX() > items.get(i).getPositionX())
							{
								direction+= "-West";
							}
							else if(getPositionX() < items.get(i).getPositionX())
							{
								direction+= "-East";
							}
						}
						else if(getPositionY() < items.get(i).getPositionY())
						{
							direction= "North";
							if(getPositionX() > items.get(i).getPositionX())
							{
								direction+= "-West";
							}
							else if(getPositionX() < items.get(i).getPositionX())
							{
								direction+= "-East";
							}
						}
						else
						{
							if(getPositionX() > items.get(i).getPositionX())
							{
								direction= "West";
							}
							else if(getPositionX() < items.get(i).getPositionX())
							{
								direction= "East";
							}
						}
					}
					else
					{
						if(getPositionY() > items.get(i+1).getPositionY())
						{
							direction = "South";
							if(getPositionX() > items.get(i+1).getPositionX())
							{
								direction+= "-West";
							}
							else if(getPositionX() < items.get(i+1).getPositionX())
							{
								direction+= "-East";
							}
						}
						else if(getPositionY() < items.get(i+1).getPositionY())
						{
							direction= "North";
							if(getPositionX() > items.get(i+1).getPositionX())
							{
								direction+= "-West";
							}
							else if(getPositionX() < items.get(i+1).getPositionX())
							{
								direction+= "-East";
							}
						}
						else
						{
							if(getPositionX() > items.get(i+1).getPositionX())
							{
								direction+= "West";
							}
							else if(getPositionX() < items.get(i+1).getPositionX())
							{
								direction+= "East";
							}
						}
					}
				}
			}
		}
		
		//get the direction.
		System.out.println("A treasure is: "+min + " away in the direction: " + direction);
	
	}


	
	public void choose() {
		// TODO Auto-generated method stub
		System.out.println("choose your action you can:");
		System.out.println("rest \n eat \n order\n heal\n or move ");
		switch( App.scan.nextLine().toLowerCase())
		{
		case "rest":
			rest();
			break;
		case "eat":
			eat();
			break;
		case "order":
			order();
			break;
		case "heal":
			heal();
			break;
		case "move":
			if(energy>0)
			{
				move();
			}
			else
			{
				rest();
			}
			break;
		}
	}


	private void move() {
		// TODO Auto-generated method stub
		System.out.println("What direction do you want to move?");
		switch( App.scan.nextLine().toLowerCase())
		{
		case "north":
			this.setPositionY(getPositionY() + distance());
			
			break;
		case "south":
			this.setPositionY(getPositionY() - distance());
			break;
		case "east":
			this.setPositionX(getPositionX() + distance());
			break;
		case "west":
			this.setPositionX(getPositionX() - distance());
			break;
		}
		setTurn(getTurn() + 1);
	}
	private int distance()
	{
		System.out.println("How much distance do you want to travel in this direction?");
		int distance = Integer.parseInt(App.scan.nextLine());
		if(distance<energy)
		{
			this.setEnergy(energy - distance);
		}
		else
		{
			distance -=  (distance - energy); 
			System.out.println("You are tired from all this walking. You will have to rest next turn");
		}
		return distance;
	}


	public int getTurn() {
		return turn;
	}


	public void setTurn(int turn) {
		this.turn = turn;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
}
