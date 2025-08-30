package drobczyk.bartlomiej.model.dto;

import drobczyk.bartlomiej.validation.annotations.PasswordConditions;
import drobczyk.bartlomiej.validation.annotations.PasswordEqualityCheck;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@PasswordEqualityCheck(password = "password", confirmedPassword = "passwordConfirm")
public class TeacherDto {
    @Size(min = 4, max = 10, message = "Login musi mieć minimum 4 znaki i maximum 10")
    private String login;
    @Email(message = "Email musi być prawidłowo sformatowany i zawierać znak \"@\"")
    private String mail;
    @PasswordConditions
    private String password;
    private String passwordConfirm;

    public TeacherDto() {
    }

    public TeacherDto(String login, String mail, String password, String passwordConfirm) {
        this.login = login;
        this.mail = mail;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
