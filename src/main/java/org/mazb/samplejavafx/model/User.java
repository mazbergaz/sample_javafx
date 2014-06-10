package org.mazb.samplejavafx.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author mazbergaz@gmail.com
 */
public class User {
    
    private int id;
    private String userName;
    private String realName;
    private String password;
    private String email;
    private Role roleDto;
    private String createdBy;
    private long createdOn;
    private String modifiedBy;
    private long lastModified;
    
    public User(){
        
    }
    
    /**
     * use this to set default value except for username and password, no role.
     * @param userName
     * @param password 
     */
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.realName = userName;
        this.email = userName + "@email.com";
        this.createdBy = "SYSTEM";
        this.createdOn = new Date().getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(Role roleDto) {
        this.roleDto = roleDto;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", realName=" + realName + ", password=" + password + ", email=" + email + ", roleDto=" + roleDto + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", lastModified=" + lastModified + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.userName);
        hash = 71 * hash + Objects.hashCode(this.realName);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.roleDto);
        hash = 71 * hash + Objects.hashCode(this.createdBy);
        hash = 71 * hash + (int) (this.createdOn ^ (this.createdOn >>> 32));
        hash = 71 * hash + Objects.hashCode(this.modifiedBy);
        hash = 71 * hash + (int) (this.lastModified ^ (this.lastModified >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.realName, other.realName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.roleDto, other.roleDto)) {
            return false;
        }
        if (!Objects.equals(this.createdBy, other.createdBy)) {
            return false;
        }
        if (this.createdOn != other.createdOn) {
            return false;
        }
        if (!Objects.equals(this.modifiedBy, other.modifiedBy)) {
            return false;
        }
        if (this.lastModified != other.lastModified) {
            return false;
        }
        return true;
    }
    
}
