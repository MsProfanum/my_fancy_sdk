import 'package:flutter/material.dart';
import 'package:my_fancy_sdk/my_fancy_sdk.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final _myFancySdkPlugin = MyFancySdk();

  @override
  void initState() {
    super.initState();
    //initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  // Future<void> initPlatformState() async {
  //   String platformVersion;
  //   // Platform messages may fail, so we use a try/catch PlatformException.
  //   // We also handle the message potentially returning null.
  //   try {
  //     platformVersion =
  //         await _myFancySdkPlugin.getPlatformVersion() ??
  //         'Unknown platform version';
  //   } on PlatformException {
  //     platformVersion = 'Failed to get platform version.';
  //   }
  //
  //   // If the widget was removed from the tree while the asynchronous platform
  //   // message was in flight, we want to discard the reply rather than calling
  //   // setState to update our non-existent appearance.
  //   if (!mounted) return;
  //
  //   setState(() {
  //     _platformVersion = platformVersion;
  //   });
  // }

  @override
  Widget build(BuildContext context) {
    Widget _initializedSdkWidget = Text("");
    Widget _sdkWidget = SizedBox.shrink();

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: const Text('Plugin example app')),
        body: Center(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              _initializedSdkWidget,
              ElevatedButton(
                onPressed: () async {
                  final newSdkWidget = await _myFancySdkPlugin.initializeSdk();
                  setState(() {
                    _initializedSdkWidget = newSdkWidget;
                  });
                },
                child: Text('Initialize SDK'),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: () async {
                  final newSdkWidget = await _myFancySdkPlugin.createFile();
                  setState(() {
                    _sdkWidget = newSdkWidget;
                  });
                },
                child: Text('Create file'),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: () async {
                  final newSdkWidget = await _myFancySdkPlugin.loadBannerAd();
                  setState(() {
                    _sdkWidget = newSdkWidget;
                  });
                },
                child: Text('Load banner ad'),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: () async {
                  await _myFancySdkPlugin.showFullscreenAd();
                },
                child: Text('Show fullscreen ad'),
              ),
              SizedBox(height: 20),
              _sdkWidget,
            ],
          ),
        ),
      ),
    );
  }
}
