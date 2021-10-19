package dev.jahidhasanco.customnavigationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var recView: RecyclerView
    private lateinit var cycleAdapter: CycleAdapter
    private lateinit var cycles: ArrayList<Cycle>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recView = view.findViewById(R.id.recView)

        cycles = arrayListOf()

        cycles.add(Cycle("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuOl0jXwkOgsPssspf61y8wuBviLvh2L3Ebg&usqp=CAU","Venor Pro","Butted Hydro formed","$200"))
        cycles.add(Cycle("https://i.ytimg.com/vi/F5Zi-Dh43PE/maxresdefault.jpg","Black Viks","Butted Hydro formed","$100"))
        cycles.add(Cycle("https://st2.depositphotos.com/6249544/9109/i/950/depositphotos_91092560-stock-photo-girl-on-bike.jpg","Girls Cycle","Butted Hydro formed","$120"))
        cycles.add(Cycle("https://images.unsplash.com/photo-1571333250630-f0230c320b6d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDIwfHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60","Racing Cycle","Butted Hydro formed","$240"))
        cycles.add(Cycle("https://images.unsplash.com/photo-1497515098781-e965764ab601?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1421&q=80","Venor Pro","Butted Hydro formed","$210"))
        cycles.add(Cycle("https://images.unsplash.com/photo-1506119349711-26835f131010?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80","Venor Pro","Butted Hydro formed","$220"))

        cycleAdapter = CycleAdapter(cycles,requireContext())

        recView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cycleAdapter
            setHasFixedSize(true)
        }



        return view
    }


}