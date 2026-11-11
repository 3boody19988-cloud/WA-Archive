
package com.waarchive

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.app.Notification
import org.json.JSONObject
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WhatsAppListener : NotificationListenerService() {

    override fun onNotificationPosted(
        sbn: StatusBarNotification
    ) {
        if (sbn.packageName != "com.whatsapp") return

        val extras = sbn.notification.extras

        val title = extras.getCharSequence(
            Notification.EXTRA_TITLE
        )?.toString() ?: ""

        val message = extras.getCharSequence(
            Notification.EXTRA_BIG_TEXT
        )?.toString()
            ?: extras.getCharSequence(
                Notification.EXTRA_TEXT
            )?.toString()
            ?: ""

        if (message.isBlank()) return

        val item = JSONObject().apply {
            put("title", title)
            put("message", message)
            put("time", System.currentTimeMillis())
        }

        try {
            File(filesDir, "messages.jsonl")
                .appendText(item.toString() + "\n")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
