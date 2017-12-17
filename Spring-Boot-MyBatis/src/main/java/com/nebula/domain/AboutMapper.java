package com.nebula.domain;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * About 数据库映射器
 *
 * @author Nebula Unlimited
 */
@Mapper
public interface AboutMapper {

    /**
     *
     * @Select 是查询类的注解，所有的查询均使用这个
     * @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
     * @Insert 插入数据库使用，直接传入实体类会自动解析属性到对应的值
     * @Update 负责修改，也可以直接传入对象
     * @delete 负责删除
     *
     * 注意，使用#符号和$符号的不同：
     * // This example creates a prepared statement, something like select * from teacher where name = ?;
     * @Select("Select * from teacher where name = #{name}")
     * Teacher selectTeachForGivenName(@Param("name") String name);
     *
     * // This example creates n inlined statement, something like select * from teacher where name = 'someName';
     * @Select("Select * from teacher where name = '${name}'")
     * Teacher selectTeachForGivenName(@Param("name") String name);
     *
     */

    /**
     * 查找全部记录
     * @return
     */
    @Select("SELECT * FROM nebula_about")
    @Results({
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateUser", column = "update_user")
    })
    List<About> findAll();

    /**
     * 查找一条记录
     * @param id
     * @return
     */
    @Select("SELECT * FROM nebula_about WHERE id = #{id}")
    @Results({
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateUser", column = "update_user")
    })
    About findOne(@Param("id") Integer id);

    /**
     * 根据名称查找记录
     * @param name
     * @return
     */
    @Select("SELECT * FROM nebula_about WHERE name = #{name}")
    @Results({
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateUser", column = "update_user")
    })
    About findByName(@Param("name") String name);

    /**
     @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
     void insert(UserEntity user);

     @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
     void update(UserEntity user);

     @Delete("DELETE FROM users WHERE id =#{id}")
     void delete(Long id);
     */

    /**
     * 创建
     * @param name
     * @param content
     * @return
     */
    @Insert("INSERT INTO `nebula_about` (`name`, `content`) VALUES ('${name}', '${content}')")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long insert(@Param("name") String name, @Param("content") String content);

    /**
     * 更新
     * @param about
     * @return
     */
    @Update("UPDATE `nebula_about` SET `name` = '${name}', `content` = '${content}' WHERE `id` = #{id}")
    int update(About about);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("DELETE FROM `nebula_about` WHERE `id` = #{id}")
    int delete(Long id);
}
