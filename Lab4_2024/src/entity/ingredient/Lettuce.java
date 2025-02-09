package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {
	private boolean chopState;

	public Lettuce() {
		super("Lettuce");
		chopState = false;
		this.setEdible(true);
	}

	public void chop() {
		if (this.chopState == false) {
			chopState = true;
			this.setName("Chopped Lettuce");
			this.setEdible(true);
		}
	}

	@Override
	public boolean isChopped() {
		return chopState;
	}
}
