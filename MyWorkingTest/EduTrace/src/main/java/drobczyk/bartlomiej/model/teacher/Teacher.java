package drobczyk.bartlomiej.model.teacher;

import drobczyk.bartlomiej.model.roles.UserRole;
import drobczyk.bartlomiej.model.student.Student;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;
    @Column(unique = true)
    @NotEmpty
    private String login;
    @Column(unique = true)
    @Email
    private String email;
    @NotEmpty
    private String password;
    private LocalDateTime regisrationDate;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @Fetch(value = FetchMode.JOIN)
    private Set<Student> students = new HashSet<>();
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    public Teacher() {
    }

    ;

    public Teacher(String login, String email, String password,
                   LocalDateTime regisrationDate, Set<Student> students) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.regisrationDate = regisrationDate;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisrationDate() {
        return regisrationDate;
    }

    public void setRegisrationDate(LocalDateTime regisrationDate) {
        this.regisrationDate = regisrationDate;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(login, teacher.login) && Objects.equals(email, teacher.email) && Objects.equals(password, teacher.password) && Objects.equals(regisrationDate, teacher.regisrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email, password, regisrationDate);
    }
}