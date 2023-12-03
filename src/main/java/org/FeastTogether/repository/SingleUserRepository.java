package org.FeastTogether.repository;

import org.FeastTogether.entity.SingleUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SingleUserRepository extends JpaRepository<SingleUser, UUID> {
    @Query("SELECT distinct use FROM SingleUser use LEFT JOIN FETCH use.ingredients")
    List<SingleUser> findAllBy();

    @Query("SELECT distinct use FROM SingleUser use " +
            "LEFT JOIN FETCH use.ingredients WHERE use.id = :id")
    Optional<SingleUser> findOneById(UUID id);

    @Query("SELECT distinct use FROM SingleUser use LEFT JOIN FETCH use.ingredients")
    List<SingleUser> findAllBy(Pageable pageable);
}
