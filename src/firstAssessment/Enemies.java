package firstAssessment;

import java.util.Random;

public class Enemies extends Character implements IOnMap, IsFightable{

	public Enemies()
	{
		Init();
	}
	
	@Override
	public void Init() {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		this.setPositionX(rnd.nextInt(100));
		
		this.setPositionY(rnd.nextInt(100));
		this.setName(App.randomEnum(EnemiesName.class).toString());
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
