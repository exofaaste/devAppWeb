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
package org.appfuse.bravo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author fabian
 */
@XmlRootElement
@Entity
@Table(name="Food")
public class Food implements Serializable {
    private int foodId;
    private String foodName;
    private String foodDescription;
    private Menu menu;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Food_id", unique = true, nullable = false)
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Column(name = "Food_name")
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Column(name = "Food_description")
    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    /**
     *Sets the relation for the multiple menu food dates required
     * @return
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "food", cascade = CascadeType.ALL)
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.foodId;
        hash = 37 * hash + Objects.hashCode(this.foodName);
        hash = 37 * hash + Objects.hashCode(this.foodDescription);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Food other = (Food) obj;
        if (this.foodId != other.foodId) {
            return false;
        }
        if (!Objects.equals(this.foodName, other.foodName)) {
            return false;
        }
        if (!Objects.equals(this.foodDescription, other.foodDescription)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Food{" + "foodId=" + foodId + ", foodName=" + foodName + ", foodDescription=" + foodDescription + '}';
    }
    
    
}
