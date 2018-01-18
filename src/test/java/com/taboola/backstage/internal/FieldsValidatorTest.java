package com.taboola.backstage.internal;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.annotations.Final;
import com.taboola.backstage.annotations.ReadOnly;
import com.taboola.backstage.annotations.Required;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by vladi
 * Date: 1/18/2018
 * Time: 12:07 AM
 * By Taboola
 */
public class FieldsValidatorTest extends BackstageTestBase {

    private DummyAnnotationTestClass dummyClass;

    private static class DummyAnnotationTestClass {

        @ReadOnly
        private String id;

        @Final
        private String name;

        @Required
        private String cpc;
    }

    @Before
    public void beforeTest() {
        dummyClass = new DummyAnnotationTestClass();
    }

    @Test
    public void testValidateRequiredFieldsExists() {
        dummyClass.cpc = null;
        dummyClass.name = "notNull";
        try {
            FieldsValidator.validateCreateOperation(dummyClass);
            fail("Did not fail the Required field");
        } catch (BackstageAPIRequestException e) {
            assertEquals("Invalid error message", "Field 'cpc' is 'Required'", e.getMessage());
        }
    }

    @Test
    public void testValidateNoReadOnlyFields() {
        dummyClass.id = "notNull";
        dummyClass.cpc = "notNull";
        dummyClass.name = "notNull";
        try {
            FieldsValidator.validateCreateOperation(dummyClass);
            fail("Did not fail the Required field");
        } catch (BackstageAPIRequestException e) {
            assertEquals("Invalid error message", "Field 'id' is 'ReadOnly'", e.getMessage());
        }
    }

    @Test
    public void testValidateNoFinalFields() {
        dummyClass.name = "notNull";
        try {
            FieldsValidator.validateUpdateOperation(dummyClass);
            fail("Did not fail the Required field");
        } catch (BackstageAPIRequestException e) {
            assertEquals("Invalid error message", "Field 'name' is 'Final'", e.getMessage());
        }
    }

    @Test
    public void testValidateFinalFieldsExists() {
        dummyClass.name = null;
        dummyClass.cpc = "notNull";
        try {
            FieldsValidator.validateCreateOperation(dummyClass);
            fail("Did not fail the Required field");
        } catch (BackstageAPIRequestException e) {
            assertEquals("Invalid error message", "Field 'name' is 'Final'", e.getMessage());
        }
    }
}
