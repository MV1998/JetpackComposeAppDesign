package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.ui.screens.reports

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.MonthMemoryDB
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Report
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.utils.toCurrencyFormat
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.utils.toDateFormat
import com.example.jetpackcomposeuidesigns.ui.theme.headerTextStyle
import java.util.Date

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun ReportScreen(
    reportViewModel: ReportViewModel,
    onNavigationToParticularReport: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val reportList by reportViewModel.reportList.collectAsStateWithLifecycle()

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    var showDeleteDialog by remember {
        mutableIntStateOf(-1)
    }

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    var showByMonthDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                actions = {
                    IconButton(onClick = {
                        showBottomSheet = !showBottomSheet
                    }) {
                        Icon(
                            imageVector = Icons.Default.FilterAlt,
                            contentDescription = "Filter"
                        )
                    }
                },
                title = {
                    Text(
                        "Inventory System", style = TextStyle(
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showDatePicker = !showDatePicker
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Report")
            }
        }
    ) { padding ->
        if (reportList.isEmpty()) {
            Column(
                modifier = modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "No Report", style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
                Text("Add Report by + Icon")
            }
        } else {
            ReportListLayout(
                reportList = reportList,
                onNavigationToParticularReport = {
                    onNavigationToParticularReport(it)
                },
                showDeleteDialog = {
                    showDeleteDialog = it
                },
                modifier = modifier.padding(padding)
            )
        }

        if (showBottomSheet) {
            FilterModalBottomSheet(
                onByMonth = {
                    showBottomSheet = !showBottomSheet
                    showByMonthDialog = !showByMonthDialog
                },
                onDismissRequest = {
                    showBottomSheet = !showBottomSheet
                })
        }

        if (showByMonthDialog) {
            BasicAlertDialog(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(.9f)
                    .background(color = MaterialTheme.colorScheme.surface),
                onDismissRequest = {
                    showByMonthDialog = !showByMonthDialog
                }
            ) {
                LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                    items(MonthMemoryDB.monthList) {
                        TextButton(onClick = {
                            showByMonthDialog = !showByMonthDialog
                        }) {
                            Text(
                                it.name, style = TextStyle(
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            )
                        }
                    }
                }
            }
        }

        if (showDatePicker) {
            DatePickerModal(onDateSelected = {
                reportViewModel.addNewReport(it)
            }, onDismiss = {
                showDatePicker = !showDatePicker
            })
        }

    }

    if (showDeleteDialog != -1) {
        Dialog(
            onDismissRequest = {
                showDeleteDialog = -1
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .wrapContentHeight()
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(10.dp)
            ) {
                Text(
                    "All products will also be deleted which belongs this report." +
                            " Do you want to delete this report?",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = {
                        showDeleteDialog = -1
                    }) { Text("Cancel") }

                    Button(onClick = {
                        reportViewModel.deleteReport(showDeleteDialog)
                        showDeleteDialog = -1
                    }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReportListLayout(
    reportList: MutableList<Report>,
    onNavigationToParticularReport: (Int) -> Unit,
    showDeleteDialog: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        ListItem(
            colors = ListItemDefaults.colors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            ),
            headlineContent = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Date", modifier = Modifier.weight(1f),
                        style = headerTextStyle()
                    )
                    Text(
                        "Grand Revenue", modifier = Modifier.weight(1f),
                        style = headerTextStyle()
                    )
                    Text(
                        "Grand Profit", modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Right,
                        style = headerTextStyle()
                    )
                }
            }
        )
        LazyColumn {
            items(reportList, key = { it.id }) {
                Card(
                    modifier = Modifier.padding(4.dp)
                ) {
                    ListItem(
                        modifier = Modifier
                            .combinedClickable(
                                onClick = {
                                    onNavigationToParticularReport(it.id)
                                },
                                onLongClick = {
                                    showDeleteDialog(it.id)
                                }
                            ),
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                        ),
                        headlineContent = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    it.createdAt.toDateFormat(), style = TextStyle(
                                        color = MaterialTheme.colorScheme.onSurface,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    it.totalRevenue.toString().toCurrencyFormat(),
                                    style = TextStyle(
                                        color = MaterialTheme.colorScheme.onSurface,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    it.totalProfit.toString().toCurrencyFormat(),
                                    style = TextStyle(
                                        color = MaterialTheme.colorScheme.onSurface,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterModalBottomSheet(
    onByMonth: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {

    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        modifier = modifier.fillMaxHeight(.3f),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        sheetState = sheetState,
        onDismissRequest = onDismissRequest
    ) {
        Text(
            "Filter By ",
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Bold
            )
        )
        FlowRow(
            modifier = modifier.padding(5.dp)
        ) {
            AssistChip(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Month"
                    )
                },
                onClick = onByMonth, label = {
                    Text("By Month")
                })
            Spacer(modifier = modifier.width(10.dp))
            AssistChip(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Month"
                    )
                },
                onClick = {

                }, label = {
                    Text("By Date Range")
                })
        }

        Text(
            "Sort By ",
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Bold
            )
        )


        FlowRow(
            modifier = modifier.padding(5.dp)
        ) {
            AssistChip(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CurrencyRupee,
                        contentDescription = "Month"
                    )
                },
                onClick = {

                }, label = {
                    Text("By Revenue")
                })

            Spacer(modifier = modifier.width(10.dp))
            AssistChip(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CurrencyRupee,
                        contentDescription = "Month"
                    )
                },
                onClick = {

                }, label = {
                    Text("By Profit")
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Date?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis?.let { Date(it) })
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState, headline = {
            Text("  Report Date")
        })
    }
}
