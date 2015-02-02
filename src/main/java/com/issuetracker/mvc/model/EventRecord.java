package com.issuetracker.mvc.model;

import java.util.Date;

/**
 * Created by sakshi on 2/1/2015.
 */
public class EventRecord {
    private int event_record_id;
    private int issue_event_id;
    private String issue_assigned_to;
    private String issue_transfer_to;
    private String event_created_date;
    private String event_solve_date;
    private String remarks;
    private String issuename;
    private int issue_tracker_id;

    public int getIssue_tracker_id() {
        return issue_tracker_id;
    }

    public void setIssue_tracker_id(int issue_tracker_id) {
        this.issue_tracker_id = issue_tracker_id;
    }

    private String servicename;

    public String getIssuename() {
        return issuename;
    }

    public void setIssuename(String issuename) {
        this.issuename = issuename;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }


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

    public String getIssue_assigned_to() {
        return issue_assigned_to;
    }

    public void setIssue_assigned_to(String issue_assigned_to) {
        this.issue_assigned_to = issue_assigned_to;
    }

    public String getIssue_transfer_to() {
        return issue_transfer_to;
    }

    public void setIssue_transfer_to(String issue_transfer_to) {
        this.issue_transfer_to = issue_transfer_to;
    }

    public String getEvent_created_date() {
        return event_created_date;
    }

    public void setEvent_created_date(String event_created_date) {
        this.event_created_date = event_created_date;
    }

    public String getEvent_solve_date() {
        return event_solve_date;
    }

    public void setEvent_solve_date(String event_solve_date) {
        this.event_solve_date = event_solve_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
