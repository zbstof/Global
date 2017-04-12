package com.gesua;

import org.junit.Test;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

/**
 * Created by Chirp on 11.03.2017.
 */
public class WaterParserTest {

    public static final String FILE = "water_from_pdf.tsv";
    public static final double DELTA = 0.000001;

    @Test
    public void testWaterParserFirst() throws Exception {
        List<WaterStats> waterStatsList = WaterParser.parseTSV(FILE);
        assertEquals(55.1, waterStatsList.get(0).lamda, DELTA);
    }

    @Test
    public void testWaterParserThenth() throws Exception {
        List<WaterStats> waterStatsList = WaterParser.parseTSV(FILE);
        assertEquals(68, waterStatsList.get(9).lamda, DELTA);
    }

    @Test
    public void testToMapWithStreams() throws Exception {
        Map<Double, WaterStats> map = WaterParser.toMapByTemperature(WaterParser.parseTSV2(FILE));
        assertEquals(68, map.get(90.0).lamda, DELTA);
    }
}