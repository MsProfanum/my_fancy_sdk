package com.example.my_fancy_sdk

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.runtimeaware.sdk.BannerAd
import com.runtimeaware.sdk.FullscreenAd
import com.runtimeaware.sdk.ExistingSdk
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

// Have to use the FlutterFragmentActivity instead of FlutterActivity
// because we only want to show the view on the part of the screen.
class MyFancySdkPlugin : FlutterFragmentActivity(), FlutterPlugin, MethodCallHandler {
  val viewsId = AtomicInteger(0)
  val composeViews = mutableMapOf<Int, ComposeView>()
  val linearLayouts = mutableMapOf<Int, LinearLayout>()
  private var runtimeAwareSdk = ExistingSdk(this)

  private lateinit var methodChannel: MethodChannel
  private lateinit var bannerAd: BannerAd



  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    methodChannel = MethodChannel(
      binding.getBinaryMessenger(), CHANNEL,
    )
    methodChannel.setMethodCallHandler { call, result ->
      when (call.method) {
        "initializeSdk" -> {

          lifecycleScope.launch {
            if (!runtimeAwareSdk.initialize()) {
              result.success("Failed to initialize SDK")
            } else {
              result.success("Initialized SDK!")
            }

          }
        }

        "createFile" -> {

          lifecycleScope.launch {
            val success = runtimeAwareSdk.createFile(3)

            if (success == null) {
              result.success("Please load the SDK first!")
            } else {
              result.success(success)
            }

          }
        }

        "getRandomNumber" -> {
          val composeView = getRandomNumber()
          composeViews[composeView.id] = composeView
          result.success(composeView.id)
        }

        "loadBannerAd" -> {

          val attr: AttributeSet? = null

          lifecycleScope.launch {
            bannerAd = BannerAd(this@MyFancySdkPlugin)

            var linearLayout = createLinearLayout(this@MyFancySdkPlugin)
            linearLayouts[linearLayout.id] = linearLayout
            linearLayout.addView(bannerAd)

            bannerAd.loadAd(
              this@MyFancySdkPlugin,
              PACKAGE_NAME,
              shouldStartActivityPredicate(),
              false,
              "NONE"
            )

            result.success(linearLayout.id)
          }
        }

        "showFullscreenAd" -> {
          lifecycleScope.launch {
            val fullscreenAd = FullscreenAd.create(this@MyFancySdkPlugin, "NONE")
            fullscreenAd.show(this@MyFancySdkPlugin, shouldStartActivityPredicate())
          }
        }

        else -> result.notImplemented()
      }
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    methodChannel.setMethodCallHandler(null)
  }

  override fun onMethodCall(
    call: MethodCall,
    result: MethodChannel.Result,
  ) {
    when (call.method) {
      "initializeSdk" -> {

        lifecycleScope.launch {
          if (!runtimeAwareSdk.initialize()) {
            result.success("Failed to initialize SDK")
          } else {
            result.success("Initialized SDK!")
          }

        }
      }

      "createFile" -> {

        lifecycleScope.launch {
          val success = runtimeAwareSdk.createFile(3)

          if (success == null) {
            result.success("Please load the SDK first!")
          } else {
            result.success(success)
          }

        }
      }

      "getRandomNumber" -> {
        val composeView = getRandomNumber()
        composeViews[composeView.id] = composeView
        result.success(composeView.id)
      }

      "loadBannerAd" -> {

        val attr: AttributeSet? = null

        lifecycleScope.launch {
          bannerAd = BannerAd(this@MyFancySdkPlugin)

          var linearLayout = createLinearLayout(this@MyFancySdkPlugin)
          linearLayouts[linearLayout.id] = linearLayout
          linearLayout.addView(bannerAd)

          bannerAd.loadAd(
            this@MyFancySdkPlugin,
            PACKAGE_NAME,
            shouldStartActivityPredicate(),
            false,
            "NONE"
          )

          result.success(linearLayout.id)
        }
      }

      "showFullscreenAd" -> {
        lifecycleScope.launch {
          val fullscreenAd = FullscreenAd.create(this@MyFancySdkPlugin, "NONE")
          fullscreenAd.show(this@MyFancySdkPlugin, shouldStartActivityPredicate())
        }
      }

      else -> result.notImplemented()
    }
  }

  override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
    super.configureFlutterEngine(flutterEngine)

    MethodChannel(
      flutterEngine.dartExecutor.binaryMessenger,
      CHANNEL
    ).setMethodCallHandler { call, result ->
      when (call.method) {
        "initializeSdk" -> {

          lifecycleScope.launch {
            if (!runtimeAwareSdk.initialize()) {
              result.success("Failed to initialize SDK")
            } else {
              result.success("Initialized SDK!")
            }

          }
        }

        "createFile" -> {

          lifecycleScope.launch {
            val success = runtimeAwareSdk.createFile(3)

            if (success == null) {
              result.success("Please load the SDK first!")
            } else {
              result.success(success)
            }

          }
        }

        "getRandomNumber" -> {
          val composeView = getRandomNumber()
          composeViews[composeView.id] = composeView
          result.success(composeView.id)
        }

        "loadBannerAd" -> {

          val attr: AttributeSet? = null

          lifecycleScope.launch {
            bannerAd = BannerAd(this@MyFancySdkPlugin)

            var linearLayout = createLinearLayout(this@MyFancySdkPlugin)
            linearLayouts[linearLayout.id] = linearLayout
            linearLayout.addView(bannerAd)

            bannerAd.loadAd(
              this@MyFancySdkPlugin,
              PACKAGE_NAME,
              shouldStartActivityPredicate(),
              false,
              "NONE"
            )

            result.success(linearLayout.id)
          }
        }

        "showFullscreenAd" -> {
          lifecycleScope.launch {
            val fullscreenAd = FullscreenAd.create(this@MyFancySdkPlugin, "NONE")
            fullscreenAd.show(this@MyFancySdkPlugin, shouldStartActivityPredicate())
          }
        }

        else -> result.notImplemented()
      }
    }

    flutterEngine.platformViewsController.registry.registerViewFactory(
      "compose-view",
      ComposeViewFactory(this)
    )
    flutterEngine.platformViewsController.registry.registerViewFactory(
      "linear-layout-view", LinearLayoutViewFactory(this)
    )
  }

  private fun shouldStartActivityPredicate(): () -> Boolean {
    return { true }
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


  private fun getRandomNumber(): ComposeView {
    val randomNumber = Random.nextInt(0, 100)
    val viewId = viewsId.incrementAndGet()
    return ComposeView(this).apply {
      id = viewId // Set the view
      setContent {
        Box(
          modifier = Modifier
            .size(200.dp)
            .background(Color.Red),
          contentAlignment = Alignment.Center
        ) {
          Text(text = "Random Number: $randomNumber")
        }
      }
    }
  }

  companion object {
    private const val CHANNEL = "my_fancy_sdk"
    private const val PACKAGE_NAME = "com.example.my_fancy_sdk"
  }
}


class ComposeViewFactory(private val activity: MyFancySdkPlugin) :
  PlatformViewFactory(StandardMessageCodec.INSTANCE) {
  override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
    val id = (args as Map<String, Any?>)["id"] as Int
    val composeView = activity.composeViews[id]
      ?: throw IllegalArgumentException("No ComposeView found with id: $id")

    return ComposeViewAndroid(composeView)
  }
}

class ComposeViewAndroid(private val composeView: ComposeView) : PlatformView {
  override fun getView(): View = composeView

  override fun dispose() {}

}


class LinearLayoutViewFactory(private val activity: MyFancySdkPlugin) :
  PlatformViewFactory(StandardMessageCodec.INSTANCE) {
  override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
    val id = (args as Map<String, Any?>)["id"] as Int
    val linearLayout = activity.linearLayouts[id]
      ?: throw IllegalArgumentException("No LinearLayout found with id: $id")
    return LinearLayoutViewAndroid(linearLayout)
  }
}

class LinearLayoutViewAndroid(private val linearLayout: LinearLayout) : PlatformView {
  override fun getView(): View = linearLayout

  override fun dispose() {}
}