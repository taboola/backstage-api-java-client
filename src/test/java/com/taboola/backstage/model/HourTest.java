package com.taboola.backstage.model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by vladi.m
 * Date 03/10/2018
 * Time 16:47
 * Copyright Taboola
 */
public class HourTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testEnumToJson_whenGivenExistingEnum_expectingString() throws IOException {
        Assert.assertEquals("Invalid string", "0", objectMapper.writeValueAsString(Hour.ZERO));
        Assert.assertEquals("Invalid string", "1", objectMapper.writeValueAsString(Hour.ONE));
        Assert.assertEquals("Invalid string", "10", objectMapper.writeValueAsString(Hour.TEN));
        Assert.assertEquals("Invalid string", "15", objectMapper.writeValueAsString(Hour.FIFTEEN));
        Assert.assertEquals("Invalid string", "24", objectMapper.writeValueAsString(Hour.TWENTY_FOUR));
    }

    @Test
    public void testFromJsonToEnum_whenGivenExistingStrNumber_expectingEnum() throws IOException {
        Assert.assertEquals("Invalid enum", Hour.ZERO, objectMapper.readValue("0", Hour.class));
        Assert.assertEquals("Invalid enum", Hour.ONE, objectMapper.readValue("1", Hour.class));
        Assert.assertEquals("Invalid enum", Hour.TEN, objectMapper.readValue("10", Hour.class));
        Assert.assertEquals("Invalid enum", Hour.FIFTEEN, objectMapper.readValue("15", Hour.class));
        Assert.assertEquals("Invalid enum", Hour.TWENTY_FOUR, objectMapper.readValue("24", Hour.class));
    }

    @Test
    public void testFromJsonToEnum_whenGivenNonNumberStrNumber_expectingNull() throws IOException {
        Assert.assertNull("Invalid enum", objectMapper.readValue("null", Hour.class));
        Assert.assertNull("Invalid enum", objectMapper.readValue("true", Hour.class));
        Assert.assertNull("Invalid enum", objectMapper.readValue("false", Hour.class));
        Assert.assertNull("Invalid enum", objectMapper.readValue("\"abc\"", Hour.class));
    }
}
