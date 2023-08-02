import 'package:flutter/material.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:registration_client/provider/global_provider.dart';
import 'package:registration_client/provider/registration_task_provider.dart';

class AcknowledgementPage extends StatefulWidget {
  const AcknowledgementPage({super.key});

  @override
  State<AcknowledgementPage> createState() => _AcknowledgementPageState();
}

class _AcknowledgementPageState extends State<AcknowledgementPage> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 400.h,
      width: 864.w,
      padding: EdgeInsets.only(top: 33.h),
      child: Column(
        children: [
          InAppWebView(
            initialData: InAppWebViewInitialData(
              data: context.watch<RegistrationTaskProvider>().previewTemplate,
            ),
          ),
        ],
      ),
    );
  }
}
