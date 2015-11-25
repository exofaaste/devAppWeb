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


import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.appfuse.service.GenericManager;
import org.appfuse.bravo.model.Food;

/**
 *
 * @author fabian
 */
@WebService
@Path("/food")
public interface FoodManager extends GenericManager<Food, Long>{
    
    @GET
     @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    List<Food> getFood();
    
    /**
     *
     * @param foodId
     * @return
     */
    @GET
    @Path("/foodSearch")
     @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Food getFood(@QueryParam("foodId") int foodId);
    
}
