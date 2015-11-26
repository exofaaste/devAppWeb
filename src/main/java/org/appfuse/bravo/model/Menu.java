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
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author fabian
 */
@XmlRootElement
@Entity
@Table(name="Menu")
public class Menu implements Serializable {
    private Date foodDate;
    private int dateNumber;
    private Food food;
   
   
    @Id
    @Column(name="Food_date")
    public Date getFoodDate() {
        return foodDate;
    }

    public void setFoodDate(Date foodDate) {
        this.foodDate = foodDate;
    }

    @Id
   @Column(name="Date_Number")
    public int getDateNumber() {
        return dateNumber;
    }

    public void setDateNumber(int dateNumber) {
        this.dateNumber = dateNumber;
    }
    /**
     *Sets th relation to food
     * 
     * @return
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Food_id")
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.foodDate);
        hash = 61 * hash + Objects.hashCode(this.food);
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
        final Menu other = (Menu) obj;
        if (!Objects.equals(this.foodDate, other.foodDate)) {
            return false;
        }
        if (!Objects.equals(this.food, other.food)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "foodDate=" + foodDate + ", food=" + food + '}';
    }
   
}
