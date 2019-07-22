package com.truonghd.productdiscovery.model;

import java.io.Serializable;

/**
 * Created by Truong.Han on 2019-07-22.
 * VIETIS Corporation
 * truong.han@vietis.com.vn
 */
public class AttributeModel implements Serializable {
    private String id;
    private String name;
    private String value;
    private String parentId;
    private String priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
