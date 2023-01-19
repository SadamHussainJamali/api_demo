package com.example.apidemo.cutom_view

import android.content.Context
import android.content.res.TypedArray
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import com.example.apidemo.R
import com.example.apidemo.databinding.EditTextCutomeViewBinding


@InverseBindingMethods(
    InverseBindingMethod(
        type = EditTextField::class,
        attribute = "android:text",
        method = "getText"
    )
)

class EditTextField(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    val TAG = EditTextField::class.simpleName

    private var typedArray: TypedArray
    private var binding: EditTextCutomeViewBinding
    private var inputType: String? = null
        set(value) {
            if (value.equals("password"))
                binding.inputField.inputType =
                    (InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS or InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            field = value
        }


    private var title: String? = null
        set(value) {
            binding.title.text = value.toString()
            field = value
        }


    private var text: String? = null
        set(value) {
            binding.inputField?.setText(field ?: "")
            field = value
        }
        get() = binding.inputField.text.toString()

    init {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = EditTextCutomeViewBinding.inflate(layoutInflater)
        addView(binding.root)
        typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.EditTextFieldAttrs, 0, 0)
        inputType = typedArray.getString(R.styleable.EditTextFieldAttrs_input_type)
        title = typedArray.getString(R.styleable.EditTextFieldAttrs_title)
        text = typedArray.getString(R.styleable.EditTextFieldAttrs_text)
    }
}