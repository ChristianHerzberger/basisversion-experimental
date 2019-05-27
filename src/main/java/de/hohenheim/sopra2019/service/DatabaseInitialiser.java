package de.hohenheim.sopra2019.service;

import de.hohenheim.sopra2019.model.Project;
import de.hohenheim.sopra2019.model.Role;
import de.hohenheim.sopra2019.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseInitialiser implements ApplicationListener<ContextRefreshedEvent> {

  private static final Logger logger = LoggerFactory.getLogger(DatabaseInitialiser.class);

  @Autowired
  private ProjectService projectService;

  @Autowired
  private UserService userService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    logger.info("Initialisiere Datenbank mit Testdaten...");

    Role userRole = new Role("ROLE_USER");
    Role adminRole = new Role("ROLE_ADMIN");
    roleService.saveRole(userRole);
    roleService.saveRole(adminRole);

    Set<Role> userRoles = new HashSet<>();
    userRoles.add(userRole);

    Set<Role> adminRoles = new HashSet<>();
    adminRoles.add(adminRole);

    User student = new User();
    student.setUsername("max");
    student.setPassword(passwordEncoder.encode("password"));
    student.setEmail("example@uni-hohenheim.de");
    student.setRoles(userRoles);
    userService.saveUser(student);

    User admin = new User();
    admin.setUsername("admin");
    admin.setPassword(passwordEncoder.encode("admin"));
    admin.setEmail("admin@uni-hohenheim.de");
    admin.setRoles(adminRoles);
    userService.saveUser(admin);

    Project sopra = new Project();
    sopra.setProjectName("Softwarepraktikum");
    projectService.saveProject(sopra);

    Project seminar = new Project();
    seminar.setProjectName("Seminar");
    projectService.saveProject(seminar);


  }
}
