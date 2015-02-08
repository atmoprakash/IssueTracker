package com.issuetracker.mvc.model;

/**
 * Created by acer on 1/29/2015.
 */
public class AssignEvent {


    private int issue_event_id;
    private int user_id;
    private int issue_tracker_id;
    private String assigned_date;
     private Integer solve;



    public int getIssue_event_id() {
        return issue_event_id;
    }

    public void setIssue_event_id(int issue_event_id) {
        this.issue_event_id = issue_event_id;
    }

    public int getIssue_tracker_id() {
        return issue_tracker_id;
    }

    public void setIssue_tracker_id(int issue_tracker_id) {
        this.issue_tracker_id = issue_tracker_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAssigned_date() {
        return assigned_date;
    }

    public void setAssigned_date(String assigned_date) {
        this.assigned_date = assigned_date;
    }
    public Integer getSolve() {
        return solve;
    }

    public void setSolve(Integer solve) {
        this.solve = solve;
    }




}
