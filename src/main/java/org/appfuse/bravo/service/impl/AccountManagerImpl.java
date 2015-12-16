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

import java.io.Serializable;
import java.util.List;
import javax.jws.WebService;
import org.appfuse.service.impl.GenericManagerImpl;
import org.bravo.dao.AccountDao;
import org.appfuse.bravo.model.Account;
import org.appfuse.bravo.service.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author fabian
 */
@Transactional
@Service("accountManager")
@WebService(serviceName = "AccountService", endpointInterface = "org.appfuse.bravo.service.AccountManager")
public class AccountManagerImpl extends GenericManagerImpl<Account, Long> implements AccountManager{
    AccountDao accountDao;

    public AccountManagerImpl() {
    }
    @Autowired
	public AccountManagerImpl(AccountDao accountDao) {
		super(accountDao);
		this.accountDao = accountDao;
	}

    @Override
    public List<Account> getAccounts() {
       return accountDao.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidaAccount(String userId, String password) {
        boolean flag =false;
        Account account = accountDao.findByUserID(userId);
        if(account==null || account.getStatus().equals("Inactive")){
            //Unable to do something
        }else{
           if(account.getPassword().equals(password)){
               flag = true;
           }else{
               int count = account.getAttempts();
               if(count+1==3){
               account.setStatus("Inactive");
               account.setAttempts(count+1);
               }else{
               account.setAttempts(count+1);
               }
               accountDao.save(account);    
           }
        }
        return flag;
    }

    /**
     *Gets by user id
     * @param userId
     * @return
     */
    @Override
    public Account get(String userId) {
       return accountDao.findByUserID(userId);
    }
        
        
}
