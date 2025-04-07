
import 'my_fancy_sdk_platform_interface.dart';

class MyFancySdk {
  Future<String?> getPlatformVersion() {
    return MyFancySdkPlatform.instance.getPlatformVersion();
  }
}
