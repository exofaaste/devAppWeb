/*
 * Copyright 2015 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.appfuse.bravo.service.impl;

import java.util.List;
import javax.jws.WebService;
import org.appfuse.service.impl.GenericManagerImpl;
import org.bravo.dao.EmployeeDao;
import org.appfuse.bravo.model.Employee;
import org.appfuse.bravo.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabian
 */
@Transactional
@Service("employeeManager")
@WebService(serviceName = "EmployeesService", endpointInterface = "org.appfuse.bravo.service.EmployeeManager")
public class EmployeeManagerImpl extends GenericManagerImpl<Employee, Long> implements EmployeeManager{
     EmployeeDao employeeDao;
    public EmployeeManagerImpl() {
    }

    @Autowired
	public EmployeeManagerImpl(EmployeeDao employeeDao) {
		super(employeeDao);
		this.employeeDao = employeeDao;
	}
    
    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getAll();
    }
    
    //@Override
    //public List<Employee> deleteEmployee(Long employeeID) {
       // employeeDao.remove(employeeID);
       // return employeeDao.getAll();
    //}
    
}
