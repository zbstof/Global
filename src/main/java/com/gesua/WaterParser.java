package com.gesua;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by Chirp on 11.03.2017.
 */
public class WaterParser {

    public static final int WATER_FILE_COLUMNS = 12;
    private static final String TAB_SEPARATOR = "\t";

    static List<WaterStats> parseTSV(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        ArrayList<WaterStats> waterStatsList = new ArrayList<>();
        for (String line : lines) {
            List<String> strings = validateAndParse(line);
            List<Double> values = new ArrayList<>();
            for (String string : strings) {
                double parseResult = Double.parseDouble(string.replace(',', '.'));
                values.add(parseResult);
            }
            WaterStats waterStats = new WaterStats(
                    values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8), values.get(9), values.get(10), values.get(11));
            waterStatsList.add(waterStats);
        }
        return waterStatsList;
    }

    private static List<String> validateAndParse(String line) {
        String[] strings = line.split(TAB_SEPARATOR);
        if (strings.length != WATER_FILE_COLUMNS) {
            throw new IllegalArgumentException("Invalid columns count");
        }
        return Arrays.asList(strings);
    }

    static Map<Double, WaterStats> toMapByTemperature(List<WaterStats> list) {
        return list.stream().collect(toMap(ws -> ws.t, ws -> ws));
    }

    static List<WaterStats> parseTSV2(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllLines(path).stream()
                .map(line -> line.split(TAB_SEPARATOR))
                .map(WaterParser::arrayToDoubleList)
                .map(WaterStats::fromList)
                .collect(toList());
    }

    private static List<Double> arrayToDoubleList(String[] in) {
        return Arrays.stream(in)
                .map(str -> str.replace(',', '.'))
                .map(Double::parseDouble)
                .collect(toList());
    }
}