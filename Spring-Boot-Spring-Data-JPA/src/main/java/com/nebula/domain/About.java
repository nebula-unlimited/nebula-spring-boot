package com.nebula.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * About 实体类
 *
 * @author Nebula Unlimited
 */

@Entity
@Table(name = "nebula_about")
public class About {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column
    private Integer rank;

    @Column
    private Integer status;

    @Column(nullable = false, length = 8)
    private String name;

    @Column
    private String content;

    public About() {
    }

    public About(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "About{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                ", rank=" + rank +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
