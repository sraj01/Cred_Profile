package com.example.profileapplication


import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab.AlbumsTab.value
import androidx.appcompat.app.AppCompatActivity
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Triple
import com.example.profileapplication.R
import com.example.profileapplication.R.drawable.aavatar
import com.example.profileapplication.R.id.editProfile
import com.example.profileapplication.ui.theme.Metric
import com.example.profileapplication.ui.theme.RewardItem

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Profile Info
        val userName = findViewById<TextView>(R.id.userName)
        val memberSince = findViewById<TextView>(R.id.memberSince)
        val profileImage = findViewById<ImageView>(R.id.profileImage)

        userName.text = getString(R.string.android_shivam_raj)
        memberSince.text = getString(R.string.member_since_dec_2020)
        profileImage.setImageResource(aavatar)

        // Top bar click listeners
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        findViewById<ImageView>(R.id.supportButton).setOnClickListener {
            Toast.makeText(this, "Support clicked", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.editProfile).setOnClickListener {
            Toast.makeText(this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show()
        }

        // Garage Promo
        findViewById<LinearLayout>(R.id.garagePromo).setOnClickListener {
            Toast.makeText(this, "Opening CRED Garage", Toast.LENGTH_SHORT).show()
        }

        // Metrics - manually find and set dummy data

        val metric = listOf(
            Metric("Credit Score", "757", R.drawable.ic_support),
            Metric("Cashback Received" , "₹450" , R.drawable.ic_support),
            Metric("Total Bank Balance", "₹89,234", R.drawable.ic_support)
         )

        val metricsContainer = findViewById<LinearLayout>(R.id.profileContainer)

        for ((index, metric) in metric.withIndex()) {
            val metricView = layoutInflater.inflate(R.layout.item_metric, metricsContainer, false)

            val icon = metricView.findViewById<ImageView>(R.id.icon)
            val label = metricView.findViewById<TextView>(R.id.metricTitle)
            val value = metricView.findViewById<TextView>(R.id.metricValue)

            icon.setImageResource(metric.iconResId)
            label.text = metric.title
            value.text = metric.value

            // Add to layout after profile section
            metricsContainer.addView(metricView, 3 + index) // Adjust index accordingly
        }

        // Rewards - same concept
        val rewardItems = listOf(
            RewardItem("cashback balance", "₹0"),
            RewardItem("coins", "26,46,583"),
            RewardItem("win upto Rs 1000", "refer and earn")
        )


        val rewardsContainer = findViewById<LinearLayout>(R.id.profileContainer)

        for ((index,rewardItems ) in rewardItems.withIndex()) {
            val rewardView = layoutInflater.inflate(R.layout.item_reward, rewardsContainer, false)

            val titleText = rewardView.findViewById<TextView>(R.id.rewardTitle)
            val valueText = rewardView.findViewById<TextView>(R.id.rewardValue)

            titleText.text = rewardItems.tittle
            valueText.text = rewardItems.subtitle

            rewardsContainer.addView(rewardView,7)
        }

        findViewById<TextView>(R.id.allTransactions).setOnClickListener {
            Toast.makeText(this, "Showing all transactions", Toast.LENGTH_SHORT).show()
        }
    }
}

