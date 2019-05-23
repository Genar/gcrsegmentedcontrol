package org.genar.gcrsegmentedcontrol


import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.getColor


interface GcrSegmentedControlListener {

    fun onFirstButtonClicked()
    fun onSecondButtonClicked()
    fun onThirdButtonClicked()
    fun onFourthButtonClicked()
}

class GcrSegmentedControl @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes), View.OnClickListener {

    private var firstButton: Button
    private var secondButton: Button
    private var thirdButton: Button
    private var fourthButton: Button

    private var segmentedControlListener: GcrSegmentedControlListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.gcr_view_segmented_control, this, true)

        firstButton = findViewById(R.id.gcr_first_segmented_control_button_id)
        firstButton.setOnClickListener(this)

        secondButton = findViewById(R.id.gcr_second_segmented_control_button_id)
        secondButton.setOnClickListener(this)

        thirdButton = findViewById(R.id.gcr_third_segmented_control_button_id)
        thirdButton.setOnClickListener(this)

        fourthButton = findViewById(R.id.gcr_fourth_segmented_control_button_id)
        fourthButton.setOnClickListener(this)

            attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.gcrsegmentedcontrol,
                0, 0)
            val title = resources.getText(typedArray
                .getResourceId(
                    R.styleable.gcrsegmentedcontrol_gcr_segmented_control_text,
                    R.string.gcr_first_segmented_button_text))
            typedArray.recycle()
        }

        setSelectedButtons(isFirstSelected = true, isSecondSelected = false, isThirdSelected = false, isFourthSelected = false)
    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.gcr_first_segmented_control_button_id -> {
                setSelectedButtons(isFirstSelected = true, isSecondSelected = false, isThirdSelected = false, isFourthSelected = false)
                setButtonsTextColor(R.color.gcr_white, R.color.gcr_blue_dark, R.color.gcr_blue_dark, R.color.gcr_blue_dark)
                segmentedControlListener?.onFirstButtonClicked()
            }
            R.id.gcr_second_segmented_control_button_id -> {
                setSelectedButtons(isFirstSelected = false, isSecondSelected = true, isThirdSelected = false, isFourthSelected = false)
                setButtonsTextColor(R.color.gcr_blue_dark, R.color.gcr_white, R.color.gcr_blue_dark, R.color.gcr_blue_dark)
                segmentedControlListener?.onSecondButtonClicked()
            }
            R.id.gcr_third_segmented_control_button_id -> {
                setSelectedButtons(isFirstSelected = false, isSecondSelected = false, isThirdSelected = true, isFourthSelected = false)
                setButtonsTextColor(R.color.gcr_blue_dark, R.color.gcr_blue_dark, R.color.gcr_white, R.color.gcr_blue_dark)
                segmentedControlListener?.onThirdButtonClicked()
            }
            R.id.gcr_fourth_segmented_control_button_id -> {
                setSelectedButtons(isFirstSelected = false, isSecondSelected = false, isThirdSelected = false, isFourthSelected = true)
                setButtonsTextColor(R.color.gcr_blue_dark, R.color.gcr_blue_dark, R.color.gcr_blue_dark, R.color.gcr_white)
                segmentedControlListener?.onFourthButtonClicked()
            }
        }
    }

    fun setGcrSegmentedControlListener(listener: GcrSegmentedControlListener) {

        this.segmentedControlListener = listener
    }

    fun showTwoButtons() {

        secondButton.visibility = View.GONE
        thirdButton.visibility = View.GONE
    }

    fun showThreeButtons() {

        thirdButton.visibility = View.GONE
    }

    fun performClickOnFirst() {

        firstButton.performClick()
    }


    fun performClickOnSecond() {

        secondButton.performClick()
    }

    fun performClickOnThird() {

        thirdButton.performClick()
    }

    fun performClickOnFourth() {

        fourthButton.performClick()
    }

    fun setTextFirstButton(text:String) {

        firstButton.text = text
    }

    fun setTextSecondButton(text:String) {

        secondButton.text = text
    }

    fun setTextThirdButton(text:String) {

        thirdButton.text = text
    }

    fun setTextFourthButton(text:String) {

        fourthButton.text = text
    }

    private fun setSelectedButtons(isFirstSelected:Boolean, isSecondSelected:Boolean, isThirdSelected: Boolean, isFourthSelected: Boolean) {

        firstButton.isSelected = isFirstSelected
        secondButton.isSelected = isSecondSelected
        thirdButton.isSelected = isThirdSelected
        fourthButton.isSelected = isFourthSelected
    }

    private fun setButtonsTextColor(firstBtnColor: Int, secondBtnColor: Int, thirdBtnColor:Int, fourthBtnColor: Int) {

        firstButton.setTextColor(getColor(context, firstBtnColor))
        secondButton.setTextColor(getColor(context, secondBtnColor))
        thirdButton.setTextColor(getColor(context, thirdBtnColor))
        fourthButton.setTextColor(getColor(context, fourthBtnColor))
    }
}