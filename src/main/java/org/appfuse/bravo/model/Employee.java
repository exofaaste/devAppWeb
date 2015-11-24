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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author fabian
 */
@XmlRootElement
@Entity
@Table(name="Employee")
public class Employee implements Serializable {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String active;

    /**
     *employeeID
     * @return
     */
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_id", unique = true, nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     *firstName
     * @return
     */
    @Column(name = "First_Name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *lastName
     * @return
     */
    @Column(name = "Last_Name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *email
     * @return
     */
    @Column(name = "Email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Attribute defines weather an employee is currently active or not
     * @return
     */
    @Column(name = "Active")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" + "Employee_id=" + employeeID + ", First_Name=" + firstName + ", Last_Name=" + lastName + ", Email=" + email + ", Active=" + active + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.employeeID;
        hash = 11 * hash + Objects.hashCode(this.firstName);
        hash = 11 * hash + Objects.hashCode(this.lastName);
        hash = 11 * hash + Objects.hashCode(this.email);
        hash = 11 * hash + Objects.hashCode(this.active);
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
        final Employee other = (Employee) obj;
        if (this.employeeID != other.employeeID) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return true;
    }
    
    
    
}
