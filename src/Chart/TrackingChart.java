/*
 * Copyright (c) 2016. Caro Jachmann, Dominik Kuhnen, Jule Pohlmann, Kai Brandt, Kai Holzinger
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package Chart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TrackingChart extends Application implements Chart {

	//Prepare the stage
    @Override 
    public void start(Stage stage) {
		stage.setTitle("Tracking Analyse");
		stage.getIcons().add(new Image("file:icon.png"));
		stage.sizeToScene();
		stage.setResizable(false);
		stage.setScene(erstelleScene());
		stage.show();
    }

	/*
	* @return int containing data gathered from the tracker. Reads result from a file.
	* @param info:
	* 1: returns value for green,
	* 2: returns value for red,
	* 3: returns value for refactor,
	* any other value returns 0.
	* */
	@Override
	public int leseZeiten(int info) throws IOException {
		List<String> list = Files.readAllLines(Paths.get("TrackingData.txt"));

		return (info == 1) ? (Integer.parseInt(list.get(3)))
				: (info == 2) ? Integer.parseInt(list.get(1))
				: (info == 3) ? Integer.parseInt(list.get(5))
				: 0;

	}

	//@return a PieChart Element which represents how much time it took the user to finish the specific exercise-stage
	@Override
	public PieChart erstellePieChart() throws IOException {
		ObservableList<PieChart.Data> daten = FXCollections.observableArrayList(
                new PieChart.Data("Red " + leseZeiten(1) + " Sekunden", leseZeiten(1)),                	
                new PieChart.Data("Green " + leseZeiten(2) + " Sekunden", leseZeiten(2)),	                
                new PieChart.Data("Refactor " + leseZeiten(3) + " Sekunden", leseZeiten(3)));
        PieChart pieChart = new PieChart(daten);
        pieChart.setTitle(setzteTitel());
        pieChart.setLegendVisible(false);
		pieChart.setStyle("-fx-background-color: rgba(4, 6, 4, 0.04)");

		for (int i = 0; i < daten.size(); i++) {
			if (i == 0) daten.get(i).getNode().setStyle("-fx-pie-color: #FF0000;");
			if (i == 1) daten.get(i).getNode().setStyle("-fx-pie-color: #008000;");
			if (i == 2) daten.get(i).getNode().setStyle("-fx-pie-color: #4682B4;");
		}
        return pieChart;
	}

	public String setzteTitel() throws IOException{
		double red = leseZeiten(1);
		double green = leseZeiten(2);
		double refactor = leseZeiten(3);
		double uebergang = red + green + refactor;
		double prozent = 100 / uebergang;
		red = red * prozent;
		red = Math.round(red * 10)/10.0;
		green = green * prozent;
		green = Math.round(green * 10)/10.0;
		refactor = refactor * prozent;
		refactor = Math.round(refactor * 10)/10.0;

		return ("Sie haben " + red + "% ihrer Zeit in der Phase RED, \n                 "
		+ green + "% in der Phase GREEN und \n                 "
		+ refactor +"% in der REFACTOR-Phase verbracht.");
	}
	
	//@return a scene which contains a PieChart child
	public Scene erstelleScene() {
		Scene scene = new Scene(new Group());
		try {
			((Group) scene.getRoot()).getChildren().addAll(erstellePieChart());
		} catch (IOException e) {}
		return scene;
	}

	public static void main(String[] args) {
	        launch(args);
	}
}
