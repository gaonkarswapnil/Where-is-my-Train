package com.example.whereismytrain

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.whereismytrain.databinding.FragmentExpressBinding
import com.example.whereismytrain.model.EditTextCancel


class ExpressFragment : Fragment() {

    private lateinit var binding: FragmentExpressBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentExpressBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSwap.setOnClickListener {
            val from = binding.etFrom.text
            val to = binding.etTo.text

            binding.etFrom.setText(to)
            binding.etTo.setText(from)
        }

        EditTextCancel.setClearIconListener(binding.etFrom)
        EditTextCancel.setClearIconListener(binding.etTo)
        EditTextCancel.setClearIconListener(binding.etTrainNo)
        EditTextCancel.setClearIconListener(binding.etStation)

        binding.btnFindTrains.setOnClickListener {
            if (binding.etTo.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please select a proper source station",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (binding.etFrom.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please select a proper source station",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
        }       

//        binding.etFrom.addTextChangedListener(
//            object : TextWatcher {
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//                }
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//                }
//
//                override fun afterTextChanged(s: Editable?) {
//                    val drawableEnd = if (s.isNullOrEmpty()) null else ContextCompat.getDrawable(requireContext(), R.drawable.ic_clear)
//                    drawableEnd?.setBounds(0, 0, drawableEnd.intrinsicWidth, drawableEnd.intrinsicHeight)
//                    binding.etFrom.setCompoundDrawablesWithIntrinsicBounds(
//                        null,  // Start drawable
//                        null,  // Top drawable
//                        drawableEnd,  // End drawable
//                        null   // Bottom drawable
//                    )
//                }
//
//            }
//        )

        binding.btnPrn.setOnClickListener {
            Intent(requireContext(), PrnActivity::class.java).also{
                startActivity(it)
            }
        }

        binding.btnTicket.setOnClickListener {
            Intent(requireContext(), TicketActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}