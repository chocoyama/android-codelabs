package com.example.background.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.text.TextUtils
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.background.KEY_IMAGE_URI
import com.example.background.R
import timber.log.Timber
import java.lang.IllegalArgumentException

class BlurWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        makeStatusNotification("Blurring image", applicationContext)
        return try {
            val resourceUri = inputData.getString(KEY_IMAGE_URI)
            if (TextUtils.isEmpty(resourceUri)) {
                Timber.e("Invalid input Uri")
                throw IllegalArgumentException("Invalid input uri")
            }

            val picture = BitmapFactory.decodeStream(
                    applicationContext
                            .contentResolver
                            .openInputStream(Uri.parse(resourceUri))
            )

            val output = blurBitmap(picture, applicationContext)
            val outputUri = writeBitmapToFile(applicationContext, output)

            makeStatusNotification("Output is $outputUri", applicationContext)

            val outputData = workDataOf(KEY_IMAGE_URI to outputUri.toString())
            Result.success(outputData)
        } catch (throwable: Throwable) {
            Timber.e(throwable)
            Result.failure()
        }

    }
}