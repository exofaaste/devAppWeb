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

import java.util.*;
import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.appfuse.service.GenericManager;
import org.appfuse.bravo.model.Employee;

/**
 *
 * @author fabian
 */
@WebService
@Path("/employees")
public interface EmployeeManager extends GenericManager<Employee, Long>{

    /**
     *Return request for employees
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    List<Employee> getEmployees();
    
    //@DELETE
   // @Path("{employeeID}")
    //@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    //List<Employee> deleteEmployee(@PathParam("employeeID") Long employeeID); 
}
