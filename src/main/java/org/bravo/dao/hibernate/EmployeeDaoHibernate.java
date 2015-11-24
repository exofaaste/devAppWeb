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
package org.bravo.dao.hibernate;
import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.bravo.dao.EmployeeDao;
import org.appfuse.bravo.model.Employee;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fabian
 */
@Repository("employeeDao")
public class EmployeeDaoHibernate extends GenericDaoHibernate<Employee, Long> implements EmployeeDao{

    public EmployeeDaoHibernate() {
        super(Employee.class);
    }

    @Override
    public List<Employee> findByEmployeeName(String name) {
        return getSession().createCriteria(Employee.class).add(Restrictions.eq("firstName", name)).list();
    }

    @Override
    public List<Employee> findByEmployeeLastName(String lastName) {
        return getSession().createCriteria(Employee.class).add(Restrictions.eq("lastName", lastName)).list();
    }

    @Override
    public List<Employee> findByEmployeeEmail(String email) {
        return getSession().createCriteria(Employee.class).add(Restrictions.eq("email", email)).list();
    }
    
}
