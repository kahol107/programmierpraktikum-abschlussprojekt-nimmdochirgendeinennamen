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

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.chart.*;

interface Chart{
    File file = new File("TrackingData.txt");

    //reads tracking data from tracking file and returns one of the values.
	int leseZeiten(int info);
    //returns a PieChart representing the time the user needed to finish the phase
	PieChart erstellePieChart();
    //creates a scene that contains the PieChart
	Scene erstelleScene();
}
