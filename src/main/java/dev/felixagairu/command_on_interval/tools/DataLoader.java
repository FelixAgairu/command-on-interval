package dev.felixagairu.command_on_interval.tools;

import com.google.gson.JsonObject;
import dev.felixagairu.configmanager.ConfigManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DataLoader {
    private static final String defaultConfigs ="""
            {
                  \t"0":{
                    \t\t"unit-use-ticks":false,
                    \t\t"delay":0,
                    \t\t"interval":10,
                    \t\t"command":""
                  \t}
            }""";

    private static final ConfigManager cM = new ConfigManager("command_on_interval.json", defaultConfigs);
    private static final JsonObject configs = cM.loadConfig();
    private static final Set<String> keys = configs.keySet();

    public static List<Boolean> listOfUnitUseTicks = new ArrayList<>();
    public static List<Integer> listOfDelay = new ArrayList<>();
    public static List<Integer> listOfInterval = new ArrayList<>();
    public static List<String> listOfCommands = new ArrayList<>();

    public static void load() {
        System.out.println("Processing cM: " + cM);
        System.out.println("Processing configs: " + configs);
        System.out.println("Processing keys: " + keys);
        System.out.println("Processing keys.size(): " + keys.size());

        for (int i = 0; i < keys.size(); i++) {
            JsonObject nestedConfigs = configs.getAsJsonObject(String.valueOf(i));
            System.out.println("Processing nestedConfigs: " + nestedConfigs);

            // Access specific properties in the nested JSON object
            System.out.println("Processing unit-use-ticks: " + nestedConfigs.get("unit-use-ticks").getAsBoolean());
            System.out.println("Processing i: " + i);
            System.out.println("Processing listOfUnitUseTicks.size(): " + listOfUnitUseTicks.size());
            listOfUnitUseTicks.add(i, nestedConfigs.get("unit-use-ticks").getAsBoolean());
            listOfDelay.add(i, nestedConfigs.get("delay").getAsInt());
            listOfInterval.add(i, nestedConfigs.get("interval").getAsInt());
            listOfCommands.add(i, nestedConfigs.get("command").getAsString());
        }
    }
}
