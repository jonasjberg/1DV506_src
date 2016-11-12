package js224eh_lab1;

import static org.junit.Assert.*;

/**
 * Created by Jonas Sjöberg (js224eh) on 2016-11-12.
 */
public class VindAvkylningTest
{

    @org.junit.Test
    public void calculateApparentTemperature() throws Exception
    {
        // double windSpeed, temperature, expect;
        // windSpeed   = 8.4;
        // temperature = -7.8;
        // expect = -24;

        assertEquals(-24, VindAvkylning.calculateApparentTemperature(-7.8, 8.4), 0.01);
        assertEquals(-14, VindAvkylning.calculateApparentTemperature(-1, 8.4), 0.01);
        assertEquals(-10, VindAvkylning.calculateApparentTemperature(-5, 3.14), 0.01);
    }
}