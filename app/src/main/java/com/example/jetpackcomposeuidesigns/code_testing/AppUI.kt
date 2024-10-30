package com.example.jetpackcomposeuidesigns.code_testing

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ContextualFlowRowOverflowScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val reusableModifier =  Modifier.background(color = Color.Yellow).size(300.dp)
    .clickable {  }
    .padding(10.dp)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AppUI(modifier: Modifier = Modifier) {
    
    val totalCount = 40
    var maxLines by remember {
        mutableIntStateOf(2)
    }

    val activity = LocalContext.current as Activity

    val moreOrCollapseIndicator = @Composable {scope : ContextualFlowRowOverflowScope ->
        val remainingItems = totalCount - scope.shownItemCount
        AssistChip(onClick = {
            if(remainingItems == 0) {
                maxLines = 2
            }else {
                maxLines += 5
                activity.requestShowKeyboardShortcuts()
            }
        }, label = {
            if(remainingItems == 0) {
                Text("Less")
            }else {
                Text("+$remainingItems")
            }
        })
    }

    Column {
        Text("Another Heading for Other Context")
        ContextualFlowRow(
            itemCount = totalCount,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            maxLines = maxLines,
            overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
                minRowsToShowCollapse = 4,
                expandIndicator = moreOrCollapseIndicator,
                collapseIndicator = moreOrCollapseIndicator
            )

        ) { index ->
            AssistChip(onClick = {}, label = {
                Text("Item $index")
            })
        }
        Text("Another Heading for Other Context")
    }
}

@Preview
@Composable
private fun AppUIPreview() {
    AppUI()
}