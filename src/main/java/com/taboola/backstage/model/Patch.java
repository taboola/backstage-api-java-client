package com.taboola.backstage.model;

import com.taboola.backstage.annotations.Required;

/**
 * Created by vladi.m
 * Date 2019-07-25
 * Time 16:27
 * Copyright Taboola
 */
public class Patch {

    @Required
    protected PatchOperation patchOperation;

    public PatchOperation getPatchOperation() {
        return patchOperation;
    }

    public void setPatchOperation(PatchOperation patchOperation) {
        this.patchOperation = patchOperation;
    }
}
