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
package org.appfuse.tutorial.service.impl;


import org.appfuse.bravo.service.impl.AccountManagerImpl;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.bravo.dao.AccountDao;
import org.appfuse.bravo.model.Account;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
/**
 *
 * @author fabian
 */
public class AccountManagerImplTest extends BaseManagerMockTestCase{
    
    @InjectMocks
    private AccountManagerImpl manager;
    @Mock
    private AccountDao dao;
    
    /**
     *
     */
    @Test
    public void testAttemptLogin() {
//        log.debug("testing testAttemptLogin...");
//        final String user = "exofaaste";
//        final int count = 0;
//        final Account account = new Account();
//        account.setUserId("exofaaste");
//        account.setAttempts(count);
//        given(dao.findByUserID(user)).willReturn(account);
//        log.debug(account.toString());
//        log.debug("------------------Getting Result ");
//        boolean result = manager.isValidaAccount("exofaaste", "faaste");
//        log.debug("------------------Result : " + result);
//        assertTrue(result==true);
    }
    
    /**
     *
     */
    @Test
    public void testGetUser() {
        log.debug("testing get...");
        //given
        final String user = "exofaaste";
        final Account account = new Account();
        given(dao.findByUserID(user)).willReturn(account);
        log.debug(account.toString());
        //when
        Account result = manager.get(user);

        //then
        assertSame(account, result);
    }
}
