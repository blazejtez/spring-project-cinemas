package pl.edu.pg.menu.caffemenu.builders;

import pl.edu.pg.menu.caffemenu.entity.Dish;

import java.math.BigDecimal;

public class DishBuilder {
    private Dish dish = new Dish();

    public DishBuilder withName(String name) {
        dish.setName(name);
        return this;
    }

    public DishBuilder withPrice(BigDecimal price) {
        dish.setPrice(price);
        return this;
    }

    public Dish build() {
        return dish;
    }
}
