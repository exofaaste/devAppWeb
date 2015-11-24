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
import java.io.Serializable;
import java.util.List;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.bravo.dao.AccountDao;
import org.appfuse.bravo.model.Account;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fabian
 */
@Repository("accountDao")
public class AccountDaoHibernate extends GenericDaoHibernate<Account, Long> implements AccountDao{

    public AccountDaoHibernate() {
    super(Account.class);
    }

    @Override
    public Account findByUserID(String userId) {
    return (Account)getSession().createCriteria(Account.class).add(Restrictions.eq("userId", userId)).uniqueResult();  
    }

    @Override
    public List<Account> findByEmployeeId(String employeeId) {
    return getSession().createCriteria(Account.class).add(Restrictions.eq("employeeID", employeeId)).list(); 
    }
    
}
