package com.example.just_java.service;

import com.example.just_java.common.response.ResponseDTO;
import com.example.just_java.domain.QueryDTO;
import com.example.just_java.domain.TableDomain;
import com.example.just_java.mapper.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    public TableMapper tableMapper;

    public List<TableDomain> getTableDate (QueryDTO queryDTO ) {
        return tableMapper.findAll(queryDTO);
    }
}
