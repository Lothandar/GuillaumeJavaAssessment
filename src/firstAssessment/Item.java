package firstAssessment;

import java.util.Random;

public class Item implements IOnMap{
	private int positionX;
	private int positionY;
	private int positionZ;
	private String name;
	
	public Item() {
		this.Init();
	}
	
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public int getPositionZ() {
		return positionZ;
	}
	public void setPositionZ(int positionZ) {
		this.positionZ = positionZ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void Init() {
		Random rnd = new Random();
		this.positionX = rnd.nextInt(100);
		this.positionY = rnd.nextInt(100);
		this.positionZ = rnd.nextInt(100);
		this.name = App.randomEnum(Names.class).toString();
	}
	
	public void ToString() 
	{
		System.out.println(String.format("This Item is a: %s located on %d X; %d Y", name, positionX, positionY));
	}

}
