import 'package:flutter/widgets.dart';

import 'my_fancy_sdk_platform_interface.dart';

class MyFancySdk {
  Future<Widget> initializeSdk() {
    return MyFancySdkPlatform.instance.initializeSdk();
  }

  Future<Widget> createFile() {
    return MyFancySdkPlatform.instance.createFile();
  }

  Future<Widget> loadBannerAd() {
    return MyFancySdkPlatform.instance.loadBannerAd();
  }

  Future<void> showFullscreenAd() {
    return MyFancySdkPlatform.instance.showFullscreenAd();
  }
}
