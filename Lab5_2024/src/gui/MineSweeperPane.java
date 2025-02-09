package gui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MineSweeperPane extends GridPane {
	private ArrayList<MineSweeperSquare> allCells;

	public MineSweeperPane() {
		allCells = new ArrayList<MineSweeperSquare>();
		this.setHgap(8);
		this.setVgap(8);
		this.setPadding(new Insets(8));
		this.setPrefWidth(500);
		this.setAlignment(Pos.CENTER);

		Border bd = new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

		this.setBorder(bd);
		BackgroundFill BGF = new BackgroundFill(Color.WHITE, null, null);
		Background bg = new Background(BGF);
		this.setBackground(bg);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				MineSweeperSquare mineSq = new MineSweeperSquare(i, j);

				allCells.add(mineSq);
				this.add(mineSq, i, j);
			}
		}

	}

	public ArrayList<MineSweeperSquare> getAllCells() {
		return allCells;
	}

}
