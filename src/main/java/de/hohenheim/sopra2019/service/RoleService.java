package de.hohenheim.sopra2019.service;

import de.hohenheim.sopra2019.model.Role;
import de.hohenheim.sopra2019.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;

  /**
   * Speichert ein Role-Objekt.
   * @param role die zu speichernde Role.
   * @return gespeichertes Role-Objekt inkl. generierter ID.
   */
  public Role saveRole(Role role) {
    return roleRepository.save(role);
  }

}
