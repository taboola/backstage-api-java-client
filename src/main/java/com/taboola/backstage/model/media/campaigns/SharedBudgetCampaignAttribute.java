package com.taboola.backstage.model.media.campaigns;

public class SharedBudgetCampaignAttribute<T> {
    private String source;
    private T value;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SharedBudgetCampaignAttribute{" +
                "source=" + source +
                ", value=" + value +
                '}';
    }
}
