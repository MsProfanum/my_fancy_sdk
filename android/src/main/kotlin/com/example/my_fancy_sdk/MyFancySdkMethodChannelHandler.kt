package com.example.my_fancy_sdk

import android.content.Context
import io.flutter.plugin.common.MethodChannel
import androidx.lifecycle.lifecycleScope
import com.runtimeaware.sdk.ExistingSdk
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import kotlinx.coroutines.launch
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.my_fancy_sdk.MyFancySdkPlugin
import com.runtimeaware.sdk.BannerAd
import com.runtimeaware.sdk.FullscreenAd
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.atomic.AtomicInteger


class MyFancySdkMethodChannelHandler (
    val runtimeAwareSdk: ExistingSdk,
    val context: Context,
    val activity: FragmentActivity,
    val linearLayouts: MutableMap<Int, LinearLayout>,
    ) :
    MethodCallHandler {
    val viewsId = AtomicInteger(0)

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when (call.method) {
            "initializeSdk" -> {
                activity.lifecycleScope.launch {
                    try {
                        if (!runtimeAwareSdk.initialize()) {
                            result.success("Failed to initialize SDK")
                        } else {
                            result.success("Initialized SDK!")
                        }
                    } catch (e: Exception) {
                        result.success("Error caught: $e")
                    }
                }
            }

            "createFile" -> {
                activity.lifecycleScope.launch {
                    val success = runtimeAwareSdk.createFile(3)

                    if (success == null) {
                        result.success("Please load the SDK first!")
                    } else {
                        result.success(success)
                    }

                }
            }

            "loadBannerAd" -> {
                activity.lifecycleScope.launch {
                    try {
                        val bannerAd = BannerAd(context)

                        var linearLayout = createLinearLayout(context)
                        linearLayouts[linearLayout.id] = linearLayout
                        linearLayout.addView(bannerAd)

                        bannerAd.loadAd(
                            activity,
                            "com.example.my_fancy_sdk",
                            shouldStartActivityPredicate(),
                            false,
                            "NONE"
                        )

                        result.success(linearLayout.id)
                    } catch (e: Exception) {
                        result.error("loadBannerAd_error", "Error caught: $e", null)
                    }
                }
            }

            "showFullscreenAd" -> {
                activity.lifecycleScope.launch {
                    try {
                        val fullscreenAd = FullscreenAd.create(context, "NONE")
                        fullscreenAd.show(activity, shouldStartActivityPredicate())
                    } catch (e: Exception) {
                        result.error("showFullscreenAd_error", "Error caught: $e", null)
                    }
                }
            }

            else -> result.notImplemented()
        }
    }

    private fun createLinearLayout(context: Context): LinearLayout {
        val linearLayout = LinearLayout(context)

        // Set layout orientation (e.g., vertical or horizontal)
        linearLayout.orientation = LinearLayout.VERTICAL // Or LinearLayout.HORIZONTAL

        // Set layout width and height
        linearLayout.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        //  Optional: Add some styling (example)
        linearLayout.setBackgroundColor(android.graphics.Color.GREEN)
        linearLayout.setPadding(16, 16, 16, 16) // Example padding
        linearLayout.id = viewsId.incrementAndGet()

        return linearLayout
    }

    private fun shouldStartActivityPredicate(): () -> Boolean {
        return { true }
    }
}


