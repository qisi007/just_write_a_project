package com.just.mapper;

import com.just.domain.DictionaryDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DictionaryMapper {
    public List<DictionaryDomain> find(@Param("name") String name);
}
