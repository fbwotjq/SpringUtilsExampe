package com.example.demo.mapper;

import com.example.demo.pojo.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EventMapper {

    @Select("SELECT ID AS id, first_name as name FROM foot WHERE id = #{id}")
    public Event findById(int id);
}
