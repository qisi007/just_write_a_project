package com.just.mapper;

import com.just.domain.QueryDTO;
import com.just.domain.TableDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TableMapper {
    public List<TableDomain> findAll(@Param("queryDTO") QueryDTO queryDTO);
    public void addData(@Param("tableDomain") TableDomain tableDomain);
    public void deleteData(@Param("id") String id);
    public void updateData(@Param("tableDomain") TableDomain tableDomain);
}
