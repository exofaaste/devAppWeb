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
import org.bravo.dao.FoodDao;
import org.appfuse.bravo.model.Food;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fabian
 */
@Repository("foodDao")
public class FoodDaoHibernate extends GenericDaoHibernate<Food, Long> implements FoodDao{

    public FoodDaoHibernate() {
        super(Food.class);
    }

    
    @Override
    public List<Food> findByFoodName(String foodName) {
    return getSession().createCriteria(Food.class).add(Restrictions.eq("foodName", foodName)).list();
    }

    @Override
    public Food get(int food_id) {
        return (Food)getSession().createCriteria(Food.class).add(Restrictions.eq("foodId", food_id)).uniqueResult();
    }
    
}
