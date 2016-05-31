package com.lawlietblack.theforce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Device(DeviceBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.room = builder.room;
        this.status = builder.status;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", room='" + room + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public static class DeviceBuilder {
        private String name;
        private String type;
        private String room;
        private String status;

        public DeviceBuilder(String name) {
            this.name = name;
        }

        public DeviceBuilder deviceType(String type) {
            this.type = type;
            return this;
        }

        public DeviceBuilder inRoom(String room) {
            this.room = room;
            return this;
        }

        public DeviceBuilder status(String status) {
            this.status = status;
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }
}
