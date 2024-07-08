package org.springframework.boot.exam.repository;


import org.springframework.boot.exam.model.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageRepository extends JpaRepository<Manage,Long> {
}
