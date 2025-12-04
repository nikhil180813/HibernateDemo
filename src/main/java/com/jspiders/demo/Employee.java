package com.jspiders.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private long empNo;

    @Column(name = "ename", nullable = false)
    private String empName;

    @Column(name = "email",nullable = false,unique = true)
    private String empEmail;

    public long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(long empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
}
