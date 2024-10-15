package com.example.compose.rally.app5.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.compose.rally.app5.LocalDB
import com.example.compose.rally.app5.models.Attendance
import com.example.compose.rally.app5.models.Customer
import com.example.compose.rally.app5.models.Group
import com.example.compose.rally.app5.models.attendance_reason.ReasonModel
import com.google.gson.Gson

class AttendanceViewModel : ViewModel() {

    private val _attendance = Gson().fromJson(LocalDB.jsonData, Attendance::class.java)
    val attendance get() = _attendance.groups

    private val _reasons = Gson().fromJson(LocalDB.reason, ReasonModel::class.java)
    val reasons get() = _reasons.AttendanceAbsentReasonsList

    private val _validate : MutableState<Boolean> = mutableStateOf(false)
    val validate get() = _validate.value

    fun onGroupClick(groupIndex: Int, group: Group) {
        attendance[groupIndex] = group.copy(isExpanded = !group.isExpanded)
    }

    fun onPresentAbsentClick(
        groupIndex: Int,
        customerIndex: Int,
        customer: Customer,
        isPresent: Boolean
    ) {
        if (customer.isPresent == null) {
            attendance[groupIndex].customers[customerIndex] =
                customer.copy(isPresent = isPresent)

            validateSubmission()

            return
        }
        attendance[groupIndex].customers[customerIndex] =
            customer.copy(isPresent = isPresent)

        validateSubmission()
    }

    fun onSpinnerHideAndShowClick(
        groupIndex: Int,
        customerIndex: Int,
        customer: Customer,
        spinnerShouldShow: Boolean
    ) {
        attendance[groupIndex].customers[customerIndex] =
            customer.copy(isClick = spinnerShouldShow)

        validateSubmission()
    }

    fun onDropDownMenuItemClick(
        groupIndex: Int,
        customerIndex: Int,
        customer: Customer,
        reason: String
    ) {
        attendance[groupIndex].customers[customerIndex] =
            customer.copy(
                isClick = false,
                reason = reason
            )
        validateSubmission()
    }

   private fun validateSubmission() {
        // Note : Try to solve this problem with optimum way.

        //if n will be less than 10K this is optimal approach.
        // Brute force approach - Time complexity around O(N^2)

        attendance.flatMap { it.customers.toList() }.forEach { customer ->
            if (customer.isPresent == null) {
                _validate.value = false
                return
            }
            if (customer.reason == null || customer.reason == "Select Reason") {
                if (!customer.isPresent!!) {
                    _validate.value = false
                    return
                }
            }
            _validate.value = true
        }
    }
}