package com.example.just_java.service;

import com.example.just_java.domain.DictionaryDomain;
import com.example.just_java.mapper.DictionaryMapper;
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
