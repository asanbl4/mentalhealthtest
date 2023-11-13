package com.asanbl4.mentalhealthtest.models;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Student(String name, int q1, int q2, int q3, int q4, int q5, int q6, int q7, int q8, int q9, int q10, int ifOnline, String identify, String religion, String preference, Boolean pref_lgbt, Boolean pref_religion) {
        this.name = name;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9;
        this.q10 = q10;
        this.ifOnline = ifOnline;
        this.identify = identify;
        this.religion = religion;
        this.preference = preference;
        this.pref_lgbt = pref_lgbt;
        this.pref_religion = pref_religion;
    }

    public Student() {
    }


    @Column(name = "pref_lgbt")
    private Boolean pref_lgbt;

    public Boolean isPref_lgbt() {
        return pref_lgbt;
    }

    public void setPref_lgbt(Boolean pref_lgbt) {
        this.pref_lgbt = pref_lgbt;
    }

    public Boolean isPref_religion() {
        return pref_religion;
    }

    public void setPref_religion(Boolean pref_religion) {
        this.pref_religion = pref_religion;
    }

    @Column(name = "pref_religion")
    private Boolean pref_religion;

    @Column(name = "q1")
    private int q1;
    @Column(name = "q2")
    private int q2;
    @Column(name = "q3")
    private int q3;
    @Column(name = "q4")
    private int q4;
    @Column(name = "q5")
    private int q5;
    @Column(name = "q6")
    private int q6;
    @Column(name = "q7")
    private int q7;
    @Column(name = "q8")
    private int q8;
    @Column(name = "q9")
    private int q9;
    @Column(name = "q10")
    private int q10;

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    @Column(name = "IfOnline")
    private int ifOnline;
    @Column(name = "Identification")
    private String identify;
    @Column(name = "Religion")
    private String religion;

    @Column(name = "Preferences")
    private String preference;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public int getIfOnline() {
        return ifOnline;
    }

    public void setIfOnline(int ifOnline) {
        this.ifOnline = ifOnline;
    }



    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public int getQ3() {
        return q3;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public int getQ4() {
        return q4;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    public int getQ5() {
        return q5;
    }

    public void setQ5(int q5) {
        this.q5 = q5;
    }

    public int getQ6() {
        return q6;
    }

    public void setQ6(int q6) {
        this.q6 = q6;
    }

    public int getQ7() {
        return q7;
    }

    public void setQ7(int q7) {
        this.q7 = q7;
    }

    public int getQ8() {
        return q8;
    }

    public void setQ8(int q8) {
        this.q8 = q8;
    }

    public int getQ9() {
        return q9;
    }

    public void setQ9(int q9) {
        this.q9 = q9;
    }

    public int getQ10() {
        return q10;
    }

    public void setQ10(int q10) {
        this.q10 = q10;
    }
}
