package org.packman.pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {
    List<Pack> findByCategoryIdAndPositionGreaterThan(Long categoryId, Integer position);

    List<Pack> findByCategoryIdAndPositionGreaterThanEqual(Long categoryId, Integer position);

    List<Pack> findAllByCategoryIdOrderByPosition(Long categoryId);
}
