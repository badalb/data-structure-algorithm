package com.test.hash;

import java.util.HashMap;
import java.util.Map;

public class TravelItinerary {

	public static String getSource(Map<String, String> sourceDestinationPair,
			Map<String, String> destinationSourcePair) {
		for (Map.Entry<String, String> entry : sourceDestinationPair.entrySet()) {
			if (!destinationSourcePair.containsKey(entry.getKey())) {
				return entry.getKey();
			}
		}
		return null;
	}

	// public static String getDestination(Map<String, String>
	// sourceDestinationPair,
	// Map<String, String> destinationSourcePair) {
	// for (Map.Entry<String, String> entry : destinationSourcePair.entrySet())
	// {
	// if (!sourceDestinationPair.containsKey(entry.getKey())) {
	// return entry.getKey();
	// }
	// }
	// return null;
	// }

	public static void printItinerary(String source, Map<String, String> route) {
		System.out.println("Route :");
		String key = source;
		while (route.containsKey(key)) {
			System.out.println(key);
			key = route.get(key);
		}
		System.out.println(key);
	}

	public static void main(String[] args) {
		Map<String, String> sourceDestinationPair = new HashMap<String, String>();
		sourceDestinationPair.put("Chennai", "Banglore");
		sourceDestinationPair.put("Bombay", "Delhi");
		sourceDestinationPair.put("Goa", "Chennai");
		sourceDestinationPair.put("Delhi", "Goa");

		Map<String, String> destinationSourcePair = new HashMap<>();
		for (Map.Entry<String, String> entry : sourceDestinationPair.entrySet()) {
			destinationSourcePair.put(entry.getValue(), entry.getKey());
		}

		String source = getSource(sourceDestinationPair, destinationSourcePair);
		// System.out.println(source);
		// String detination = getDestination(sourceDestinationPair,
		// destinationSourcePair);
		// System.out.println(detination);

		printItinerary(source, sourceDestinationPair);
	}

}
