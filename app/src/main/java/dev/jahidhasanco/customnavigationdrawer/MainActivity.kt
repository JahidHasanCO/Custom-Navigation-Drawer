package dev.jahidhasanco.customnavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var drawerLayout: DuoDrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var textH: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer)

        replace(HomeFragment())

        initDrawer()
    }

    private fun initDrawer() {
        val drawerToggle = DuoDrawerToggle(this,drawerLayout,toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.setDrawerListener(drawerToggle)
        drawerToggle.syncState()

        val contentView: View = drawerLayout.contentView
        val menuView: View = drawerLayout.menuView

        textH = menuView.findViewById(R.id.hello)
        textH.setOnClickListener(this)




    }

    override fun onClick(p0: View?) {

        when (p0!!.id){
            R.id.hello ->
            {
                replace(HomeFragment(),"Home")
                Toast.makeText(this, "Hello Clicked",Toast.LENGTH_SHORT).show()
            }

            else -> {
                replace(HomeFragment(),"Home")
            }

        }
        drawerLayout.closeDrawer()
    }

    private fun replace(fragment: Fragment, s: String) {
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerF, fragment )
        transaction.addToBackStack(s)
        transaction.commit()
    }

    private fun replace(fragment: Fragment) {
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerF, fragment )
        transaction.commit()
    }
}