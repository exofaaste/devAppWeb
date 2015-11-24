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
package org.appfuse.bravo.service;

import java.io.Serializable;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.QueryParam;
import org.appfuse.service.GenericManager;
import org.appfuse.bravo.model.Account;
/**
 *
 * @author fabian
 */
@WebService
@Path("/accounts")
public interface AccountManager extends GenericManager<Account, Long>{

    public Account get(String userId);
    
    
    /**
     *Gets all the accounts
     * @return
     */
    @GET
     @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    List<Account> getAccounts();
    
    /**
     *Gets if the user can login or not
     * @param userId
     * @param password
     * @return
     */
    @GET
    @Path("/isValidAccount")
     @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    boolean isValidaAccount(@QueryParam("userId") String userId,@QueryParam("password") String password);
    
}
