package com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.ui.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.data.LocalDB
import com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.domain.models.Attendance
import com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.domain.models.Customer
import com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.domain.models.Group
import com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.domain.models.attendance_reason.ReasonModel
import com.google.gson.Gson
import org.jetbrains.annotations.VisibleForTesting

class AttendanceViewModel : ViewModel() {

    // this data can be got for UseCase
    // UseCase will have parameter of type DataRepository
    private val _attendance = Gson().fromJson(LocalDB.jsonData, Attendance::class.java)
    val attendance get() = _attendance.groups

    private val _reasons = Gson().fromJson(LocalDB.reason, ReasonModel::class.java)
    val reasons get() = _reasons.AttendanceAbsentReasonsList

    private val _validate : MutableState<Boolean> = mutableStateOf(false)
    val validate get() = _validate.value

    fun onGroupClick(groupIndex: Int, group: Group) {
        attendance[groupIndex] = group.copy(isExpanded = !group.isExpanded)
    }

    @VisibleForTesting
    internal fun onPresentAbsentClick(
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

    @VisibleForTesting
    internal fun onSpinnerHideAndShowClick(
        groupIndex: Int,
        customerIndex: Int,
        customer: Customer,
        spinnerShouldShow: Boolean
    ) {
        attendance[groupIndex].customers[customerIndex] =
            customer.copy(isClick = spinnerShouldShow)

        validateSubmission()
    }

    @VisibleForTesting
    internal fun onDropDownMenuItemClick(
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