package com.just.service;

import com.just.domain.DictionaryDomain;
import com.just.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    public List<DictionaryDomain> getDictionary (String type ) {
        return dictionaryMapper.find(type);
    }
}
