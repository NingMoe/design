package cn.edu.aufe.guixiaorun.entity;

import org.apache.ibatis.type.Alias;

import java.sql.Date;

/**
 * Created by guixiaorun on 15-4-5.
 */
@Alias("PaperItemEntity")
public class PaperItemEntity {
    private Integer id ;
    private String notes ;
    private String academy;
    private String profession ;
    private String teacherName ;
    private String studentName ;
    private String title ;
    private Date createTime ;
    private Integer teacherAccount ;
    private Integer studentAccount ;
    private String isSelected ;
    private String teacherPhone ;

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }

    public Integer getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(Integer teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public Integer getStudentAccount() {

        return studentAccount;
    }

    public void setStudentAccount(Integer studentAccount) {
        this.studentAccount = studentAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
