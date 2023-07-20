package com.saadkhairudinhanif.navigationdrawer

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.saadkhairudinhanif.navigationdrawer.databinding.ActivityMainBinding
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var profilecircleImageView: CircleImageView
    private var profileImage = "https://lh3.googleusercontent.com/pw/AIL4fc_4iaM4MjNoxpCU6ydC3wo6a0jpqNwgp2ThJsi4hpjxvnaPgiGUv-ql9tAXoijDOkW9aFQJ1-RKEegPMm3jC9U_XuvdpeRoeXDakwCFl1nIwb7bvA9h0jBWGek_EitpwNuEpRw_tkraj6xDu7OKO_Fd6U84ySXn1y7_msp0khMSFPrnRolvocpBweOfXmTe7MKIQ4gpMYdAbqx0ycG1hOq2RqZa9hclKXkkttlx9zwLadMtNVgkEA9SF_-T-iEw-uvhA-EOpugFAu-uhrxsl2bxaEoB_YBwU9aPpwsjK8k-vJ_ziRD_V_ZD-ffaiFheRkI2OA8UoNAvORNK7k8iWGmna_JNepdBBmioWlZmw3Fztp-b_it7BA1Q6QyqcTnJvXLphfPuh1YLEaD_mVECW05VgznEk0s3dxucBaA5YCyWOvStl3MEYrkcZrTu18I3WVB8e2Mx6MgjZWSj4NWqsetb_5AEmaRAY5_lTQI9PpIZ4zqGEkFN4Y63VYP9nDiHCqtmfRH3BHEwEHx8vUxW1CLZy8u8QD4s4TTnzNzdVySI6QRL0AbWLFFeJ_2JPSGSpTL8u4b8XiBdTuXlqPuRd9Jv8LsIMQgeSKY-EqVSR0aVAAl4bSqmA7-aUs-A4je6rtjhWOP_3shSj3I4CwsCNDWXVJAd3tmaPldJmxkB6zDRy1ZgvcW5HQvyyZV0LVJ7TRFdfuLkslf_Yz5nVJcLPP8VKqCUkbXsYn-QHgA9lxD2Q36E9_FXpR6gnPV2K2KPYN9L7TZ6fKzMSSHMbR7-93U0n76fKFJdf-WFT_Y-r16eLYNpR2vcPpq7UkVlzVvOX0StUonpS_3MOv1MPgRiHlGFmIcSo6_AXK8V4Et1sOJhPx5N7Ygtv_rASxublm9htIvyKDXWIoF0HHutAoGI45nyUw=w465-h827-s-no?authuser=0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        profilecircleImageView = navView.getHeaderView(0).findViewById(R.id.imageView)
        Glide.with(this).load(profileImage).into(profilecircleImageView)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_cart
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}