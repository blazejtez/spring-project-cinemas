package pl.edu.pg.menu.caffemenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.menu.caffemenu.entity.Cinema;

import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Cinema, UUID> {


}
