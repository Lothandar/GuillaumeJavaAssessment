package firstAssessment;

import java.util.ArrayList;
import java.util.List;

public class Map {
	
	private List<Item> items = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	private List<Enemies> enemies = new ArrayList<>();
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Map(int item, int player)
	{
		for(int i = 1; i<= item; i++)
		{
			items.add(new Item());
		}
		for(int i = 1; i<= player; i++)
		{
			players.add(new Player(i));
		}
		for(int i = 1; i<= ((item*player)/2); i++)
		{
			enemies.add(new Enemies());
		}
			
	}

	public List<Enemies> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Enemies> enemies) {
		this.enemies = enemies;
	}
}
