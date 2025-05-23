import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:my_fancy_sdk/my_fancy_sdk_method_channel.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  MethodChannelMyFancySdk platform = MethodChannelMyFancySdk();
  const MethodChannel channel = MethodChannel('my_fancy_sdk');

  setUp(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, (MethodCall methodCall) async {
          return '42';
        });
  });

  tearDown(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, null);
  });
}
