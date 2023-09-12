package com.example.ejerciciouno

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejerciciouno.databinding.FragmentWalletBinding


class WalletFragment : Fragment() {

    private var _mBinding : FragmentWalletBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentWalletBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val paintDollar = mBinding.tvDollarAccount.paint
        val widthDollar = paintDollar.measureText(mBinding.tvDollarAccount.text.toString())
        val textShaderDollar: Shader = LinearGradient(0f, 0f, widthDollar, mBinding.tvDollarAccount.textSize,
            intArrayOf(
                Color.parseColor("#FF065FC1"),
                Color.parseColor("#FF02B07F"),
                Color.parseColor("#FF00E554")
            ), null, Shader.TileMode.REPEAT)

        mBinding.tvDollarAccount.paint.shader = textShaderDollar

        val paintPeso = mBinding.tvPesosAccount.paint
        val widthPeso = paintPeso.measureText(mBinding.tvPesosAccount.text.toString())
        val textShaderPeso: Shader = LinearGradient(0f, 0f, widthPeso, mBinding.tvPesosAccount.textSize,
            intArrayOf(
                Color.parseColor("#FF065FC1"),
                Color.parseColor("#FF02B07F"),
                Color.parseColor("#FF00E554")
            ), null, Shader.TileMode.REPEAT)

        mBinding.tvPesosAccount.paint.shader = textShaderPeso

        mBinding.clServicesPay.setOnClickListener {
            val dialog = ADFragment()
            dialog.show(childFragmentManager, "")
        }
    }
}