package org.appfuse.tutorial.service.impl;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.appfuse.bravo.model.Employee;
import org.bravo.dao.EmployeeDao;
import org.appfuse.bravo.service.impl.EmployeeManagerImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.*;

public class EmployeeManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private EmployeeManagerImpl manager;

    @Mock
    private EmployeeDao dao;

    @Test
    public void testGetEmployee() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final Employee employee = new Employee();
        given(dao.get(id)).willReturn(employee);

        //when
        Employee result = manager.get(id);

        //then
        assertSame(employee, result);
    }

    @Test
    public void testGetEmployees() {
        log.debug("testing getAll...");
        //given
        final List employees = new ArrayList();
        given(dao.getAll()).willReturn(employees);

        //when
        List result = manager.getAll();

        //then
        assertSame(employees, result);
    }

    @Test
    public void testSaveEmployee() {
        log.debug("testing save...");

        //given
        final Employee employee = new Employee();
        // enter all required fields

        given(dao.save(employee)).willReturn(employee);

        //when
        manager.save(employee);

        //then
        verify(dao).save(employee);
    }

    @Test
    public void testRemoveEmployee() {
        log.debug("testing remove...");

        //given
        final Long id = -11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}
