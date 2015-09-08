package com.xod.server.entity.jpa;

import javax.persistence.*;
import java.util.List;

/**
 * Created by protsenkov on 6/19/2015.
 */
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue
    Long Id;


    String name;

    @OneToOne(targetEntity = RoomEntity.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    RoomEntity room;


    public UserEntity(String name, RoomEntity roomId) {
        this.name = name;
        this.room = roomId;
    }

    public void setRoom(RoomEntity roomId) {
        this.room = roomId;
    }

    public UserEntity() {
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public RoomEntity getRoom() {
        return room;
    }




    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + Id +
                ", name='" + name + '\'' +
                ", room=" + room +
                '}';
    }
}
