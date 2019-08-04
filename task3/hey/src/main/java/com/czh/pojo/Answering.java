package com.czh.pojo;

public class Answering {
    private Long id;

    private String nickname;

    private Long messageId;

    private String response;

    private Long createAt;

    private Long updateAt;

    private String editor;

    @Override
    public String toString() {
        return "Answering{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", commentId=" +messageId +
                ", response='" + response + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }

    public Answering(Long id, String nickname, Long messageId, String response, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.nickname = nickname;
        this.messageId = messageId;
        this.response = response;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public Answering() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
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