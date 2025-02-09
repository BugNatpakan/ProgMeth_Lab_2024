package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
	private int cookedPercentage;

	public Egg() {
		super("Egg");
		setCookedPercentage(0);
	}

	public void cook() {
		this.cookedPercentage += 12;

		if (getCookedPercentage() > 100) {
			this.setName("Burnt Egg");
			this.setEdible(false);
		} else if (getCookedPercentage() > 80) {
			this.setName("Fried Egg");
			this.setEdible(true);
		} else if (getCookedPercentage() > 50) {
			this.setName("Sunny Side Egg");
			this.setEdible(true);
		} else {
			this.setName("Raw Egg");
			this.setEdible(false);
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

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookPercentage) {
		this.cookedPercentage = cookPercentage;
	}

}
