package com.pratica.dextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratica.dextra.model.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

}
