package com.example.android.codelabs.navigation

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ShoppingFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ShoppingFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ShoppingFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_shopping, container, false)
    }
}
