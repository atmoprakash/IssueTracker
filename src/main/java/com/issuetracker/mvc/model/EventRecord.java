package com.issuetracker.mvc.model;

/**
 * Created by acer on 2/2/2015.
 */
public class EventRecord {


    private int event_record_id;
    private int issue_event_id;
    private int issue_assigned_from;
    private int issue_transfer_to;
    private String event_created_date;
    private String event_solved_date;
    private  String remarks;

    public int getEvent_record_id() {
        return event_record_id;
    }

    public void setEvent_record_id(int event_record_id) {
        this.event_record_id = event_record_id;
    }

    public int getIssue_event_id() {
        return issue_event_id;
    }

    public void setIssue_event_id(int issue_event_id) {
        this.issue_event_id = issue_event_id;
    }

    public int getIssue_assigned_from() {
        return issue_assigned_from;
    }

    public void setIssue_assigned_from(int issue_assigned_from) {
        this.issue_assigned_from = issue_assigned_from;
    }

    public int getIssue_transfer_to() {
        return issue_transfer_to;
    }

    public void setIssue_transfer_to(int issue_transfer_to) {
        this.issue_transfer_to = issue_transfer_to;
    }

    public String getEvent_created_date() {
        return event_created_date;
    }

    public void setEvent_created_date(String event_created_date) {
        this.event_created_date = event_created_date;
    }

    public String getEvent_solved_date() {
        return event_solved_date;
    }

    public void setEvent_solved_date(String event_solved_date) {
        this.event_solved_date = event_solved_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
