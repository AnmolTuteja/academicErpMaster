package org.iiitb.service.impl;

import org.iiitb.bean.Employee;
import org.iiitb.dao.EmployeeDao;
import org.iiitb.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    public Boolean validateEmployee( String userName, String password){
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.findByUserName(userName);
        if(employee == null){
            return false;
        } else {
            if(employee.getPassword().equals(password) == true){
                return  true;
            } else return false;
        }
    }
}
