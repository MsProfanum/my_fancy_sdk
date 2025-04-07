import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'my_fancy_sdk_platform_interface.dart';

/// An implementation of [MyFancySdkPlatform] that uses method channels.
class MethodChannelMyFancySdk extends MyFancySdkPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('my_fancy_sdk');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
