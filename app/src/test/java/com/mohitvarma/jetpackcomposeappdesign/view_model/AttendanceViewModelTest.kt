package com.example.compose.rally.app5.view_model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModelProvider
import com.example.compose.rally.app5.models.Customer
import com.example.compose.rally.app5.models.Group
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AttendanceViewModelTest {

    lateinit var viewModel: AttendanceViewModel

    lateinit var group : Group

    lateinit var customer: Customer

    @Before
    fun setUp() {
        viewModel = AttendanceViewModel()
        group = viewModel.attendance[0]
        customer = viewModel.attendance[0].customers[0]
    }

    @Test
    fun testOnGroupClick() {
        val initialState = viewModel.attendance[0].isExpanded

        viewModel.onGroupClick(0, group)

        assertEquals(!initialState, viewModel.attendance[0].isExpanded)
    }

    @Test
    fun testOnPresentAbsentClickTest() {
        val initialState = viewModel.attendance[0].customers[0].isPresent

        viewModel.onPresentAbsentClick(0, 0, customer, true)

        assertEquals(null, initialState)

        assertEquals(true, viewModel.attendance[0].customers[0].isPresent)

        viewModel.onPresentAbsentClick(0, 0, customer, false)

        assertEquals(false, viewModel.attendance[0].customers[0].isPresent)

        customer = viewModel.attendance[0].customers[0]

        viewModel.onPresentAbsentClick(0, 0, customer, true)

        assertEquals(true, viewModel.attendance[0].customers[0].isPresent)

    }

    @Test
    fun testOnSpinnerHideAndShowClick() {
        val initialState = viewModel.attendance[0].customers[0].isClick
        viewModel.onSpinnerHideAndShowClick(0, 0, customer, true)

        assertEquals(false, initialState)
        assertEquals(true, viewModel.attendance[0].customers[0].isClick)

        viewModel.onSpinnerHideAndShowClick(2, 2, customer, true)
        assertEquals(true, viewModel.attendance[2].customers[2].isClick)
    }

    @Test
    fun testOnDropDownMenuItemClick() {
        val initialReason = viewModel.attendance[0].customers[0].reason
        viewModel.onDropDownMenuItemClick(0, 0, customer, "Medical Emergency")

        assertEquals(null, initialReason)

        assertEquals("Medical Emergency", viewModel.attendance[0].customers[0].reason)

        viewModel.onDropDownMenuItemClick(1, 1, customer, "Medical Emergency2")

        assertEquals("Medical Emergency2", viewModel.attendance[1].customers[1].reason)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun testOnInvalidIndex() {
        viewModel.onDropDownMenuItemClick(100, 0, customer, "Medical Emergency")
        viewModel.onDropDownMenuItemClick(0, 110, customer, "Medical Emergency")
    }


    @Test
    fun allIsPresentSelected() {
        val initialValidate = viewModel.validate

        viewModel.attendance.forEachIndexed { groupIndex, group ->
            group.customers.forEachIndexed { customerIndex, customer ->
                viewModel.onPresentAbsentClick(groupIndex, customerIndex, customer, true)
            }
        }

        assertFalse(initialValidate)

        var currentState = viewModel.validate

        assertTrue(currentState)

        viewModel.onPresentAbsentClick(0, 0, customer, false)

        currentState = viewModel.validate

        assertFalse(currentState)
    }

    @After
    fun tearDown() {

    }
}