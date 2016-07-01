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
package tracker;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TrackerTest {
   Tracker t = new Tracker();

    @Test
    public void testTracker() {
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            t.nextPhase();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            t.nextPhase();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            t.nextPhase();
            List<String> list = Files.readAllLines(Paths.get("TrackingData.txt"));
            assertEquals("3",list.get(1));
            assertEquals("3",list.get(3));
            assertEquals("3",list.get(5));
        }catch(IOException e){}
    }
}