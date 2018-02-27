package frequency;

import model.Topping;

public class ToppingFrequency {
    int tomatoes = 0;
    int mushrooms = 0;

    public void add(Topping t) {
	if (t == Topping.TOMATO) {
	    tomatoes++;
	} else if (t == Topping.MUSHROOM) {
	    mushrooms++;
	}
    }

    public int getTomatoes() {
	return tomatoes;
    }

    public int getMushrooms() {
	return mushrooms;
    }
}
