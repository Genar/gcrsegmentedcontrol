package org.genar.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.genar.gcrsegmentedcontrol.GcrSegmentedControl
import org.genar.gcrsegmentedcontrol.GcrSegmentedControlListener

class MainActivity : AppCompatActivity(), GcrSegmentedControlListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var segmentedControl : GcrSegmentedControl = this.findViewById(R.id.segmented_control_id)
        segmentedControl.setGcrSegmentedControlListener(this)
    }

    override fun onFirstButtonClicked() {
        Log.d("Cucut", "First Button")
    }

    override fun onSecondButtonClicked() {
        Log.d("Cucut", "Second Button")
    }

    override fun onThirdButtonClicked() {
        Log.d("Cucut", "Third Button")
    }

    override fun onFourthButtonClicked() {
        Log.d("Cucut", "Fourth Button")
    }
}
