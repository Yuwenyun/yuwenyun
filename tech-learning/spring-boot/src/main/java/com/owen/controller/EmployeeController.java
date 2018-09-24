package com.owen.controller;

import com.owen.mapper.EmployeeMapper;
import com.owen.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    public EmployeeMapper mapper;

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Employee getEmployeeByPrimaryKey(@RequestParam(defaultValue = "10001") int id)
    {
        return mapper.selectByPrimaryKey(id);
    }
}
