package com.czh.pojo;

public class Message {
    private Long id;

    private Long productionId;

    private String nickname;

    private Integer status;

    private Long createAt;

    private Long updateAt;

    private String editor;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", productionId=" + productionId +
                ", nickname='" + nickname + '\'' +
                ", status=" + status +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }

    public Message(Long id, Long productionId, String nickname, Integer status, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.productionId = productionId;
        this.nickname = nickname;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public Message() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductionId() {
        return productionId;
    }

    public void setProductionId(Long productionId) {
        this.productionId = productionId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }
}