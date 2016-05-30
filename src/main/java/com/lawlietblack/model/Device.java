package com.lawlietblack.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Device {
    private Integer id;
    private String name;
    private String type;
    private String room;
    private String status;

    public Device() {}

    public Device(Integer id, String name, String type, String room, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.room = room;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
