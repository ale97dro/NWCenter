/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package model;

import java.util.List;

public class Environment
{
    private DBContainer container;
    private List<String> history;
    private String os;

    public Environment(DBContainer container, List<String> history, String os)
    {
        this.container = container;
        this.history = history;
        this.os = os;
    }

    public DBContainer getContainer()
    {
        return container;
    }

    public List<String> getHistory()
    {
        return history;
    }

    public String getOs()
    {
        return os;
    }
}
