package Enums;

import java.util.HashMap;
import java.util.Map;

public enum Parameters {

    WEEK(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Sunday", "Saturday"});

    private Map<Integer,String> value = new HashMap<Integer, String>();

    Parameters(String[] strings) {
        int counter = 1;
        for(String day:strings){
            value.put(counter,day);
            counter++;
        }
    }

    public Map<Integer,String> getValue() {
        return this.value;
    }
}
