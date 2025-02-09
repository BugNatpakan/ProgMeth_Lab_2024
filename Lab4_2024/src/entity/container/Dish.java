package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
	private int dirty;

	public Dish() {
		super("Dish", 4);
		setDirty(0);
	}

	public Dish(int dirty) {
		super("Dish", 4);
		setDirty(dirty);
	}

	public int getDirty() {
		return dirty;
	}

	public void setDirty(int dirty) {
		dirty = Math.max(0, dirty);
		this.dirty = dirty;

		if (getDirty() > 0) {
			this.setName("Dirty Dish");
		} else {
			this.setName("Dish");
		}
	}

	public boolean isDirty() {
		if (dirty > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean verifyContent(Ingredient i) {
		if (!isDirty() && i.isEdible()) {
			return true;
		} else {
			return false;
		}
	}

	public void clean(int amount) {
		this.setDirty(getDirty() - amount);
	}

	public String toString() {
		if (isDirty()) {
			return StringUtil.formatNamePercentage(this.getName(), dirty);
		} else {
			return super.toString();
		}
	}

}
