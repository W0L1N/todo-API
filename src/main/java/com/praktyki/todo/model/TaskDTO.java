package com.praktyki.todo.model;

import org.jetbrains.annotations.NotNull;

public class TaskDTO {
    private String name;
    private String desc;
    private boolean status;
    private Long projectId;

    public TaskDTO(String name, String desc, Long projectId) {
        this.name = name;
        this.desc = desc;
        this.projectId = projectId;
    }
    public TaskDTO(Task task) {
        this.name=task.getName();
        this.desc=task.getDesc();
        this.status=task.isStatus();
        this.projectId=task.getProject().getId();

    }

    public TaskDTO() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isStatus() {
        return status;
    }

    public Long getProjectId() {
        return projectId;
    }


}
