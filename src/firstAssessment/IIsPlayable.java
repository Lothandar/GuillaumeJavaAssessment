package firstAssessment;

import java.util.List;

public interface IIsPlayable {
	int energy= 0;
	
	void rest();
	void eat();
	void order();
	void heal();
	void localise(List<Item> items);
	
}
