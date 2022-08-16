package com.uni.kelani.myfourthapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.uni.kelani.myfourthapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    val db = Firebase.firestore

    // Create a new user with a first and last name
    /*val user = hashMapOf(
        "first" to "Ada",
        "last" to "Lovelace",
        "born" to 1815
    )*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {

            val name = binding.editTextFirst.text.toString()
            val age = binding.editTextSecond.text.toString()
            val phone_no = binding.editTextThird.text.toString()
            val uni= binding.editTextFourth.text.toString()


            val user = hashMapOf(
                "Name" to name,
                "Age" to age,
                "Phone_no" to phone_no,
                "University" to uni
            )

            db.collection("User").document("new_user").set(user)
            binding.editTextFirst.setText("")
            binding.editTextSecond.setText("")
            binding.editTextThird.setText("")
            binding.editTextFourth.setText("")

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}