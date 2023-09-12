package com.example.ejerciciouno

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.ejerciciouno.databinding.FragmentADBinding


class ADFragment : DialogFragment() {

    private var _mBinding : FragmentADBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _mBinding = FragmentADBinding.inflate(LayoutInflater.from(requireContext()))
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(mBinding.root)

        val paint = mBinding.tvTitle2.paint
        val width = paint.measureText(mBinding.tvTitle2.text.toString())
        val textShader: Shader = LinearGradient(0f, 0f, width, mBinding.tvTitle2.textSize,
            intArrayOf(
                Color.parseColor("#FF065FC1"),
                Color.parseColor("#FF02B07F"),
                Color.parseColor("#FF00E554")
            ), null, Shader.TileMode.REPEAT)

        mBinding.tvTitle2.paint.shader = textShader

        mBinding.btnWantCard.setOnClickListener{
            Toast.makeText(requireContext(), mBinding.btnWantCard.text.toString(), Toast.LENGTH_SHORT).show()
            dismiss()
        }

        mBinding.btnLater.setOnClickListener {
            Toast.makeText(requireContext(), mBinding.btnLater.text.toString(), Toast.LENGTH_SHORT).show()
            dismiss()
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return dialog
    }
}