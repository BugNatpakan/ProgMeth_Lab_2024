package logic.unit;

import java.util.ArrayList;

public class BaseUnit {

	private int row;
	private int column;
	private boolean isWhite;
	private String name;
	protected int hp;
	protected int power;
	protected boolean isFlying;

	public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
		this.power = 1;
		this.isFlying = false;
		setHp(2);
		setColumn(startColumn);
		setRow(startRow);
		setWhite(isWhite);
		setName(name);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {

		row = Math.max(0, row);
		row = Math.min(4, row);
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		column = Math.max(0, column);
		column = Math.min(4, column);
		this.column = column;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public boolean isFlying() {
		return isFlying;
	}

	public boolean move(int direction) {

		if (direction == 0) {
			if (row + 1 < 0 || row + 1 > 4) {
				return false;
			} else {
				this.row++;
				return true;
			}
		} else if (direction == 1) {
			if (column + 1 < 0 || column + 1 > 4) {
				return false;
			} else {
				this.column++;
				return true;
			}
		} else if (direction == 2) {
			if (row - 1 < 0 || row - 1 > 4) {
				return false;
			} else {
				this.row--;
				return true;
			}
		} else if (direction == 3) {
			if (column - 1 < 0 || column - 1 > 4) {
				return false;
			} else {
				this.column--;
				return true;
			}
		}

		return false;

	}

	public void attack(ArrayList<BaseUnit> targetPieces) {
		for (BaseUnit targetUnit : targetPieces) {
			if (!targetUnit.isFlying) {
				if (targetUnit.getRow() == this.row && targetUnit.getColumn() == this.column) {
					System.out.println(this.getName() + " attacks " + targetUnit.getName());

					targetUnit.setHp(targetUnit.getHp() - this.power);
				}
			}
		}
	}
}
