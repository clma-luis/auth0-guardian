#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(Auth0GuardianModule, NSObject)

RCT_EXTERN_METHOD(getOTP:(NSString *)secret resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)

@end
