package pl.edu.pg.menu.caffemenu.builders;

import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.entity.Menu;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MenuBuilder {
    private Menu menu = new Menu();

    public MenuBuilder withName(String name) {
        menu.setName(name);
        return this;
    }

    public MenuBuilder withStartDate(LocalDate startDate) {
        menu.setStartDate(startDate);
        return this;
    }

    public MenuBuilder withEndDate(LocalDate endDate) {
        menu.setEndDate(endDate);
        return this;
    }

    public MenuBuilder withDish(Dish dish) {
        menu.addDish(dish);
        return this;
    }

    public Menu build() {
        return menu;
    }
}
