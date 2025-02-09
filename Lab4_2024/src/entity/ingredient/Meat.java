package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {

	private boolean chopState;
	private int cookedPercentage;

	public Meat() {
		super("Meat");
		setChopState(false);
		setCookedPercentage(0);
	}

	public void chop() {
		if (chopState || cookedPercentage == 0) {
			this.setName("Minced Meat");
			chopState = true;
		}
	}

	public boolean isChopped() {
		return chopState;
	}

	public void cook() {
		if (isChopped()) {
			setCookedPercentage(getCookedPercentage() + 15);

			if (getCookedPercentage() > 100) {
				this.setName("Burnt Burger");
				this.setEdible(false);
			} else if (getCookedPercentage() > 80) {
				this.setName("Cooked Burger");
				this.setEdible(true);
			} else {
				this.setName("Raw Burger");
				this.setEdible(false);

			}
		} else {
			setCookedPercentage(getCookedPercentage() + 10);

			if (getCookedPercentage() > 100) {
				this.setName("Burnt Steak");
				this.setEdible(false);
			} else if (getCookedPercentage() > 80) {
				this.setName("Well Done Steak");
				this.setEdible(true);
			} else if (getCookedPercentage() > 50) {
				this.setName("Medium Rare Steak");
				this.setEdible(true);
			} else {
				this.setName("Raw Meat");
				this.setEdible(false);
			}
		}
	}

	public boolean isBurnt() {
		if (cookedPercentage > 100) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);

	}

	public boolean isChopState() {
		return chopState;
	}

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}

}
