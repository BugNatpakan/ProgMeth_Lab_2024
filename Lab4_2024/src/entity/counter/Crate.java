package entity.counter;

import entity.base.Ingredient;
import logic.InvalidIngredientException;
import logic.LogicUtil;
import logic.Player;

public class Crate extends Counter {
	private String myIngredient;

	public Crate(String s) {
		super(s + " Crate");
		setMyIngredient(s);
	}

	@Override
	public void interact(Player p) {
		if (!p.isHandEmpty()) {
			super.interact(p);
		} else {
			Ingredient newIngrediant;
			try {
				newIngrediant = LogicUtil.createIngredientFromName(myIngredient);
			} catch (InvalidIngredientException e) {
				p.setHoldingItem(null);
				return;
			}
			p.setHoldingItem(newIngrediant);
		}
	}

	public String getMyIngredient() {
		return myIngredient;
	}

	public void setMyIngredient(String myIngredient) {
		this.myIngredient = myIngredient;
	}
}
