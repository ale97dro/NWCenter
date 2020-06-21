/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class EnvironmentTest
{
    @Mock
    private DBContainer container;
    @Mock
    private List<String> history;
    private String expectedOs;
    private Environment env;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        expectedOs = "Windows 10";
        env = new Environment(container, history, expectedOs);
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(env);
    }

    @Test
    public void getContainerTest()
    {
        assertSame(container, env.getContainer());
    }

    @Test
    public void getHistory()
    {
        assertSame(history, env.getHistory());
    }

    @Test
    public void getOsTest()
    {
        assertEquals(expectedOs, env.getOs());
    }
}
