/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package formatter;

import java.util.ArrayList;
import java.util.List;

public class ExitFormatter implements Formatter
{
    @Override
    public List<String> format()
    {
        List<String> result = new ArrayList<>();
        result.add("Closing NW Center...");

        return result;
    }
}
