package com.mber.study.javaee.husivm._06_jpa._085_temporal;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity(name = "085_student")
@NoArgsConstructor
class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_d")
    private Date dateD;
    @Temporal(TemporalType.TIME)
    @Column(name = "time_d")
    private Date timeD;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_stamp_d")
    private Date timeStampD;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_c")
    private Calendar dateC;
    @Temporal(TemporalType.TIME)
    @Column(name = "time_c")
    private Calendar timeC;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_stamp_c")
    private Calendar timeStampC;

    public Student(String name, Date date, Calendar calendar) {
        this.name = name;
        this.dateD = date;
        this.timeD = date;
        this.timeStampD = date;
        this.dateC = calendar;
        this.timeC = calendar;
        this.timeStampC = calendar;
    }
}
