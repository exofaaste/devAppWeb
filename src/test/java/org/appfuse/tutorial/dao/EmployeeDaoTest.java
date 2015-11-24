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
package org.appfuse.tutorial.dao;

import org.bravo.dao.EmployeeDao;
import java.util.List;
import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.bravo.model.Employee;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
/**
 *
 * @author fabian
 */
public class EmployeeDaoTest extends BaseDaoTestCase{
    @Autowired
    private EmployeeDao employeeDao;
    
    /**
     *Test to find by email
     * @throws Exception
     */
    @Test
    public void testFindByFirstName() throws Exception {
        log.debug("finding By username...");
        List<Employee> employees = employeeDao.findByEmployeeName("Fabian");
        assertTrue(employees.size() > 0);
    }
    
    /**
     *Test to find by last name
     * @throws Exception
     */
    @Test
    public void testFindByLastName() throws Exception{
    log.debug("finding employee by last name");
    List<Employee> employees = employeeDao.findByEmployeeLastName("Arias");
        assertTrue(employees.size() > 0);
    }
    @Test
    public void testFindByEmail() throws Exception{
    log.debug("finding employee by email");
    List<Employee> employees = employeeDao.findByEmployeeEmail("exofaaste@hotmail.com");
        assertTrue(employees.size() > 0);
    }
}
