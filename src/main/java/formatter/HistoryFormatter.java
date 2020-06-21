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

public class HistoryFormatter implements Formatter
{
    private List<String> history;

    public HistoryFormatter(List<String> history)
    {
        this.history = history;
    }

    @Override
    public List<String> format()
    {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < history.size() - 1; i++)
            result.add(history.get(i) + "\n");

        return result;
    }
}
