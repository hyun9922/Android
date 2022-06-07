package com.simplemobiletools.calendar.pro.dialogs

import android.app.Activity
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.simplemobiletools.calendar.pro.R
import com.simplemobiletools.calendar.pro.extensions.config
import com.simplemobiletools.calendar.pro.helpers.BAR_EVENT
import com.simplemobiletools.calendar.pro.helpers.PIE_EVENT
import com.simplemobiletools.calendar.pro.helpers.REMINDER_OFF
import com.simplemobiletools.calendar.pro.helpers.*
import com.simplemobiletools.commons.extensions.*
import kotlinx.android.synthetic.main.dialog_set_reminders.view.*

class SetReminderChart (val activity: Activity, val eventType: Int, val callback: (reminders: ArrayList<Int>) -> Unit){
    private var mReminder1Minutes = REMINDER_OFF
    private var mReminder2Minutes = REMINDER_OFF
    private var isAutomatic = false

    init {
        val view = activity.layoutInflater.inflate(R.layout.dialog_set_reminders, null).apply {
            set_reminders_image.applyColorFilter(context.getProperTextColor())
            set_reminders_1.text = activity.getFormattedMinutes(mReminder1Minutes)
            set_reminders_2.text = activity.getFormattedMinutes(mReminder1Minutes)


            set_reminders_1.setOnClickListener {
                activity.showPickSecondsDialogHelper(mReminder1Minutes, showDuringDayOption = true) {
                    mReminder1Minutes = if (it == -1 || it == 0) it else it / 60
                    set_reminders_1.text = activity.getFormattedMinutes(mReminder1Minutes)
                    if (mReminder1Minutes != REMINDER_OFF) {
                        set_reminders_2.beVisible()
                    }
                }
            }

            set_reminders_2.setOnClickListener {
                activity.showPickSecondsDialogHelper(mReminder2Minutes, showDuringDayOption = true) {
                    mReminder2Minutes = if (it == -1 || it == 0) it else it / 60
                    set_reminders_2.text = activity.getFormattedMinutes(mReminder2Minutes)
                    if (mReminder2Minutes != REMINDER_OFF) {
                        set_reminders_3.beVisible()
                    }
                }
            }


            add_event_automatically_checkbox.apply {
                visibility = if (eventType == OTHER_EVENT) View.GONE else View.VISIBLE
                text = when (eventType) {
                    BAR_EVENT-> activity.getString(R.string.add_barchart)
                    PIE_EVENT -> activity.getString(R.string.add_piechart)
                    else -> ""
                }
                isChecked = when (eventType) {
                    BAR_EVENT -> activity.config.addBarChart
                    PIE_EVENT -> activity.config.addPieChart
                    else -> false
                }
                isAutomatic = isChecked
                setOnCheckedChangeListener { _, isChecked -> isAutomatic = isChecked }
            }
        }

        AlertDialog.Builder(activity)
            .setPositiveButton(R.string.ok,null)
            .setNegativeButton(R.string.cancel, null)
            .create().apply {
                activity.setupDialogStuff(view, this)
            }
    }

    private fun dialogConfirmed() {
        val tempReminders = arrayListOf(mReminder1Minutes, mReminder2Minutes).filter { it != REMINDER_OFF }.sorted()
        val reminders = arrayListOf(

            tempReminders.getOrNull(1) ?: REMINDER_OFF,
            tempReminders.getOrNull(2) ?: REMINDER_OFF
        )

        if (eventType == BAR_EVENT) {
            activity.config.addBarChart = isAutomatic
            activity.config.barchartReminders = reminders
        }

        if (eventType == PIE_EVENT) {
            activity.config.addPieChart = isAutomatic
            activity.config.piechartReminders = reminders
        }

        callback(reminders)
    }
}
