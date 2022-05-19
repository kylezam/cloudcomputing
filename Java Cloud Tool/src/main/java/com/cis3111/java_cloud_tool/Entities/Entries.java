package com.cis3111.java_cloud_tool.Entities;

import javax.persistence.*;

@Entity
@Table(name = "logs")
public class Entries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="instance_name")
    private String instance;

    @Column(name="largest")
    private long largest;

    @Column(name="smallest")
    private long smallest;

    //Constructors
    public Entries(String instance, long largest, long smallest) {
        this.instance = instance;
        this.largest = largest;
        this.smallest = smallest;
    }

    public Entries() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public long getLargest() {
        return largest;
    }

    public void setLargest(long largest) {
        this.largest = largest;
    }

    public long getSmallest() {
        return smallest;
    }

    public void setSmallest(long smallest) {
        this.smallest = smallest;
    }

    @Override
    public String toString() {
        return "Entries{" +
                "id=" + id +
                ", instance='" + instance + '\'' +
                ", largest=" + largest +
                ", smallest=" + smallest +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
