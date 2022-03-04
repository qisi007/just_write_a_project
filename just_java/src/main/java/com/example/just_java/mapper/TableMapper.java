package com.example.just_java.mapper;

import com.example.just_java.domain.TableDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TableMapper {
    @Select("select * from tableTest")
    public List<TableDomain> findAll();
}
