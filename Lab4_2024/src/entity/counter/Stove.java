package entity.counter;

import entity.base.Item;
import entity.base.Updatable;
import entity.container.Pan;
import logic.Player;

public class Stove extends Counter implements Updatable {
	public Stove() {
		super("Stove");
	}

	public Stove(Item content) {
		super("Stove");
		this.setPlacedContent(content);
	}

	@Override
	public void interact(Player p) {
		if (!this.isPlacedContentEmpty()) {
			super.interact(p);
		} else {
			if (p.getHoldingItem() instanceof Pan) {
				super.interact(p);
			}
		}
	}

	@Override
	public void update() {
		if (this.getPlacedContent() instanceof Pan p) {
			p.cook();
		}
	}
}
