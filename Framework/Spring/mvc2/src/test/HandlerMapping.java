package test;

import java.util.HashMap;

public class HandlerMapping {
	HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("hello", new HelloController()); // hello가 오면 HelloController를 수행하게 mapping
	}

	public Controller getController(String name) {
		return mappings.get(name);
	}
}
