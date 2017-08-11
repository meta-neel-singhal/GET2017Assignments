package com.metacube.model;


import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Neel Singhal
 */
public class UserVo {

    private String name;
    private String Id;
    private Map<String,Integer> order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Map<String,Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<String,Integer> order) {
        this.order = order;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserVo other = (UserVo) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

}
