package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {

	public RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		this.setHp(2);
	}



	public void attack(ArrayList<BaseUnit> targetPieces) {
		for (int i = 0; i < targetPieces.size(); i++) {
			BaseUnit eachUnit = targetPieces.get(i);

			int row2Add = (isWhite() ? 1 : -1);

			if ((eachUnit.getColumn() == getColumn()) && (eachUnit.getRow() == getRow() + row2Add)) {
				targetPieces.get(i).setHp(eachUnit.getHp() - getPower());
				System.out.println(this.getName() + " attacks " + eachUnit.getName());
			}
		}

	}

}
