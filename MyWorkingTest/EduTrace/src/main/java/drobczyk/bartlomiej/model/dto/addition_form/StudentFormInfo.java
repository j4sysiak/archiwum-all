package drobczyk.bartlomiej.model.dto.addition_form;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Component
public class StudentFormInfo {
    private String avatar;
    private String name;
    private String surname;
    @Size(min = 9, max = 9, message = "Telefon musi mieć 9 znaków")
    private String phone;
    @Email(message = "Email musi być poprawnie sformatowany ze znakiem \"@\"")
    private String mail;
    private String parent;
    @Size(min = 9, max = 9, message = "Telefon musi mieć 9 znaków")
    private String parentPhone;
    private String extraInfo;
    private Integer grade;
    @NotEmpty(message = "Uczeń musi mieć przypisany chociaż jeden przedmiot")
    private List<String> subjects;
    @NotEmpty(message = "Zajęcia muszą być zdefiniowane w chociaż jednym dniu")
    private List<String> day;


    public StudentFormInfo() {
    }

    public StudentFormInfo(String avatar, String name, String surname, String phone, String mail, String parent,
                           String parentPhone, String extraInfo, Integer grade, List<String> subjects, List<String> day) {
        this.avatar = avatar;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.parent = parent;
        this.parentPhone = parentPhone;
        this.extraInfo = extraInfo;
        this.grade = grade;
        this.subjects = subjects;
        this.day = day;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public List<String> getSubject() {
        return subjects;
    }

    public void setSubject(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getDay() {
        return day;
    }

    public void setDay(List<String> day) {
        this.day = day;
    }


    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}