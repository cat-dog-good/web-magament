package org.example.webmagament.service.impl;

import org.example.webmagament.POJO.Emp;
import org.example.webmagament.mapper.EmpMapper;
import org.example.webmagament.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> list() {
        return empMapper.list();
    }

    @Override
    public void delete(Integer id) {
        empMapper.deleteById(id);
    }
}
