package com.czh.pojo;

public class Banner {
    private Long id;

    private String cover;

    private String editor;

    private String url;

    private Integer state;

    private Long createAt;

    private Long updateAt;

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", editor='" + editor + '\'' +
                ", url='" + url + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public Banner(Long id, String cover, String editor, String url, Integer state, Long createAt, Long updateAt) {
        this.id = id;
        this.cover = cover;
        this.editor = editor;
        this.url = url;
        this.state = state;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Banner() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}