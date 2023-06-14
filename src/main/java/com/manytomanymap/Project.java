package com.manytomanymap;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    @Column(name = "project_name")
    private String name;
    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;

    public Project() {
    }

    public Project(int pid, String name, List<Emp> emps) {
        this.pid = pid;
        this.name = name;
        this.emps = emps;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
