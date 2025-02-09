package logic.unit;

public class FlyingUnit extends BaseUnit {

	public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		this.setHp(2);
		this.isFlying = true;
	}

	@Override
	public boolean move(int direction) {
		
		int row = this.getRow();
		int column = this.getColumn();
		
		if (direction == 0) {
			if (row + 2 < 0 || row + 2 > 4) {
				return false;
			} else {
				this.setRow(row+2);
				
				return true;
			}
		} else if (direction == 1) {
			if (column + 2 < 0 || column + 2 > 4) {
				return false;
			} else {
				this.setColumn(column+2);
				return true;
			}
		} else if (direction == 2) {
			if (row - 2 < 0 || row - 2 > 4) {
				return false;
			} else {
				this.setRow(row-2);
				return true;
			}
		} else if (direction == 3) {
			if (column - 2 < 0 || column - 2 > 4) {
				return false;
			} else {
				this.setColumn(column-2);
				return true;
			}
		}

		return false;

	}

}
