package de.hohenheim.sopra2019.repository;

import de.hohenheim.sopra2019.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository
    extends JpaRepository<Project, Integer> {

}
