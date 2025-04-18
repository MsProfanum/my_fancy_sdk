package com.example.my_fancy_sdk

import android.app.Activity
import android.content.Context
import android.util.Log
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
import java.util.concurrent.atomic.AtomicInteger

// Have to use the FlutterFragmentActivity instead of FlutterActivity
// because we only want to show the view on the part of the screen.
class MyFancySdkPlugin : FlutterFragmentActivity(), FlutterPlugin {
  val composeViews = mutableMapOf<Int, ComposeView>()
  val linearLayouts = mutableMapOf<Int, LinearLayout>()
  private lateinit var methodChannel: MethodChannel

  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    methodChannel = MethodChannel(
      binding.getBinaryMessenger(), CHANNEL,
    )
    val runtimeAwareSdk = ExistingSdk(binding.applicationContext)

    val methodChannelHandler = MyFancySdkMethodChannelHandler(
      runtimeAwareSdk,
      binding.applicationContext,
      this@MyFancySdkPlugin,
      linearLayouts,
      )
    methodChannel.setMethodCallHandler(methodChannelHandler)
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    methodChannel.setMethodCallHandler(null)
  }

  override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
    super.configureFlutterEngine(flutterEngine)

    flutterEngine.platformViewsController.registry.registerViewFactory(
      "compose-view",
      ComposeViewFactory(this)
    )
    flutterEngine.platformViewsController.registry.registerViewFactory(
      "linear-layout-view", LinearLayoutViewFactory(this)
    )
  }

  companion object {
    private const val CHANNEL = "my_fancy_sdk"
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