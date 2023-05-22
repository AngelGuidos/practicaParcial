package com.example.pruebacontiempo.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.pruebacontiempo.R
import com.example.pruebacontiempo.databinding.FragmentBillboardBinding

class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentBillboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_newGameFragment)
        }
    }

}