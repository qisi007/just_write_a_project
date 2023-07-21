package com.just.service;

import com.just.domain.QueryDTO;
import com.just.domain.TableDomain;
import com.just.mapper.TableMapper;
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

    public void addData ( TableDomain tableDomain ) { tableMapper.addData(tableDomain);}

    public void deleteData ( String id ) { tableMapper.deleteData(id); }

    public void editData ( TableDomain tableDomain ) { tableMapper.updateData(tableDomain); }
}
