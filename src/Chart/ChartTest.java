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

import static org.junit.Assert.*;
import org.junit.Test;

public class ChartTest {
    TrackingChart tc = new TrackingChart();

    //Some simple tests to get values from trackingdata.txt, you need to change the values in the txt file to make it work
    @Test
    public void test1() {
        assertEquals(30, tc.leseZeiten(2));
    }

    @Test
    public void test2() {
        assertEquals(12, tc.leseZeiten(1));
    }

    @Test
    public void test3() {
        assertEquals(15, tc.leseZeiten(3));
    }

}
