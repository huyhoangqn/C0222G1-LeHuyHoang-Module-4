package com.codegym.furama.dto;

public class AttachServiceDTO {
    private Integer attachServiceId;
    private Double attachServiceCost;
    private String attachServiceName;
    private String attachServiceStatus;
    private Integer attachServiceUnit;

    public Integer getAttachServiceId() {
        return this.attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public Double getAttachServiceCost() {
        return this.attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceName() {
        return this.attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceStatus() {
        return this.attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public Integer getAttachServiceUnit() {
        return this.attachServiceUnit;
    }

    public void setAttachServiceUnit(Integer attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }
}
