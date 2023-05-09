package com.sportz.cricketnews.presentation.teamdetail

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*

import androidx.fragment.app.DialogFragment
import com.sportz.cricketnews.R
import com.sportz.cricketnews.data.model.Players
import com.sportz.cricketnews.databinding.TeamMemberDialogBinding
import java.util.*

/**
 * @Author: KARTHIKA RAJESH
 * @Date: 09-05-2023
 */
class TeamPlayerDialogFragment : DialogFragment() {
    private lateinit var binding: TeamMemberDialogBinding
    companion object {

        const val TAG = "SimpleDialog"

        private const val KEY_PLAYER = "KEY_PLAYER"

        fun newInstance(players: Players): TeamPlayerDialogFragment {
            val args = Bundle()
            args.putParcelable(KEY_PLAYER, players)
            val fragment = TeamPlayerDialogFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Objects.requireNonNull(dialog)?.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        binding = TeamMemberDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setupView(view)
        setupClickListeners(view)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView(view: View) {
        val player : Players? = arguments?.getParcelable(KEY_PLAYER)
        binding.tvPlayerName.text = "Player Name : " + player?.nameFull
        binding.tvBattingAverage.text = "Batting Average : " + player?.batting?.average
        binding.tvBattingStyle.text = "Batting Style : " +player?.batting?.style
        binding.tvBowlingStyle.text = "Bowling Style : " + player?.bowling?.style
        binding.tvBowlingAverage.text = "Bowline Average : " +player?.bowling?.average
    }

    private fun setupClickListeners(view: View) {
        binding.btnClose.setOnClickListener {
            // TODO: Do some task here
            dismiss()
        }

    }
}