package pl.edu.pg.menu.caffemenu.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.entity.Cinema;
import pl.edu.pg.menu.caffemenu.repository.MenuRepository;

import java.util.*;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }



    public void create(Cinema cinema) {
        menuRepository.save(cinema);

    }

    public List<Cinema> findAll() {
        return menuRepository.findAll();
    }

    public Cinema findById(UUID uuid) {
        return this.menuRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + uuid));
    }

    public void deleteById(UUID uuid) {
        this.menuRepository.deleteById(uuid);
    }
}
