
package com.waarchive

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(32, 32, 32, 32)
        layout.layoutDirection = View.LAYOUT_DIRECTION_RTL

        val title = TextView(this)
        title.text = "WA Archive"
        title.textSize = 30f
        title.gravity = Gravity.CENTER

        val description = TextView(this)
        description.text = "أرشيف رسائل واتساب"
        description.textSize = 20f
        description.gravity = Gravity.CENTER
        description.setPadding(0, 30, 0, 30)

        val button = Button(this)
        button.text = "تفعيل صلاحية الإشعارات"

        button.setOnClickListener {
            startActivity(
                Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
            )
        }

        layout.addView(title)
        layout.addView(description)
        layout.addView(button)

        setContentView(layout)
    }
}
