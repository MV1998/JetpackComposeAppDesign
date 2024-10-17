package com.example.compose.rally.app3

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username return false`() {
        val result = RegistrationUtil.registerUser(
            "",
            "123",
            "123"
        )
        assertFalse(result)
    }

    @Test
    fun `valid username and correctly repeated password return true`() {
        val result = RegistrationUtil.registerUser(
            "Vaibhav",
            "123",
            "123"
        )
        assertTrue(result)
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.registerUser(
            "Mohit",
            "123",
            "123"
        )
        assertFalse(result)
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtil.registerUser(
            "Mohit",
            "",
            "123"
        )
        assertFalse(result)
    }

    @Test
    fun `password was repeated incorrectly`() {
        val result = RegistrationUtil.registerUser(
            "Mohit",
            "123",
            "223"
        )
        assertFalse(result)
    }

    @Test
    fun `password contains less than 2 digits return false`() {
        val result = RegistrationUtil.registerUser(
            "Mohit",
            "1",
            "1"
        )
        assertFalse(result)
    }

}