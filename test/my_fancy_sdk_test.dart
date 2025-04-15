import 'package:flutter_test/flutter_test.dart';
import 'package:my_fancy_sdk/my_fancy_sdk_method_channel.dart';
import 'package:my_fancy_sdk/my_fancy_sdk_platform_interface.dart';

void main() {
  final MyFancySdkPlatform initialPlatform = MyFancySdkPlatform.instance;

  test('$MethodChannelMyFancySdk is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelMyFancySdk>());
  });
}
