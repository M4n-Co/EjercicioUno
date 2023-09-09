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

        val paint = mBinding.tvDollarAccount.paint
        val width = paint.measureText(mBinding.tvDollarAccount.text.toString())
        val textShader: Shader = LinearGradient(0f, 0f, width, mBinding.tvDollarAccount.textSize,
            intArrayOf(
                Color.parseColor("#FF065FC1"),
                Color.parseColor("#FF02B07F"),
                Color.parseColor("#FF00E554")
            ), null, Shader.TileMode.REPEAT)

        mBinding.tvDollarAccount.paint.shader = textShader
    }
}