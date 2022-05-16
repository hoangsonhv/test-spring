package com.example.testspringboot.repository;

import com.example.testspringboot.entity.Street;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {

    @Query(value = "SELECT * FROM streets a WHERE a.name LIKE %:name%",
            nativeQuery = true)
    List<Street> search(@Param("name") String name);

    @Query(value = "SELECT * FROM streets JOIN districts on streets.district_id = districts.id",
            nativeQuery = true)
    List<Street> searchByDistrict(@Param("id") Integer id);
}
