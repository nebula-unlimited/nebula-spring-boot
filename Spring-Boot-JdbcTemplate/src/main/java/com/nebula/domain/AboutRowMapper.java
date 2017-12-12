package com.nebula.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AboutRowMapper implements RowMapper<About> {
    @Override
    public About mapRow(ResultSet resultSet, int i) throws SQLException {
        About about = new About();
        about.setId(resultSet.getLong("id"));
        about.setCreateTime(resultSet.getTimestamp("create_time"));
        about.setUpdateTime(resultSet.getTimestamp("update_time"));
        about.setCreateUser(resultSet.getInt("create_user"));
        about.setUpdateUser(resultSet.getInt("update_user"));
        about.setRank(resultSet.getInt("rank"));
        about.setStatus(resultSet.getInt("status"));
        about.setName(resultSet.getString("name"));
        about.setContent(resultSet.getString("content"));
        return about;
    }
}
