/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package formatter;

import java.util.*;

public class ClearFormatter implements Formatter
{
    private String clearOutput;

    public ClearFormatter(String clearOutput)
    {
        this.clearOutput = clearOutput;
    }

    @Override
    public List<String> format()
    {
        return Arrays.asList(clearOutput);
    }
}
