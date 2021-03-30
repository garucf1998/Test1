package com.example.demo.repository;

import com.example.demo.enity.BenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
    public interface BenhNhanRepository extends JpaRepository<BenhNhan,Integer> {

}

