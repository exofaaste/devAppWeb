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
import org.bravo.dao.FoodDao;
import org.appfuse.bravo.model.Food;
import org.appfuse.bravo.service.FoodManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabian
 */
@Transactional
@Service("foodManager")
@WebService(serviceName = "FoodService", endpointInterface = "org.appfuse.bravo.service.FoodManager")
public class FoodManagerImpl extends GenericManagerImpl<Food, Long> implements FoodManager{
    FoodDao foodDao;

    public FoodManagerImpl() {
    }

    @Autowired
    public FoodManagerImpl(FoodDao foodDao) {
        super(foodDao);
        this.foodDao = foodDao;
    }

    @Override
    public List<Food> getFood() {
        return foodDao.getAll();
    }

    @Override
    public Food getFood(int foodId) {
        return foodDao.get(foodId);
    } 

    @Override
    public String createFood(String foodDescription, String foodName) {
        Food food = new Food();
        food.setFoodDescription(foodDescription);
        food.setFoodName(foodName);
        try{
            foodDao.save(food);
            return "{Food was saved Succesfuly}";
        }catch(Exception e){
        return "Error saving the food";
        }
    }
    
}
