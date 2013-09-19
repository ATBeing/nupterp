package nupterp.model;

import java.sql.Clob;

public class Tregister  implements java.io.Serializable {

	private static final long serialVersionUID = -2239984902722516087L;

     private String id;
     private String name;
     private String sex;
     private String sid;
     private String major;
     private String phone;
     private String qq;
     private String departments;
     private Clob speciality;


    // Constructors

    /** default constructor */
    public Tregister() {
    }

	/** minimal constructor */
    public Tregister(String id, String name, String sid, String phone) {
        this.id = id;
        this.name = name;
        this.sid = sid;
        this.phone = phone;
    }
    
    /** full constructor */
    public Tregister(String id, String name, String sex, String sid, String major, String phone, String qq, String departments, Clob speciality) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.sid = sid;
        this.major = major;
        this.phone = phone;
        this.qq = qq;
        this.departments = departments;
        this.speciality = speciality;
    }

   

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getSid() {
        return this.sid;
    }
    
    public void setSid(String sid) {
        this.sid = sid;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }
    
    public String getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(String departments) {
        this.departments = departments;
    }
    
    public Clob getSpeciality() {
        return this.speciality;
    }
    
    public void setSpeciality(Clob speciality) {
        this.speciality = speciality;
    }

}