import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';

import 'my_fancy_sdk_platform_interface.dart';

/// An implementation of [MyFancySdkPlatform] that uses method channels.
class MethodChannelMyFancySdk extends MyFancySdkPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('my_fancy_sdk');

  @override
  Future<Widget> initializeSdk() async {
    String result = "SDK not initialized";

    try {
      result = await methodChannel.invokeMethod("initializeSdk");
    } on PlatformException catch (e) {
      print('Failed to initialize SDK: ${e.message}');
    }

    return Text(result);
  }

  @override
  Future<Widget> createFile() async {
    try {
      final result = await methodChannel.invokeMethod("createFile");
      return Text(result);
    } on PlatformException catch (e) {
      print('Failed to create a file: ${e.message}');
    }

    return SizedBox.shrink();
  }

  @override
  Future<Widget> loadBannerAd() async {
    Widget loadBannerWidget = SizedBox.shrink();

    try {
      final int viewId = await methodChannel.invokeMethod("loadBannerAd");
      loadBannerWidget = Expanded(
        child: PlatformViewLink(
          viewType: "linear-layout-view",
          surfaceFactory: (
            BuildContext context,
            PlatformViewController controller,
          ) {
            return AndroidViewSurface(
              controller: controller as AndroidViewController,
              gestureRecognizers:
                  const <Factory<OneSequenceGestureRecognizer>>{},
              hitTestBehavior: PlatformViewHitTestBehavior.opaque,
            );
          },
          onCreatePlatformView: (PlatformViewCreationParams params) {
            return PlatformViewsService.initExpensiveAndroidView(
                id: params.id,
                viewType: "linear-layout-view",
                layoutDirection: TextDirection.ltr,
                creationParams: {'id': viewId},
                creationParamsCodec: const StandardMessageCodec(),
              )
              ..addOnPlatformViewCreatedListener(params.onPlatformViewCreated)
              ..create();
          },
        ),
      );
    } on PlatformException catch (e) {
      print('Failed to load a banner ad: ${e.message}');
    }

    return loadBannerWidget;
  }

  @override
  Future<void> showFullscreenAd() async {
    try {
      await methodChannel.invokeMethod("showFullscreenAd");
    } on PlatformException catch (e) {
      print('Failed to show fullscreen ad: ${e.message}');
    }
  }
}
