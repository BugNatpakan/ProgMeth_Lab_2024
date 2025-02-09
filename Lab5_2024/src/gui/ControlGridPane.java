package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ControlGridPane extends VBox {
	private final String miningImageURL;
	private ControlPane controlPane;

	public ControlGridPane(ControlPane controlPane) {
		this.controlPane = controlPane;
		miningImageURL = "bitcoin.png";

		ImageView image = new ImageView(new Image(miningImageURL));
		image.setFitWidth(150);
		image.setFitHeight(150);

		BorderPane borderpane = new BorderPane();
		borderpane.setPrefHeight(200);
		borderpane.setPrefWidth(150);
		borderpane.setCenter(image);
		this.getChildren().addAll(borderpane, this.controlPane);
	}
}
