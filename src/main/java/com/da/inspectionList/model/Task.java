package com.da.inspectionList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
  
  public enum ConstructionType {
    FOUNDATION,
    WELDING,
    MASONRY,
    REBAR
  }
  
  public enum Status {
    INSPECTED,
    PENDING,
    NOT_INSPECTED
  }
  
  public enum Result {
    PASS,
    PENDING,
    FAIL
  }
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="task_id")
  private Long id;
  
  private ConstructionType constructionType;
  private String location;
  private String inspActivity;
  private String inspector;
  private Status status = Status.NOT_INSPECTED;
  private Result result = Result.PENDING;
  
  public Task() {};
  
  public Task(ConstructionType constructionType, String location, String inspActivity, String inspector, Status status, Result result) {
    this.constructionType = constructionType;
    this.location = location;
    this.inspActivity = inspActivity;
    this.inspector = inspector;
    this.status = status;
    this.result = result;
  }

  public ConstructionType getConstructionType() {
    return constructionType;
  }

  public void setConstructionType(ConstructionType constructionType) {
    this.constructionType = constructionType;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getInspActivity() {
    return inspActivity;
  }

  public void setInspActivity(String inspActivity) {
    this.inspActivity = inspActivity;
  }

  public String getInspector() {
    return inspector;
  }

  public void setInspector(String inspector) {
    this.inspector = inspector;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Task [id=" + id + ", constructionType=" + constructionType + ", inspActivity=" + inspActivity + ", location=" + location + ", inspector=" + inspector + ", status=" + status + ", result=" + result + "]";
  }
  
}
