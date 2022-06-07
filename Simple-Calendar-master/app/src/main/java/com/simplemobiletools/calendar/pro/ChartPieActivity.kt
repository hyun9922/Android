package com.simplemobiletools.calendar.pro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_chart_pie.*

class ChartPieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_pie)
//
//        piechart.setUsePercentValues(true)
//        piechart.getDescription().setEnabled(false)
//        piechart.setExtraOffsets(5f, 10f, 5f, 5f)
//
//        piechart.setDragDecelerationFrictionCoef(0.95f)
//
//        piechart.setDrawHoleEnabled(false)
//        piechart.setHoleColor(Color.WHITE)
//        piechart.setTransparentCircleRadius(61f)
//
//        val yValues = ArrayList<PieEntry>()
//
//        yValues.add(PieEntry(10f, "0"))
//        yValues.add(PieEntry(10f, "1"))
//        yValues.add(PieEntry(10f, "2"))
//        yValues.add(PieEntry(10f, "3"))
//        yValues.add(PieEntry(10f, "4"))
//        yValues.add(PieEntry(10f, "5"))
//        yValues.add(PieEntry(10f, "6"))
//        yValues.add(PieEntry(10f, "7"))
//        yValues.add(PieEntry(10f, "8"))
//        yValues.add(PieEntry(10f, "9"))
//        yValues.add(PieEntry(10f, "10"))
//        yValues.add(PieEntry(10f, "11"))
//        yValues.add(PieEntry(10f, "12"))
//
//        val description = Description()
//
//        description.setTextSize(15f)
//        piechart.setDescription(description)
//
//
//        val dataSet = PieDataSet(yValues, "")
//        dataSet.sliceSpace = 3f
//        dataSet.selectionShift = 5f
//        dataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
//
//        val data = PieData(dataSet)
//        data.setValueTextSize(10f)
//        data.setValueTextColor(Color.YELLOW)
//
//        //pieChart.invalidate(); // 회전 및 터치 효과 사라짐
//        //pieChart.setTouchEnabled(false);
//
//        //pieChart.invalidate(); // 회전 및 터치 효과 사라짐
//        //pieChart.setTouchEnabled(false);
//        piechart.setData(data)

    }
}
