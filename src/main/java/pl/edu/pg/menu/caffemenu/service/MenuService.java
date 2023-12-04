package pl.edu.pg.menu.caffemenu.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import pl.edu.pg.menu.caffemenu.repository.MenuRepository;

import java.util.*;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }



    public void create(Menu menu) {
        menuRepository.save(menu);

    }

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu findById(UUID uuid) {
        return this.menuRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + uuid));
    }

}
