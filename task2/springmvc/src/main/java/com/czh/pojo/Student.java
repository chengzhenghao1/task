package com.czh.pojo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Student {
    @NotEmpty(message = "id不能为空")
    private int id;
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "修真类型不能为空")
    private String type;
    @NotNull(message = "毕业院校不能为空")
    private String gradSchool;
    @NotNull(message = "线上学号不能为空")
    private long onlineId;
    @NotNull(message = "了解渠道不能为空")
    private String channel;
    @NotNull(message = "创建时间不能为空")
    private long createAt;
    @NotNull(message = "更新时间不能为空")
    private long updateAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getGradSchool() {
        return gradSchool;
    }

    public void setGradSchool(String gradSchool) {
        this.gradSchool = gradSchool;
    }

    public long getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(long onlineId) {
        this.onlineId = onlineId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", gradSchool='" + gradSchool + '\'' +
                ", onlineId=" + onlineId +
                ", channel='" + channel + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
