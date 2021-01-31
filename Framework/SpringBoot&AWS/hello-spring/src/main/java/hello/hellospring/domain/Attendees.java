package hello.hellospring.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attendees {
    private Map<String,String> attendee;
    public Attendees() {
        this.attendee = new HashMap<>();
    }

    public void add(String name){
        this.attendee.put(name,name+name);
    }

    public String get(String name){
        return attendee.containsKey(name) ? attendee.get(name):null;
    }
}
