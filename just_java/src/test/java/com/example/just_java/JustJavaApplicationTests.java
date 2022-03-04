package com.example.just_java;

import com.example.just_java.domain.TableDomain;
import com.example.just_java.mapper.TableMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JustJavaApplicationTests {

    @Autowired
    private TableMapper tableMapper;

    @Test
    public void testUser () {
        List<TableDomain> tableDomainList = tableMapper.findAll();

        System.out.print(tableDomainList.toString());
    }

}
