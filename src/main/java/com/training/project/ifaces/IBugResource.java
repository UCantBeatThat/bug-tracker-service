package com.training.project.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.project.entity.BugResource;

@Repository
public interface IBugResource extends JpaRepository<BugResource, Integer> {

}
