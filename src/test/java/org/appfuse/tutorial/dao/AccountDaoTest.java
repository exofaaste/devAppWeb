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
import org.bravo.dao.AccountDao;
import java.util.List;
import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.bravo.model.Account;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
/**
 *
 * @author fabian
 */
public class AccountDaoTest extends BaseDaoTestCase{
    @Autowired
    private AccountDao accountDao;
    
    @Test
    public void testFindAccountId() throws Exception {
        log.debug("finding By id...");
        Account account = accountDao.findByUserID("exofaaste");
        assertTrue(account!= null);
    }
}
