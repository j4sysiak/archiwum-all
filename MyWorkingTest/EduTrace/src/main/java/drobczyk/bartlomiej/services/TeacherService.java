package drobczyk.bartlomiej.services;

import drobczyk.bartlomiej.exceptions.NoSuchRoleException;
import drobczyk.bartlomiej.exceptions.TeacherNotFoundException;
import drobczyk.bartlomiej.model.dto.TeacherDto;
import drobczyk.bartlomiej.model.roles.UserRole;
import drobczyk.bartlomiej.model.teacher.Teacher;
import drobczyk.bartlomiej.repo.RoleRepo;
import drobczyk.bartlomiej.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;

@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private static final String DEFAULT_ROLE = "ROLE_USER";


    @Autowired
    public TeacherService(TeacherRepo teacherRepo, RoleRepo roleRepo,
                          PasswordEncoder passwordEncoder) {
        this.teacherRepo = teacherRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    public Teacher getTeacherByLogin(String login) {
        return teacherRepo.findByLogin(login)
                .orElseThrow(() -> new TeacherNotFoundException(login));
    }


    @Transactional
    public boolean registerTeacher(TeacherDto teacherDto) {
        if (!isSuchTeacherAlreadyExists(teacherDto.getLogin(), teacherDto.getMail())) {
            Teacher teacher = new Teacher(teacherDto.getLogin(), teacherDto.getMail(), teacherDto.getPassword(),
                    LocalDateTime.now(), new HashSet<>());
            UserRole defaultRole = roleRepo.findByRole(DEFAULT_ROLE)
                    .orElseThrow(NoSuchRoleException::new);
            teacher.getRoles().add(defaultRole);
            String encodedPassword = passwordEncoder.encode(teacher.getPassword());
            teacher.setPassword(encodedPassword);
            teacherRepo.save(teacher);
            return true;
        } else return false;
    }

    public boolean isSuchTeacherAlreadyExists(String login, String mail) {
        return teacherRepo.existsTeacherByLoginAndEmail(login, mail);
    }
}