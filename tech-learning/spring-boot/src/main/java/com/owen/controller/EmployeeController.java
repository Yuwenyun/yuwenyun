package com.owen.controller;

import com.owen.mapper.EmployeeMapper;
import com.owen.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    public EmployeeMapper mapper;

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Employee getEmployeeByPrimaryKey(@RequestParam(defaultValue = "10001") int id) throws InterruptedException
    {
        Thread.sleep(3000);
        return mapper.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/page/{currPage}/{pageSize}")
    public List<Employee> getEmployeeByPage(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("currPage", currPage);
        map.put("pageSize", pageSize);
        return this.mapper.queryEmployeeByPage(map);
    }
}
