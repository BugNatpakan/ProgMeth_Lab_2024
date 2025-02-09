package entity.counter;

import entity.container.Dish;
import logic.Player;

public class DishWasher extends Counter {
	public DishWasher() {
		super("Dish Washer");
	}

	@Override
	public void interact(Player p) {
		if (!this.isPlacedContentEmpty()) {
			super.interact(p);
		} else {
			if (p.getHoldingItem() instanceof Dish d) {
				if (d.isDirty()) {
					super.interact(p);
				}
			}
		}
	}

	public void update() {
		if (this.getPlacedContent() instanceof Dish d) {
			d.clean(15);
		}
	}
}
