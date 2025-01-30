package com.example.whereismytrain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.whereismytrain.databinding.FragmentLocalBinding
import com.example.whereismytrain.model.EditTextCancel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class LocalFragment : Fragment() {
    private lateinit var binding: FragmentLocalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLocalBinding.inflate(inflater, container, false)
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
        EditTextCancel.setClearIconListener(binding.etStationName)

        binding.btnFindTrains.setOnClickListener {
            if(binding.etTo.text.isEmpty()){
                Toast.makeText(requireContext(), "Please select a proper source station", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(binding.etFrom.text.isEmpty()){
                Toast.makeText(requireContext(), "Please select a proper source station", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        binding.cvBottomSheet.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())

            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)


            val btnClose = view.findViewById<TextView>(R.id.tvClose)

            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setCancelable(false)

            dialog.setContentView(view)

            dialog.show()
        }
    }

}