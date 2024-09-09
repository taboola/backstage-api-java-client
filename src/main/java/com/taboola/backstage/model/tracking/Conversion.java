package com.taboola.backstage.model.tracking;

import java.util.List;

/**
 * Created by Marcelo Dias on 08/30/2024.
 */
public class Conversion {
    private List<ConversionAction> actions;

    public List<ConversionAction> getActions() {
        return actions;
    }

    public void setActions(List<ConversionAction> actions) {
        this.actions = actions;
    }
}
