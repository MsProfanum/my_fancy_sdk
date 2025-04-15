import 'package:flutter/widgets.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'my_fancy_sdk_method_channel.dart';

abstract class MyFancySdkPlatform extends PlatformInterface {
  /// Constructs a MyFancySdkPlatform.
  MyFancySdkPlatform() : super(token: _token);

  static final Object _token = Object();

  static MyFancySdkPlatform _instance = MethodChannelMyFancySdk();

  /// The default instance of [MyFancySdkPlatform] to use.
  ///
  /// Defaults to [MethodChannelMyFancySdk].
  static MyFancySdkPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [MyFancySdkPlatform] when
  /// they register themselves.
  static set instance(MyFancySdkPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<Widget> initializeSdk() {
    throw UnimplementedError('initializeSdk() has not been implemented.');
  }

  Future<Widget> createFile() {
    throw UnimplementedError('createFile() has not been implemented.');
  }

  Future<Widget> loadBannerAd() {
    throw UnimplementedError('loadBannerAd() has not been implemented.');
  }

  Future<void> showFullscreenAd() {
    throw UnimplementedError('loadBannerAd() has not been implemented.');
  }
}
