package drobczyk.bartlomiej.model.dto.edit_form;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class BasicInfoEdit {
    private String name;
    private String surname;
    @Size(min = 9, max = 9, message = "Telefon musi mieć 9 znaków")
    private String phone;
    @Email(message = "Email musi być poprawnie sformatowany ze znakiem \"@\"")
    private String mail;
    private String parent;
    @Size(min = 9, max = 9, message = "Telefon musi mieć 9 znaków")
    private String parentPhone;

    public String getName() {
        return name;
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
}