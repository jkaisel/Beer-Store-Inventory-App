package android.example.shoestoreinventoryapp.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.example.shoestoreinventoryapp.R
import android.view.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class ShoeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true )

        return inflater.inflate(R.layout.fragment_shoe_list, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

}