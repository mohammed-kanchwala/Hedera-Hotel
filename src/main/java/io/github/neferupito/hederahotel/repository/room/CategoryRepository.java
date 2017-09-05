package io.github.neferupito.hederahotel.repository.room;

import io.github.neferupito.hederahotel.model.room.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
