package com.sample.entity;

public class HistoryDetailsDTO {
    private Long id;
    private String createddate;
    private String createdby;
    private String notes;
    private String followupdate;

    // Constructor
    public HistoryDetailsDTO(Long id, String createddate, String createdby, String notes, String followupdate) {
        this.id = id;
        this.createddate = createddate;
        this.createdby = createdby;
        this.notes = notes;
        this.followupdate = followupdate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFollowupdate() {
        return followupdate;
    }

    public void setFollowupdate(String followupdate) {
        this.followupdate = followupdate;
    }
}
