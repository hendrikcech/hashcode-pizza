package model;

public class Pizza {
    private Topping[][] pizza;

    public Pizza(Topping[][] pizza) {
	this.pizza = pizza;
    }

    public Topping getTopping(Coordinate c) {
	return pizza[c.getRow()][c.getColumn()];
    }

    public void setTopping(Coordinate c, Topping topping) {
	pizza[c.getRow()][c.getColumn()] = topping;
    }

    public int getRowCount() {
	return pizza.length;
    }

    public int getColumnCount() {
	return pizza[0].length;
    }
}
