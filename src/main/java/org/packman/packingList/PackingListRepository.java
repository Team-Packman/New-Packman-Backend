package org.packman.packingList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackingListRepository extends JpaRepository<PackingList, Long> {
    List<PackingList> findByPositionGreaterThan(Integer position);

    List<PackingList> findByPositionGreaterThanEqual(Integer position);

    List<PackingList> findAllByUserIdOrderByPosition(Long userId);
}
