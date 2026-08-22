package com.example.its.domain.issue;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface IssueRepository {

    @Select("select * from issues")
    List<IssueEntity> findAll();

    @Insert("insert into issues (summary, description) values (#{summary}, #{description})")
    void insert(String summary, String description);

    @Select("select * from issues where id = #{issueId}")
    IssueEntity findById(long issueId);

    @Delete("Delete From issues where id = #{issueId}")
    void deleteById(long issueId);

    @Update("UPDATE issues SET summary=#{summary},description=#{description} WHERE id = #{issueId}")
    void editById(long issueId, String summary, String description);

}
