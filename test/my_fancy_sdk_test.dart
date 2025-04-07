import 'package:flutter_test/flutter_test.dart';
import 'package:my_fancy_sdk/my_fancy_sdk.dart';
import 'package:my_fancy_sdk/my_fancy_sdk_platform_interface.dart';
import 'package:my_fancy_sdk/my_fancy_sdk_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockMyFancySdkPlatform
    with MockPlatformInterfaceMixin
    implements MyFancySdkPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final MyFancySdkPlatform initialPlatform = MyFancySdkPlatform.instance;

  test('$MethodChannelMyFancySdk is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelMyFancySdk>());
  });

  test('getPlatformVersion', () async {
    MyFancySdk myFancySdkPlugin = MyFancySdk();
    MockMyFancySdkPlatform fakePlatform = MockMyFancySdkPlatform();
    MyFancySdkPlatform.instance = fakePlatform;

    expect(await myFancySdkPlugin.getPlatformVersion(), '42');
  });
}
