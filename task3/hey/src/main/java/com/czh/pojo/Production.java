package com.czh.pojo;

public class Production {
    private Long id;

    private String name;

    private Integer status;

    private Long stairId;

    private Long secondId;

    private String production;

    private String thumbnail;

    private String videoLink;

    private String photo;

    private String introduction;

    private Long createAt;

    private Long updateAt;

    private String editor;

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", stairId=" + stairId +
                ", secondId=" + secondId +
                ", production='" + production + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", photo='" + photo + '\'' +
                ", introduction='" + introduction + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }

    public Production(Long id, String name, Integer status, Long stairId, Long secondId, String production, String thumbnail, String videoLink, String photo, String introduction, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.stairId = stairId;
        this.secondId = secondId;
        this.production = production;
        this.thumbnail = thumbnail;
        this.videoLink = videoLink;
        this.photo = photo;
        this.introduction = introduction;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public Production() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getStairId() {
        return stairId;
    }

    public void setStairId(Long stairId) {
        this.stairId = stairId;
    }

    public Long getSecondId() {
        return secondId;
    }

    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production == null ? null : production.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink == null ? null : videoLink.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
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