package com.xod.server.entity.jpa;

import javax.persistence.*;

/**
 * Created by protsenkov on 6/19/2015.
 */
@Entity
@Table(name ="ROOM")
public class RoomEntity {

    @Id
    @GeneratedValue
    Long id;


    String name;

    @OneToOne
    UserEntity user;

    public RoomEntity() {
    }

    public RoomEntity(String name, UserEntity user) {
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Column(name = "USER")
    public UserEntity getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "RoomEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
