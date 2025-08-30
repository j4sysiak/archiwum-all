package drobczyk.bartlomiej.session;

import drobczyk.bartlomiej.model.teacher.Teacher;
import drobczyk.bartlomiej.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class TeacherSession implements AuthenticationFacade {

    private final TeacherService teacherService;

    @Autowired
    public TeacherSession(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Teacher getLoggedTeacher() {
        String loggedTeacherName = getAuthentication().getName();
        return teacherService.getTeacherByLogin(loggedTeacherName);
    }
}
