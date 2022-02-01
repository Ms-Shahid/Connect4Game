package com.game.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class GameApplication extends Application {

	public static void main (String[] args) {
		launch();
	}

	private Controller controller;

	@Override
	public void start (Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(new File("C:/My-developments/Java/My-Projects/FX-Game/src/main/resources/game.fxml").toURI().toURL());
		GridPane rootGridPane = fxmlLoader.load();

		controller = fxmlLoader.getController();
		controller.createPlayground();

		MenuBar menuBar = createMenuBar();
		menuBar.prefWidthProperty().bind(stage.widthProperty()); //create a menubar of size of pane
		Pane menuPane = (Pane) rootGridPane.getChildren().get(0); //get the first-child of grid
		menuPane.getChildren().add(menuBar);

		Scene scene = new Scene(rootGridPane);

		stage.setScene(scene);
		stage.setTitle("Connect Four");
		stage.setResizable(false);
		stage.show();

	}

	private MenuBar createMenuBar(){

		Menu menu = new Menu("File");
		MenuItem newGame = new MenuItem("New Game");
		newGame.setOnAction( actionEvent -> controller.resetGame());

		MenuItem resetGame = new MenuItem("Reset Game");
		resetGame.setOnAction( actionEvent -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem exitGame = new MenuItem("Exit Game");
		exitGame.setOnAction(actionEvent -> exitGame());

		menu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

		Menu helpMenu = new Menu("Help");
		MenuItem gameInfo = new MenuItem("About game");
		gameInfo.setOnAction(actionEvent -> aboutGame());

		SeparatorMenuItem helpMenuItem = new SeparatorMenuItem();
		MenuItem aboutDeveloper = new MenuItem("About developer");
		aboutDeveloper.setOnAction(actionEvent -> aboutDeveloper());

		helpMenu.getItems().addAll(gameInfo,helpMenuItem, aboutDeveloper);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu,helpMenu);

		return menuBar;
	}

	private void aboutDeveloper () {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Mohammed Shahid");
		alert.setContentText("Shahid is a software developer and engineer, who loves creating creative projects in field of " +
				"programming and technology Connect 4 game is one of them..");
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.showAndWait();
		alert.show();
	}

	private void aboutGame () {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How to Play?");
		alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, " +
				"six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. " +
				"The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. " +
				"The first player can always win by playing the right moves.");
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.show();
	}

	private void exitGame () {

		Platform.exit();
		System.exit(0);
	}

	private void resetGame () {

	}

}