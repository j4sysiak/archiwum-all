package drobczyk.bartlomiej.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    @Size(min = 6, max = 6)
    private String phone;
    @Email
    private String email;
    private int grade;
    private String parent;
    @Size(min = 6, max = 6)
    private String parentNumber;
    private String additionalInfo;
    private String avatarUrl;
    private int totalLessonAmount;
    private Long lastArchivedPosition;
    private List<String> subjects;
    private List<String> days;

    public StudentDto() {
    }

    public StudentDto(Long id, String name, String surname, String phone, String email, Integer grade, String parent,
                      String parentNumber, String additionalInfo, String avatarUrl,
                      int totalLessonAmount, Long lastArchivedPosition, List<String> subjects, List<String> days) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.grade = grade;
        this.parent = parent;
        this.parentNumber = parentNumber;
        this.additionalInfo = additionalInfo;
        this.avatarUrl = avatarUrl;
        this.totalLessonAmount = totalLessonAmount;
        this.lastArchivedPosition = lastArchivedPosition;
        this.subjects = subjects;
        this.days = days;
    }

    public int getTotalLessonAmount() {
        return totalLessonAmount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getGrade() {
        return grade;
    }

    public String getParent() {
        return parent;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Long getLastArchivedPosition() {
        return lastArchivedPosition;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public List<String> getDays() {
        return days;
    }

}